-- 제목 : 인벤토리 예시 SQL
-- 테이블 접두사 : zt_ :
--      z : 테이블 명 정렬용도 (다른 테이블과 섞이는 걸 방지하기 위해)
--      t : 테이블 약자

-- 계정 테이블
create table zt_account (
    u_id         number(10)      primary key,       -- 계정 UID
    user_id      varchar2(30)    not null,          -- 계정 아이디
    user_pass    varchar2(30)    not null,          -- 계정 비번
    money        number(10)      default 0
);


create sequence zt_account_seq start with 1 increment by 1;

-- 인벤토리 테이블
create table zt_inventory (
    u_id            number(10)      primary key,        --  인벤토리 ID
    user_uid        number(10)      not null,           --  인벤을 소유한 유저 ID
    inven_name      varchar2(30)    not null,           --  인벤토리 이름
    cur_size        number(10)      default 5,          --  초기 인벤 크기 5 (안쓰임)
    max_size        number(10)      default 100         --  최대 인벤 크기 100 (안쓰임)
);

alter table zt_inventory
  add constraint zt_inventory_fk 
      foreign key(user_uid)
      references zt_account(u_id);

create sequence zt_inventory_seq start with 1 increment by 1;

-- 아이템 정보 테이블
create table zt_item (
    u_id            number(10)      primary key,        --  아이템 정보 ID
    item_name       varchar2(30)    not null,           --  아이템 이름
    item_type       varchar2(10)    not null,           --  아이템 타입 (무기, 상의, 하의, 등등)
    buy_price       number(20)      default 0,          --  아이템 구매 가격
    sell_price      number(20)      default 0,          --  아이템 판매 가격
    max_quantity    varchar2(10)    default 1           --  최대 소지 가능한 수량
);

create sequence zt_item_seq start with 1 increment by 1;

-- 아이템 정보 초기화
insert into zt_item values (zt_item_seq.nextval, '검',        '무기',       50,         30,     1);
insert into zt_item values (zt_item_seq.nextval, '두건',      '투구',       100,         50,     1);
insert into zt_item values (zt_item_seq.nextval, '낡은 옷',   '상의',       200,         100,     1);
insert into zt_item values (zt_item_seq.nextval, '낡은 바지',  '하의',       200,         100,     1);
insert into zt_item values (zt_item_seq.nextval, '빨간 포션',  '소모품',     50,          10,     100);
insert into zt_item values (zt_item_seq.nextval, '주황 포션',  '소모품',     200,         40,     100);


-- 인벤토리에 존재하는 아이템
create table zt_inventory_item (
    u_id            number(10)      primary key,        --  인벤토리에 존재하는 아이템 ID
    inven_uid       number(10)      not null,           --  어떤 인벤토리 소속인지 확인을 위한 인벤토리 ID
    item_uid        number(10)      not null,           --  아이템 정보 확인
    quantity        number(10)      default 1           --  아이템 갯수
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
