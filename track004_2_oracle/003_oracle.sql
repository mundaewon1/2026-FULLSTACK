-- APPUSER
-- ┌───────────────────────────────────────────────┐
-- │ APP_USER_ID (PK)                              │
-- │ EMAIL (NOT NULL, UNIQUE with PROVIDER)        │
-- │ PASSWORD                                      │
-- │ MBTI_TYPE_ID                                  │
-- │ CREATED_AT                                    │
-- │ UFILE                                         │
-- │ MOBILE                                        │
-- │ NICKNAME                                      │
-- │ PROVIDER (NOT NULL)                           │
-- │ PROVIDER_ID                                   │
-- └───────────────────────────────────────────────┘
--                ▲
--                │  (FK: APP_USER_ID)
--                │
-- AUTHORITIES
-- ┌───────────────────────────────────────────────┐
-- │ AUTH_ID (PK)                                  │
-- │ EMAIL                                         │
-- │ AUTH (NOT NULL, UNIQUE with APP_USER_ID)      │
-- │ APP_USER_ID (FK → APPUSER.APP_USER_ID)        │
-- └───────────────────────────────────────────────┘
--````

--create table appuser(
--APP_USER_ID                               NUMBER(5) primary key NOT NULL ,
--EMAIL                                     VARCHAR2(100) NOT NULL ,
--PASSWORD                                           VARCHAR2(100),
--MBTI_TYPE_ID                                       NUMBER(3),
--CREATED_AT                                         DATE,
--UFILE                                              VARCHAR2(255),
--MOBILE                                             VARCHAR2(50),
--NICKNAME                                           VARCHAR2(50),
--PROVIDER                                  VARCHAR2(50) NOT NULL ,
--PROVIDER_ID                                        VARCHAR2(100),
--);

--create sequence appuser_seq;

--create table authorities(
-- AUTH_ID                                   NUMBER(5) NOT NULL ,
-- EMAIL                                              VARCHAR2(255),
-- AUTH                                      VARCHAR2(255) NOT NULL ,
-- APP_USER_ID                                        NUMBER(5)
--);

--create sequence authorities_seq;
--
--##  sql찾기
--
--2. sql  해당 sql
--1) 회원가입
insert into appuser(APP_USER_ID,EMAIL,PASSWORD,MBTI_TYPE_ID,CREATED_AT,UFILE,MOBILE,NICKNAME,PROVIDER,PROVIDER_ID) 
values       ( appuser_seq.nextval, 'first@gmail.com', '111', 1, sysdate, '1.png', '01011111111', 'first', 'the703', 't71');

--2) 로그인 - 이메일로 이메일, 비밀번호, 권한
select u.email, u.password, a.auth
from appuser u left join authorities a on u.email =  a.email 
where u.email = 'first@gmail.com';

--3) 이메일로 유저찾기
select * from appuser where email = 'first@gmail.com';

--4) 이메일로 중복검사
select count(*) from appuser where email='first@gmail.com';

--5) 회원수정
update appuser
set    password='2222',
mbti_type_id=2,
ufile = '2.png',
nickname='second',
mobile='01022222222',
provider='naver',
provider_id='n-1'
where app_user_id=1;

--6) 회원삭제
delete from appuser where app_user_id=1;

--7) 권한삽입
insert into authorities ( AUTH_ID, EMAIL, AUTH)
values                  ( authorities_seq.nextval, 'first@gmail.com', 'ROLE_MEMBER');
--8) 권한삭제
delete from authorities where email = 'first@gmail.com';

commit;
select * from appuser;