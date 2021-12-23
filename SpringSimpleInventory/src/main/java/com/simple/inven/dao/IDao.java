package com.simple.inven.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.dto.InvenDto;
import com.simple.inven.dto.InvenItemDto;
import com.simple.inven.dto.ItemDto;

public interface IDao {
	ArrayList<AccountDto> accounts();						// ��� ���� ���
	ArrayList<AccountDto> getAccount(int user_uid);			// Ư�� ����
	int register(AccountDto inputAccount);					// ȭ������
	void createInventory(int userUid, String invenName);	// �κ��丮 ���� - ȸ�����԰� ���ÿ� �κ��丮 ������
	InvenDto getInventory(int user_uid);						// �κ��丮 ����
	ArrayList<InvenItemDto> listInvenItems(int invenUid);	// �κ��丮 ������ ���
	ArrayList<ItemDto> listShopItems();						// ���� ������ ���
	ItemDto getShopItem(int item_uid);						// Ư�� ���� ������ ����
	
	int deleteInvenItem(int u_id);							// �κ��丮���� Ư�� ������ ����
	int insertInvenItem(int item_uid, int inven_uid, int quantity);// �κ��丮�� ������ �߰�
	int updateInvenItem(int u_id, int quantity);			// �κ��丮 ������ ���� ����
	int updateMoney(int user_uid, int money);				// �� ������Ʈ
	InvenItemDto getInvenItem(int inven_item_uid);			// �κ��丮 ������ ���� ���
}
