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
		
		// �Է¹��� ���̵� �������� �ʴ� ��� ȸ������ ����
		if (myAccount == null) {
			return register(inputAccount);
		}
		
		// �Է¹��� ���̵� �����ϴ� ��� �Է¹��� ��й�ȣ�� ���Ͽ� ��ġ�� ��� �α��� ����
		if (!myAccount.getUserPass().equals(inputAccount.getUserPass()))
			return new ServiceResult(false, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		
		return new ServiceResultWithData<Integer>(true, "�α��ο� �����Ͽ����ϴ�.", myAccount.getU_id());
	}


	
	
	// ������ �����ϸ鼭 �κ��丮�� ���� �������
	@Override
	@Transactional
	public ServiceResult register(AccountDto inputAccount) {
		try {
			sqlSession.getMapper(IDao.class).register(inputAccount);
			sqlSession.getMapper(IDao.class).createInventory(inputAccount.getU_id(), "�⺻ �κ��丮");
			return new ServiceResultWithData<Integer>(true, "���������� ȸ������ �� �α����Ͽ����ϴ�.", inputAccount.getU_id());
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResult(false, "ȸ�����Կ� �����Ͽ� �α����� ���� ���߽��ϴ�.");
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
			return new ServiceResult(false, "�α����� ���� ���ּ���. (accountDto == null)");
		}
		
		InvenDto invenDto = getInventory(user_uid);
		ItemDto itemDto = getShopItem(item_uid);
		
		if (invenDto == null) {
			return new ServiceResult(false, "�κ��丮�� �������� �ʾұ��� ���� �簡�����ּ��� ���� �����ϸ� �ڵ����� �κ��丮�� ����������մϴ�. (invenDto == null)");
		}
		
		if (itemDto == null) {
			return new ServiceResult(false, "�׷� �������� �������� �ʽ��ϴ�. (itemDto == null)");
		}
		
		if (quantity > itemDto.getMaxQuantity()) {
			serviceResult.setStatus(-1);
			serviceResult.setMessage(String.format("%s �������� �ѹ��� %d�� ������ ���Ű����մϴ�.",
					itemDto.getItemName(), itemDto.getMaxQuantity()));
			return serviceResult;
		}
		
		if (itemDto.getBuyPrice() * quantity > accountDto.getMoney()) {
			serviceResult.setStatus(-2);
			serviceResult.setMessage(String.format("%s �������� �����ϰ� ������ ���� �����մϴ�.",
					itemDto.getItemName()));
			return serviceResult;
		}
			
		// �ݾ� ����
		int updateMoney = accountDto.getMoney() - itemDto.getBuyPrice() * quantity;
		int moneyUpdateResult = sqlSession.getMapper(IDao.class)
				.updateMoney(user_uid, updateMoney);
		
		if (moneyUpdateResult == 0) {
			serviceResult.setStatus(-3);
			serviceResult.setMessage(String.format("%s �������� ���ſ� �����Ͽ����ϴ�.(user_uid�� �ش��ϴ� ������ ����)",
					itemDto.getItemName()));
			return serviceResult;
		}
		
		// �κ��丮�� ������ �ֱ�
		int insertionResult = sqlSession.getMapper(IDao.class)
				.insertInvenItem(item_uid, invenDto.getU_id(), quantity);
		
		if (insertionResult == 0) {
			serviceResult.setStatus(-3);
			serviceResult.setMessage(String.format("%s �������� ���ſ� �����Ͽ����ϴ�. (inven_uid�� �ش��ϴ� �κ��丮�� ����)",
					itemDto.getItemName()));
			return serviceResult;
		}
		
		serviceResult.setStatus(0);
		serviceResult.setSuccess(true);
		serviceResult.setMessage(itemDto.getItemName() + " �������� ���������� �����Ͽ����ϴ�.");
		
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
			return new ServiceResult(false, "�׷� �������� �������� �ʽ��ϴ�. (invenItemDto == null)");
		}
		
		if (quantity > invenItemDto.getQuantity()) {
			String message = String.format("������ ��Ȯ�� �Է����ּ���.\n"
					+ "�ش� �κ��丮 ĭ�� �������� ������ �� : %d\n"
					+ "�Ȱ����ϴ� ������ �� : %d", invenItemDto.getQuantity(), quantity);
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
			return new ServiceResult(false, "������ �Ǹſ� �����Ͽ����ϴ�.");
		}
		return new ServiceResult(true, "������ �Ǹſ� �����Ͽ����ϴ�." + quantity + "��");
	}

	private ServiceResult handleSellingAllItems(int inven_item_uid) {
		int result = deleteInvenItem(inven_item_uid);
		if (result == 0) {
			return new ServiceResult(false, "������ ���� �Ǹſ� �����Ͽ����ϴ�.");
		}
		return new ServiceResult(true, "������ ���� �Ǹſ� �����Ͽ����ϴ�.");
	}
}
