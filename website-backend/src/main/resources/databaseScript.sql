--drop table DEATH_LIST;
drop table TRADE_LIST;

------------------- DEATH_LIST ---------------------------------
--create table DEATH_LIST (
--	DEATH_ID INT(10),
----	USER_ID number(10),
--	CHAR_NAME varchar2(23) not null,
--	CHAR_ASCENDENCY varchar2(50),
--	CHAR_LEVEL number(3) not null,
--	TIME_PLAYED number(10),
--	DEATH_LOCATION varchar2(50),
--	DEATH_DESCRIPTION varchar2(500),
--	constraint DEATH_ID_PK primary key (DEATH_ID)
--)
------------------- TRADE_LIST ---------------------------------
create table TRADE_LIST (
	ITEM_ID INT(10),
--	USER_ID number(10),
	NAME varchar(50),
	DESCRIPTION varchar(500),
	TRADE_URL varchar(100),
	PRICE_HISTORY_URL varchar(100),
	constraint ITEM_ID_PK primary key (ITEM_ID)
)
------------------- USER_LIST -----------------------------------
create table USER_LIST (
	NAME varchar(50),
	PASSWORD varchar(50),
	EMAIL varchar(50),
	constraint EMAIL_PK primary key (EMAIL)
)
-----------------------------------------------------------------

insert into TRADE_LIST values (1, "Unending Hunger", "Spectre Soul Eater Jewel", "https://poe.trade/search/huriumdutoheno", "https://poe.ninja/challengehc/unique-jewels/unending-hunger-cobalt-jewel");

insert into USER_LIST values ("Marshall", "pass", "test@gmail.com");

select * from trade_list;

select * from user_list;