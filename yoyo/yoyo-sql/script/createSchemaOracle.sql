-- DROP tables, sequences and indexes

drop table MARKET;

drop sequence SEQ_MARKET;

-- Create table MARKET

create table MARKET
(
  IDMAR			NUMBER(8) constraint PK_MARKET primary key,
  NAME       	VARCHAR2(30) unique,
  DESCRIPTION 	VARCHAR2(2000),
  LASTMODIFIED  TIMESTAMP,
  VERSION 		SMALLINT DEFAULT 1 NOT NULL -- optimistic lock
);

-- Create sequence 

create sequence SEQ_MARKET
	minvalue 1
	NOMAXVALUE
	increment by 1;

commit;

