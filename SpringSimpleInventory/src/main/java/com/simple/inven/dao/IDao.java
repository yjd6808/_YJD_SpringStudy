package com.simple.inven.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.dto.InvenDto;
import com.simple.inven.dto.InvenItemDto;
import com.simple.inven.dto.ItemDto;

public interface IDao {
	ArrayList<AccountDto> accounts();						// 모든 계정 목록
	ArrayList<AccountDto> getAccount(int user_uid);			// 특정 계정
	int register(AccountDto inputAccount);					// 화원가입
	void createInventory(int userUid, String invenName);	// 인벤토리 생성 - 회원가입과 동시에 인벤토리 생성됨
	InvenDto getInventory(int user_uid);						// 인벤토리 정보
	ArrayList<InvenItemDto> listInvenItems(int invenUid);	// 인벤토리 아이템 목록
	ArrayList<ItemDto> listShopItems();						// 상점 아이템 목록
	ItemDto getShopItem(int item_uid);						// 특정 상점 아이템 정보
	
	int deleteInvenItem(int u_id);							// 인벤토리에서 특정 아이템 제거
	int insertInvenItem(int item_uid, int inven_uid, int quantity);// 인벤토리에 아이템 추가
	int updateInvenItem(int u_id, int quantity);			// 인벤토리 아이템 수량 변경
	int updateMoney(int user_uid, int money);				// 돈 업데이트
	InvenItemDto getInvenItem(int inven_item_uid);			// 인벤토리 아이템 정보 얻기
}
