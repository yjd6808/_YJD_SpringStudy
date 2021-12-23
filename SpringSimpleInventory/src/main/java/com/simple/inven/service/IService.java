package com.simple.inven.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.dto.InvenDto;
import com.simple.inven.dto.InvenItemDto;
import com.simple.inven.dto.ItemDto;

public interface IService {
	ServiceResult login(AccountDto inputAccount);
	ServiceResult register(AccountDto inputAccount);
	InvenDto getInventory(int user_uid);
	ArrayList<InvenItemDto> listInvenItems(int invenUid);
	ArrayList<ItemDto> listShopItems();
	AccountDto getAccount(int user_uid);
	ItemDto getShopItem(int item_uid);
	int deleteInvenItem(int u_id);								 			 // �κ��丮���� Ư�� ������ ����
	ServiceResult buyItem(int user_uid, int item_uid, int quantity);		 // ������ ����
	int updateInvenItem(int u_id, int quantity);							 // �κ��丮�� ������ ���� ����
	ServiceResult sellItem(int user_uid, int inven_item_uid, int quantity);	 // ������ �Ǹ�
	InvenItemDto getInventoryItem(int inven_item_uid);						 // �κ��丮 ������ ���� ���
}
