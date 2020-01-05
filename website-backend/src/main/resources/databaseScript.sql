--drop table DEATH_LIST;
drop table TRADE_LIST;
drop table USER_LIST;

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
	EMAIL_ID VARCHAR(50),
	NAME varchar(50),
	DESCRIPTION varchar(500),
	TRADE_URL varchar(100),
	PRICE_HISTORY_URL varchar(100),
	constraint ITEM_ID_PK primary key (ITEM_ID),
	constraint EMAIL_ID_FK FOREIGN KEY (EMAIL_ID) REFERENCES USER_LIST(EMAIL)
)
------------------- USER_LIST -----------------------------------
create table USER_LIST (
	NAME varchar(50),
	PASSWORD varchar(50),
	EMAIL varchar(50),
	USER_ID INT(10) UNIQUE,	
	constraint EMAIL_PK primary key (EMAIL)	
)
------------------- COLLECTION_LIST ----------------------
create table COLLECTION_LIST (
	COLLECTION_ID INT(10),
	COLLECTION_NAME VARCHAR(50),
	constraint COLLECTION_ID_PK primary key (COLLECTION_ID)	
)
------------------- LEAGUE_LIST ----------------------
create table LEAGUE_LIST (
	LEAGUE_ID INT(10),
	LEAGUE_NAME VARCHAR(50),
	constraint LEAGUE_ID_PK primary key (LEAGUE_ID)	
)
------------------- SEARCH_COLLECTION_LIST ----------------------
create table SEARCH_COLLECTION_LIST (
	SEARCH_COLLECTION_ID INT(10),
	COLLECTION_ID INT(10),
	SEARCH_ID INT(10),
	LEAGUE_ID INT(10),
	constraint SC_ID_PK primary key (SEARCH_COLLECTION_ID),
	constraint COLLECTION_ID_FK foreign key (COLLECTION_ID) references COLLECTION_LIST(COLLECTION_ID),
	constraint SEARCH_ID_FK foreign key (SEARCH_ID) references TRADE_LIST(ITEM_ID),
	constraint LEAGUE_ID_FK foreign key (LEAGUE_ID) references LEAGUE_LIST(LEAGUE_ID)
)
-----------------------------------------------------------------

insert into TRADE_LIST values (1, "test@gmail.com", "Unending Hunger", "Spectre Soul Eater Jewel", "https://poe.trade/search/huriumdutoheno", "https://poe.ninja/challengehc/unique-jewels/unending-hunger-cobalt-jewel");
insert into TRADE_LIST values (2, "test2@gmail.com", "Unending Hunger2", "Spectre Soul Eater Jewel2", "https://poe.trade/search/huriumdutoheno", "https://poe.ninja/challengehc/unique-jewels/unending-hunger-cobalt-jewel");

insert into USER_LIST values ("Marshall", "pass", "test@gmail.com", 1);

select * from trade_list;

select * from user_list;