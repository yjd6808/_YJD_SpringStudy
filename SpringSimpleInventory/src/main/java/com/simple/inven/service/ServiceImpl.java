package com.simple.inven.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simple.inven.dao.IDao;
import com.simple.inven.dto.AccountDto;
import com.simple.inven.dto.InvenDto;
import com.simple.inven.dto.InvenItemDto;
import com.simple.inven.dto.ItemDto;

@Service("simpleService")
public class ServiceImpl implements IService {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public ServiceResult login(AccountDto inputAccount) {
		
		ArrayList<AccountDto> accounts = sqlSession.getMapper(IDao.class).accounts();
		AccountDto myAccount = null;
		
		for (int i = 0; i < accounts.size(); i++) {
			AccountDto account = accounts.get(i);
			
			if (account.getUserId().equals(inputAccount.getUserId())) {
				myAccount = account;
				break;
			}
		}
		
		// 입력받은 아이디가 존재하지 않는 경우 회원가입 진행
		if (myAccount == null) {
			return register(inputAccount);
		}
		
		// 입력받은 아이디가 존재하는 경우 입력받은 비밀번호를 비교하여 일치할 경우 로그인 성공
		if (!myAccount.getUserPass().equals(inputAccount.getUserPass()))
			return new ServiceResult(false, "비밀번호가 일치하지 않습니다.");
		
		return new ServiceResultWithData<Integer>(true, "로그인에 성공하였습니다.", myAccount.getU_id());
	}


	
	
	// 계정을 생성하면서 인벤토리도 같이 만들어줌
	@Override
	@Transactional
	public ServiceResult register(AccountDto inputAccount) {
		try {
			sqlSession.getMapper(IDao.class).register(inputAccount);
			sqlSession.getMapper(IDao.class).createInventory(inputAccount.getU_id(), "기본 인벤토리");
			return new ServiceResultWithData<Integer>(true, "성공적으로 회원가입 및 로그인하였습니다.", inputAccount.getU_id());
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResult(false, "회원가입에 실패하여 로그인을 하지 못했습니다.");
		}
	}

	@Override
	public InvenDto getInventory(int user_uid) {
		return sqlSession.getMapper(IDao.class).getInventory(user_uid);
	}


	@Override
	public ArrayList<InvenItemDto> listInvenItems(int inven_uid) {
		return sqlSession.getMapper(IDao.class).listInvenItems(inven_uid);
	}


	@Override
	public ArrayList<ItemDto> listShopItems() {
		return sqlSession.getMapper(IDao.class).listShopItems();
	}
	
	@Override
	public AccountDto getAccount(int user_uid) {
		ArrayList<AccountDto> accounts = sqlSession.getMapper(IDao.class).getAccount(user_uid);
		
		if (accounts.size() == 0) {
			return null;
		}
		
		return accounts.get(0);
	}
	
	@Override
	public ItemDto getShopItem(int item_uid) {
		return sqlSession.getMapper(IDao.class).getShopItem(item_uid);
	}


