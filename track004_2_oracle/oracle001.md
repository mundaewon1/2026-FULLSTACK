■1. oracle
- 데이터베이스언어
1) 데이터 정의어 (DDL) : Create, Alter, Drop (cad)
2) 데이터 조작어 (DML) : insert, select, update, delete (crud)
3) 데이터 제어어 (DCL) : grant, revoke

- 1. oracle 설치
- 2. sql developer 설치 ( sql 편집 )
- 3. 사용
<실습1>
```sql (cmd)
sqlplus
conn system/1234

-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user scott identified by tiger;

-- 권한부여
grant connect, resource to scott;

ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users; -- 물리적공간이용
grant create table to scott;
```

<실습2>
```sql(sqldeveloper)

--1. 테이블만들기
-- 테이블명 자료형 옵션
create table dept(
    deptno number  primary key,
    dname  varchar2(14),
    loc    varchar2(13)
);

--2. dml (crud)

-- 2) insert
--    DEPTNO DNAME                        LOC
------------ ---------------------------- --------------------------
--        10 ACCOUNTING                   NEW YORK
--        20 RESEARCH                     DALLAS
--        30 SALES                        CHICAGO
--        40 OPERATIONS                   BOSTON

insert into dept(deptno,dname,loc) values(10,'ACCOUNTING','NEW YORK');
insert into dept(deptno,dname,loc) values(20,'RESEARCH','DALLAS');
insert into dept(deptno,dname,loc) values(30,'SALES','CHICAGO');
insert into dept(deptno,dname,loc) values(40,'OPERATIONS','BOSTON');

commit;

select * from dept;

-- 3-1) 데이터 넣기 -  50 AIDEV SEOUL
insert into dept(deptno,dname,loc) values(50,'AIDEV','SEOUL');
-- 3-2) 데이터 수정 -  50 AIDEV INCHEON
update dept set loc='INCEHON' where deptno=50;
-- 3-3) 데이터 삭제 -  50번
delete from dept where deptno=50;

```

■2. boot