select * from member;


CREATE TABLE MEMBERMEMBER(
	ID VARCHAR2(15) PRIMARY KEY,
	PASSWORD VARCHAR2(15) NOT NULL,
	NAME VARCHAR2(15) NOT NULL,
	TEL CHAR(11) NOT NULL,
	ADDRESS VARCHAR2(150) NOT NULL,
	REG_DATE DATE NOT NULL
);

CREATE SEQUENCE MEMBERMEMBER_SEQ;

drop sequence membermember_seq;
drop table membermember;

select * from membermember;
select id, password, name, tel, address, to_char(reg_date, 'yy.mm.dd') as reg_date from membermember where id='hellojava' and password='123';