	@Transactional
	@Override
	public ServiceResult buyItem(int user_uid, int item_uid, int quantity) {
		ServiceResult serviceResult = new ServiceResult();
		
		AccountDto accountDto = getAccount(user_uid);
		
		if (accountDto == null) {
			return new ServiceResult(false, "로그인을 먼저 해주세요. (accountDto == null)");
		}
		
		InvenDto invenDto = getInventory(user_uid);
		ItemDto itemDto = getShopItem(item_uid);
		
		if (invenDto == null) {
			return new ServiceResult(false, "인벤토리가 생성되지 않았군요 ㄷㄷ 재가입해주세요 원래 가입하면 자동으로 인벤토리가 만들어져야합니다. (invenDto == null)");
		}
		
		if (itemDto == null) {
			return new ServiceResult(false, "그런 아이템은 존재하지 않습니다. (itemDto == null)");
		}
		
		if (quantity > itemDto.getMaxQuantity()) {
			serviceResult.setStatus(-1);
			serviceResult.setMessage(String.format("%s 아이템은 한번에 %d개 까지만 구매가능합니다.",
					itemDto.getItemName(), itemDto.getMaxQuantity()));
			return serviceResult;
		}
		
		if (itemDto.getBuyPrice() * quantity > accountDto.getMoney()) {
			serviceResult.setStatus(-2);
			serviceResult.setMessage(String.format("%s 아이템을 구매하고 싶지만 돈이 부족합니다.",
					itemDto.getItemName()));
			return serviceResult;
		}
			
		// 금액 수정
		int updateMoney = accountDto.getMoney() - itemDto.getBuyPrice() * quantity;
		int moneyUpdateResult = sqlSession.getMapper(IDao.class)
				.updateMoney(user_uid, updateMoney);
		
		if (moneyUpdateResult == 0) {
			serviceResult.setStatus(-3);
			serviceResult.setMessage(String.format("%s 아이템을 구매에 실패하였습니다.(user_uid에 해당하는 계정이 없음)",
					itemDto.getItemName()));
			return serviceResult;
		}
		
		// 인벤토리에 아이템 넣기
		int insertionResult = sqlSession.getMapper(IDao.class)
				.insertInvenItem(item_uid, invenDto.getU_id(), quantity);
		
		if (insertionResult == 0) {
			serviceResult.setStatus(-3);
			serviceResult.setMessage(String.format("%s 아이템을 구매에 실패하였습니다. (inven_uid에 해당하는 인벤토리가 없음)",
					itemDto.getItemName()));
			return serviceResult;
		}
		
		serviceResult.setStatus(0);
		serviceResult.setSuccess(true);
		serviceResult.setMessage(itemDto.getItemName() + " 아이템을 성공적으로 구매하였습니다.");
		
		return serviceResult;
	}




	@Override
	public int deleteInvenItem(int u_id) {
		return sqlSession.getMapper(IDao.class).deleteInvenItem(u_id);
	}

	@Override
	public int updateInvenItem(int u_id, int quantity) {
		return sqlSession.getMapper(IDao.class).updateInvenItem(u_id, quantity);
	}
	
	@Override
	public InvenItemDto getInventoryItem(int inven_item_uid) {
		return sqlSession.getMapper(IDao.class).getInvenItem(inven_item_uid);
	}
	
	@Override
	public ServiceResult sellItem(int user_uid, int inven_item_uid, int quantity) {
		AccountDto accountDto = getAccount(user_uid);
		InvenItemDto invenItemDto = getInventoryItem(inven_item_uid);
		
		if (invenItemDto == null) {
			return new ServiceResult(false, "그런 아이템은 존재하지 않습니다. (invenItemDto == null)");
		}
		
		if (quantity > invenItemDto.getQuantity()) {
			String message = String.format("갯수를 정확히 입력해주세요.\n"
					+ "해당 인벤토리 칸에 소지중인 아이템 수 : %d\n"
					+ "팔고자하는 아이템 수 : %d", invenItemDto.getQuantity(), quantity);
			return new ServiceResult(false, message);
		}
		
		if (quantity == invenItemDto.getQuantity()) {
			return handleSellingAllItems(inven_item_uid);
		} 
		
		return handleSellingSomeItems(inven_item_uid, invenItemDto.getQuantity() - quantity);
	}
	
	private ServiceResult handleSellingSomeItems(int inven_item_uid, int quantity) {
		int result = updateInvenItem(inven_item_uid, quantity);
		if (result == 0) {
			return new ServiceResult(false, "아이템 판매에 실패하였습니다.");
		}
		return new ServiceResult(true, "아이템 판매에 성공하였습니다." + quantity + "개");
	}

	private ServiceResult handleSellingAllItems(int inven_item_uid) {
		int result = deleteInvenItem(inven_item_uid);
		if (result == 0) {
			return new ServiceResult(false, "아이템 완전 판매에 실패하였습니다.");
		}
		return new ServiceResult(true, "아이템 완전 판매에 성공하였습니다.");
	}
}
