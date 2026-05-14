#### 1. Mysql?
> 1. mysql why?
1. DBMS
- Database Management System
- 데이터베이스를 관리해주는 시스템

2. Database?
- Data + Base
- Data  1. 데이터(수집된 사실, 값)  2. 정보(의미 부여)
- Data(의미를 제공하는 데이터) + Base( 체계와 규격을 가진 집합)

Q1. 다음 빈칸을 채우시오
      1.     (#1  데이터 )는  수집된 사실이나 값을 의미하고
      2.     (#2  정보   )는  데이터들 중에서 의미를 제공하는 데이터를 의미

3. Database 종류
- Oracle , Mysql , MSsql,,,,,,


> 2. mysql Setting
1. MYSQL 다운로드
      https://dev.mysql.com/
      -Download
      -MySQL Community Server

2. MYSQL 설치
3. MYSQL 환경설치 (1) path
4. MYSQL 환경설치 (2) utf-8


#### 2. RDBMS

> 1. RDBMS (Relational Datase Management System)
- 관계형 데이터베이스  관리 시스템
- 테이블들의 관계

> 2. RDBMS 구성요소
- 개체 (Entity : Table)
- 관계 (Relationship)
- 속성 (Attribute : 필드)

  ※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
     외부스키마 = 사용자뷰
     개념스키마 = 전체적인뷰
     내부스키마 = 저장스키마

  ※ 데이터베이스 설계단계
   #1. 개념적설계 - 요구사항분석 후 개념적 설계 ERD  
       (집을어떻게? 방몇개, 주방어디,,, 거실은 얼마나크게)
   #2. 논리적설계 - ERD를 이용하여 데이터베이스 스키마를 설계
       (방 = 테이블 , 사람 = 엔티티 , 관계 = 왜래키)
   #3. 물리적설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,)
       (실제건축자재로 만들기 - mysql, oracle)

> 3. 데이터베이스 언어
1. 정의어 (DDL) DDL = Data Definition Language (데이터 정의어)
    CREATE, ALTER, DROP     -> CAD
2. 조작어 (DML) DML = Data Manipulation Language (데이터 조작어)
    INSERT, SELECT, UPDATE, DELETE     -> CRUD
3. 제어어 (DCL) DCL = Data Control Language (데이터 제어어)
    GRANT, REVOKE

> 4. [실습] Database 만들기

1. 만들기       : create database db명
2. 확인        : show   databases
3. 삭제(복구x)  : drop   database  db명
4. DB사용      : use    db명

1) 접속
mysql -uroot -p
1234

2) mysql


> 5. [연습] 
1. db명 : test , mbasic , db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제

1.   MySQL은 ________ 관리 시스템(DBMS)이다.
2.  (#1 ________)는 수집된 사실이나 값을 의미하고 (#2 ________)는 의미를 제공하는 데이터를 의미한다.
3. 대표적인 데이터베이스 종류에는 ________, ________, ________ 등이 있다.
4.  RDBMS는 ________ Database Management System의 약자이다.
5. RDBMS의 구성요소는   ________, ________, ________ 
6. 데이터베이스 언어
DDL(  정의어   )  CREATE, ALTER, DROP 
DML(   )    ________, ________, ________ , ________ 
DCL(   )     ________, ________

7. 데이터베이스  mbasic, 를 생성하는 SQL 명령어를 작성하시오.
8.  생성된 데이터베이스 목록을 확인하는 SQL 명령어를 작성하시오.
9. 데이터베이스 db703을 삭제하는 SQL 명령어를 작성하시오.


#### 3. 테이블

1. RDBMS (Relational Data Management System)
- 관계형데이터베이스
- 테이블의 관계
- 속성(필드) 연결

2. 테이블 만들기 (집안의 방, 가방안의 분류표)
DDL (create, alter, drop) , DML(조작:) , DCL(제어:)
------------------------------
CREATE TABLE table명 (
    필드1 자료형 옵션,
    필드2 자료형 옵션
);
------------------------------
자료형 :
    1. 숫자 : int( 정수, 1,2,3,) , double( 실수, 1.23)
    2. 문자 : char(고정, 남/여)  ,  varchar(가변, abc, abcd, abcde) 범위(영역)안에서 사용
    3. 날짜 : date, datetime
옵션 : 
    필수입력 - not null
    숫자자동증가 - auto_increment
    기본키 - primary key

create table t1(
    name varchar(100) not null, <-무조건 값 채워야함 필수입력
    age  int
);
show tables;     -- 테이블목록확인
desc t1;         -- 구조확인

create table t11(
    no      int      not null,
    name varchar(30) not null
);

create table t12(
    bookid    int       not null,     -- not(안돼) null(빈거)
    title  varchar(100) not null      -- 필수입력
);

show tables;
desc t12;

※ ERROR 1046 (3D000): No database selected
use db명  -status 로 확인

mysql> show databases;
mysql> use mbasic;
mysql> status           -- 상태확인

※ 참고사항) not null 필수입력
mysql> insert into t1 (age) values (1);
ERROR 1364 (HY000): Field 'name' doesn't have a default value (값넣어!)

mysql> insert into t1 (name, age) values ('aaa', 1);
Query OK, 1 row affected (0.00 sec)

