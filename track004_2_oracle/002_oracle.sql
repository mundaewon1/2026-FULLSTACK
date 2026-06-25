--1. table = oracle (scott/tiger)
--1) 테이블 - sboard2
--2) 시퀀스 ( 숫자자동증가 ) - sboard2_seq
--
--SQL> desc  sboard2;
-- 이름                                         널?      유형
-- ----------------------------------------- -------- ----------------------------
-- ID                                        NOT NULL NUMBER
-- APP_USER_ID                          NOT NULL NUMBER
-- BTITLE                                   NOT NULL VARCHAR2(1000)
-- BCONTENT                             NOT NULL CLOB
-- BPASS                                   NOT NULL VARCHAR2(255)
-- BFILE                                                   VARCHAR2(255)
-- BHIT                                                    NUMBER
-- BIP                                       NOT NULL VARCHAR2(255)
-- CREATED_AT                                          DATE

create table sboard2(
ID                  NUMBER      NOT NULL,
 APP_USER_ID        NUMBER      NOT NULL,
 BTITLE             VARCHAR2(1000)      NOT NULL,
 BCONTENT           CLOB       NOT NULL,
 BPASS              VARCHAR2(255)      NOT NULL,
 BFILE              VARCHAR2(255)      default 'the703.png',
 BHIT               NUMBER      default 0,
 BIP               VARCHAR2(255)     NOT NULL,
 CREATED_AT         DATE        default sysdate
 );
desc sboard2;

create sequence  sboard2_seq;   

2. dto
3. dao - mapper( mybatis )
위의 테이블보고
1) crud
insert into sboard2 ( ID                 , APP_USER_ID, BTITLE, BCONTENT, BPASS, BFILE, BIP ) 
            values  ( sboard2_seq.nextval, 1001,'title','bcontent','1111','1.png', '127.0.0.1' );
전체(페이징) 
select * from sboard2 order by id desc;

SELECT * FROM sboard2 
ORDER BY id DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

--  OFFSET 0 ROWS: 건너뛸 행의 개수 (0부터 시작)
--  FETCH NEXT 10 ROWS ONLY: 가져올 행의 개수

select count(*) from sboard2;
-- 11g 이하
select * from(
         select row_number() over(order by id desc)  as rnum, 
                id, app_user_id, btitle, bcontent, bpass, bfile, bip, bhit, created_at
         from  sboard2
      ) A  
      where  A.rnum  between  0  and 10;

해당번호의 
select * from sboard2 where id=1;
해당번호 조회수 올리기 
update sboard2 set bhit=bhit+1 where id=1;
해당번호 업데이트 
update sboard2 set btitle='new', bcontent='new', bfile='2.png' where id=2;
해당번호 삭제 
delete from sboard2 where id=1;

INSERT INTO sboard2 (ID, APP_USER_ID, BTITLE, BCONTENT, BPASS, BIP, CREATED_AT) SELECT (SELECT NVL(MAX(ID), 0) FROM sboard2) + ROWNUM, APP_USER_ID, BTITLE, BCONTENT, BPASS, BIP, SYSDATE FROM sboard2;
commit;
2) sboard2-mapper.xml
3) Sboard2Dao.java