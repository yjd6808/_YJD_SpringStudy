-- ���� : �κ��丮 ���� SQL
-- ���̺� ���λ� : zt_ :
--      z : ���̺� �� ���Ŀ뵵 (�ٸ� ���̺�� ���̴� �� �����ϱ� ����)
--      t : ���̺� ����

-- ���� ���̺�
create table zt_account (
    u_id         number(10)      primary key,       -- ���� UID
    user_id      varchar2(30)    not null,          -- ���� ���̵�
    user_pass    varchar2(30)    not null,          -- ���� ���
    money        number(10)      default 0
);


create sequence zt_account_seq start with 1 increment by 1;

-- �κ��丮 ���̺�
create table zt_inventory (
    u_id            number(10)      primary key,        --  �κ��丮 ID
    user_uid        number(10)      not null,           --  �κ��� ������ ���� ID
    inven_name      varchar2(30)    not null,           --  �κ��丮 �̸�
    cur_size        number(10)      default 5,          --  �ʱ� �κ� ũ�� 5 (�Ⱦ���)
    max_size        number(10)      default 100         --  �ִ� �κ� ũ�� 100 (�Ⱦ���)
);

alter table zt_inventory
  add constraint zt_inventory_fk 
      foreign key(user_uid)
      references zt_account(u_id);

create sequence zt_inventory_seq start with 1 increment by 1;

-- ������ ���� ���̺�
create table zt_item (
    u_id            number(10)      primary key,        --  ������ ���� ID
    item_name       varchar2(30)    not null,           --  ������ �̸�
    item_type       varchar2(10)    not null,           --  ������ Ÿ�� (����, ����, ����, ���)
    buy_price       number(20)      default 0,          --  ������ ���� ����
    sell_price      number(20)      default 0,          --  ������ �Ǹ� ����
    max_quantity    varchar2(10)    default 1           --  �ִ� ���� ������ ����
);

create sequence zt_item_seq start with 1 increment by 1;

-- ������ ���� �ʱ�ȭ
insert into zt_item values (zt_item_seq.nextval, '��',        '����',       50,         30,     1);
insert into zt_item values (zt_item_seq.nextval, '�ΰ�',      '����',       100,         50,     1);
insert into zt_item values (zt_item_seq.nextval, '���� ��',   '����',       200,         100,     1);
insert into zt_item values (zt_item_seq.nextval, '���� ����',  '����',       200,         100,     1);
insert into zt_item values (zt_item_seq.nextval, '���� ����',  '�Ҹ�ǰ',     50,          10,     100);
insert into zt_item values (zt_item_seq.nextval, '��Ȳ ����',  '�Ҹ�ǰ',     200,         40,     100);


-- �κ��丮�� �����ϴ� ������
create table zt_inventory_item (
    u_id            number(10)      primary key,        --  �κ��丮�� �����ϴ� ������ ID
    inven_uid       number(10)      not null,           --  � �κ��丮 �Ҽ����� Ȯ���� ���� �κ��丮 ID
    item_uid        number(10)      not null,           --  ������ ���� Ȯ��
    quantity        number(10)      default 1           --  ������ ����
);

alter table zt_inventory_item
  add constraint zt_inventory_item_inven_uid_fk 
      foreign key(inven_uid)
      references zt_inventory(u_id);

alter table zt_inventory_item
  add constraint zt_inventory_item_item_uid_fk 
      foreign key(item_uid)
      references zt_item(u_id);


create sequence zt_inventory_item_seq start with 1 increment by 1;