mysql> insert into t1 (name) values ('bbb');
Query OK, 1 row affected (0.00 sec)

mysql> select * from t1;
+------+------+
| name | age  |
+------+------+
| aaa  |    1 |
| bbb  | NULL |
+------+------+
2 rows in set (0.00 sec)


[실습2]  auto_increment (숫자 자동증가) , primary key (기본키)
create table t2(
    jumin int not null  auto_increment  primary key,
    name  varchar(100) not null,
    age  int
);

※ 참고사항)
insert into  t2 (name, age)  values ('aaa' , 1);   -- 숫자자동증가
insert into  t2 (name)  values ('bbb');            -- 숫자자동증가
insert into  t2 (jumin, name, age)  values (1 , 'ccc' , 1);  -- error 기본키
insert into  t2 (jumin, name, age)  values (3 , 'ccc' , 1);  

mysql> select * from t2;
+-------+------+------+
| jumin | name | age  |
+-------+------+------+
|     1 | aaa  |    1 |
|     2 | bbb  | NULL |
|     3 | aaa  |    1 |  <-- aaa, 1 / aaa,1 구분을 해줄수 있는 필드는  jumin  1,3  
+-------+------+------+
2 rows in set (0.00 sec)


------------------------------------------------------------
------------------------------------------------------------ [연습문제]
[001]  다음과 같이 DB와 테이블을 만드시오        >> coffee
커피번호 : cno    int           필수입력     primary key
커피이름 : cname  varchar(50)   필수입력
커피가격 : cprice   int          필수입력
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |    
| cname  | varchar(50) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

create table coffee(
    cno     int         not null primary key auto_increment,
    cname   varchar(50) not null,
    cprice  int         not null
);


[002] 다음과 같이 DB와 테이블을 만드시오           >> milk
우유번호 : mno      int           필수입력     primary key
우유이름 : mname    varchar(50)  필수입력
우유가격 : mprice   int          필수입력
우유갯수 : mnum     int         필수입력
우유총액 : mtotal   int         필수입력

+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| mno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| mname  | varchar(50) | NO   |     | NULL    |                |
| mprice | int(11)     | NO   |     | NULL    |                |
| mnum   | int(11)     | NO   |     | NULL    |                |
| mtotal | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

create table milk(
    mno     int          not null primary key auto_increment,
    mname   varchar(50)  not null,
    mprice  int          not null,
    mnum    int          not null,
    mtotal  int          not null
);


[003] 다음과 같이 DB와 테이블을 만드시오    >> score
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| sno      | int(11)     | NO   | PRI | NULL    | auto_increment |
| sname    | varchar(20) | NO   |     | NULL    |                |
| sjava    | int(11)     | NO   |     | NULL    |                |
| sjsp     | int(11)     | NO   |     | NULL    |                |
| sspring  | int(11)     | NO   |     | NULL    |                |
| sproject | int(11)     | NO   |     | NULL    |                |
| sstotal  | int(11)     | YES  |     | NULL    |                |
| ssavg    | int(11)     | YES  |     | NULL    |                |
| semail   | varchar(50) | YES   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

create table score(
    sno         int         not null    primary key auto_increment,
    sname       varchar(20) not null,
    sjava       int         not null,
    sjsp        int         not null,
    sspring     int         not null,
    sproject    int         not null,
    sstotal     int,
    ssavg       int,
    semail      varchar(50)
);

[004]  다음과 같이 DB와 테이블을 만드시오      >> emp
mysql> desc emp;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| empno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| ename    | varchar(20) | YES  |     | NULL    |                |
| job      | varchar(20) | YES  |     | NULL    |                |
| mgr      | int(11)     | YES  |     | NULL    |                |
| hiredate | date        | YES  |     | NULL    |                |
| sal      | int(11)     | YES  |     | NULL    |                |
| comm     | int(11)     | YES  |     | NULL    |                |
| deptno   | int(11)     | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)

create table emp(
    empno       int         not null    primary key auto_increment,
    ename       varchar(20),
    job         varchar(20),
    mgr         int,
    hiredate    date,
    sal         int,
    comm        int,
    deptno      int
);


[005]  다음과 같이 DB와 테이블을 만드시오     >> dept
mysql> desc dept;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| deptno | int(11)     | NO   | PRI | NULL    | auto_increment |
| dname  | varchar(20) | NO   |     | NULL    |                |
| loc    | varchar(20) | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

create table dept(
    deptno      int         not null    primary key auto_increment,
    dname       varchar(20) not null,
    loc         varchar(20) not null
);


[006]  다음과 같이 DB와 테이블을 만드시오    >> salagrade
mysql> desc salgrade;
+-------+---------+------+-----+---------+----------------+
| Field | Type    | Null | Key | Default | Extra          |
+-------+---------+------+-----+---------+----------------+
| grade | int(11) | NO   | PRI | NULL    | auto_increment |
| losal | int(11) | YES  |     | NULL    |                |
| hisal | int(11) | YES  |     | NULL    |                |
+-------+---------+------+-----+---------+----------------+
3 rows in set (0.02 sec)

create table salagrade(
    grade   int     not null    primary key     auto_increment,
    losal   int,
    hisal   int
);

