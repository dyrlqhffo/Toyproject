select * from member;


CREATE TABLE MEMBERMEMBER(
	ID VARCHAR2(15) PRIMARY KEY,
	PASSWORD VARCHAR2(15) NOT NULL,
	NAME VARCHAR2(15) NOT NULL,
	TEL CHAR(11) NOT NULL,
	ADDRESS VARCHAR2(150) NOT NULL,
	REG_DATE DATE NOT NULL
);

ALTER TABLE QABOARD RENAME TO BOARDBOARD;

CREATE TABLE QABOARD(
	BOARD_NO NUMBER,
	ID VARCHAR2(15) NOT NULL,
	TITLE VARCHAR2(300) NOT NULL,
	CONTENT CLOB NOT NULL,
	REG_DATE DATE NOT NULL,
	EDIT_DATE DATE NULL,
	HITS NUMBER NOT NULL,
	BOARD_TYPE VARCHAR2(30) NOT NULL,
	CONSTRAINT PK PRIMARY KEY(BOARD_NO),
	CONSTRAINT FK FOREIGN KEY (ID)
	REFERENCES MEMBERMEMBER (ID)
	ON DELETE CASCADE
);
--member
select * from membermember;
select id, password, name, tel, address, to_char(reg_date, 'yy.mm.dd') as reg_date from membermember 
where id='hellojava' and password='123';

CREATE SEQUENCE MEMBERMEMBER_SEQ;
drop sequence membermember_seq;

-- board
select * from boardboard;

INSERT INTO BOARDBOARD(BOARD_NO, ID, TITLE, CONTENT, REG_DATE, EDIT_DATE, HITS, BOARD_TYPE) 
VALUES(BOARDBOARD_SEQ.NEXTVAL, 'hellojava', '문의합니다.', '안알랴줌', sysdate, sysdate, 0, 'Q&A');

CREATE SEQUENCE BOARDBOARD_SEQ;

SELECT B.BOARD_NO, M.ID, B.TITLE, B.CONTENT, TO_CHAR(B.REG_DATE, 'YYYY.MM.DD HH24:MI') 
AS REG_DATE, TO_CHAR(B.EDIT_DATE, 'YY.MM.DD HH24:MI')AS EDIT_DATE, B.HITS, B.BOARD_TYPE
FROM BOARDBOARD B INNER JOIN MEMBERMEMBER M ON B.ID = M.ID ORDER BY B.BOARD_NO DESC;

select board_no, id, title, content, to_char(reg_date, 'yy.mm.dd')as reg_date, hits, board_type from boardboard where board_no=1;

