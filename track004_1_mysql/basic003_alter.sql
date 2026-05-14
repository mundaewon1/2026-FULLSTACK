1. 데이터베이스 언어
- DDL : CREATE , ALTER(#) , DROP  -> CAD

1) alter 문법
https://dev.mysql.com/doc/refman/8.0/en/table.html

help alter
help alter table;


ALTER TABLE tbl_name 테이블명
    ADD         추가컬럼명  자료형 옵션  [FIRST | AFTER col_name]
    DROP        삭제필드명
    CHANGE      이전필드명   새로운필드명  자료형 옵션
    MODIFY      수정필드명  자료형  옵션
    RENAME      새로운테이블이름

#1) 필드추가
  alter table userinfo  add uno  int;
  alter table userinfo  add uno2 int first;  -- 맨앞에
  alter table userinfo  add email varchar(100) after name;  -- name 뒤에

#2) 필드삭제
  alter table userinfo drop uno;
  alter table userinfo drop uno2;

#3) 필드수정(CHANGE)  - 필드명 , 자료형 옵션 수정
  > alter table userinfo  change oldname newname 자료형 옵션
    alter table userinfo  change email   email2 varchar(50);

#4) 필드수정(modify)  - 자료형 옵션 수정   ( add, drop, change | modify )
    alter table userinfo  modify email varchar(20) not null;

#5) 테이블명 수정   ( add, drop, change | modify )
alter table userinfo rename uers;

>>>> 연습문제1)
[001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int(11)     | YES  |     | NULL    |       |
| cname  | varchar(20) | YES  |     | NULL    |       |
| cprice | int(11)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

create table alter_coffee(
    cno int,
    cname varchar(20),
    cprice int
);

[002] 다음과 같이 DB와 테이블을 수정하시오  [TABLE명 : alter_coffee] -  ALTER TABLE
연습문제1) cno, cname,cprice필드를 ( not null )으로 수정
연습문제2) 쿠폰필드  cgift    문자열고정char(10)  미필수로 추가
연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기
연습문제4) 쿠폰필드 ccoupon삭제
연습문제5) cno를 cprice뒤로이동
연습문제6) cno를 맨위로
연습문제7) cno를 primary key 추가 (add)
alter table alter_coffee add primary key(cno);

연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기
연습문제9) 다음과 같이 최종본으로 테이블만들기

mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(20) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)



  | ADD [COLUMN] col_name column_definition
        [FIRST | AFTER col_name]
  | ADD [COLUMN] (col_name column_definition,...)
  | ADD {INDEX | KEY} [index_name]
        [index_type] (key_part,...) [index_option] ...
  | ADD {FULLTEXT | SPATIAL} [INDEX | KEY] [index_name]
        (key_part,...) [index_option] ...
  | ADD [CONSTRAINT [symbol]] PRIMARY KEY
        [index_type] (key_part,...)
        [index_option] ...
  | ADD [CONSTRAINT [symbol]] UNIQUE [INDEX | KEY]
        [index_name] [index_type] (key_part,...)
        [index_option] ...
  | ADD [CONSTRAINT [symbol]] FOREIGN KEY
        [index_name] (col_name,...)
        reference_definition
  | ADD [CONSTRAINT [symbol]] CHECK (expr) [[NOT] ENFORCED]
  | DROP {CHECK | CONSTRAINT} symbol
  | ALTER {CHECK | CONSTRAINT} symbol [NOT] ENFORCED
  | ALGORITHM [=] {DEFAULT | INSTANT | INPLACE | COPY}
  | ALTER [COLUMN] col_name {
        SET DEFAULT {literal | (expr)}
      | SET {VISIBLE | INVISIBLE}
      | DROP DEFAULT
    }
  | ALTER INDEX index_name {VISIBLE | INVISIBLE}
  | CHANGE [COLUMN] old_col_name new_col_name column_definition
        [FIRST | AFTER col_name]
  | [DEFAULT] CHARACTER SET [=] charset_name [COLLATE [=] collation_name]
  | CONVERT TO CHARACTER SET charset_name [COLLATE collation_name]
  | {DISABLE | ENABLE} KEYS
  | {DISCARD | IMPORT} TABLESPACE
  | DROP [COLUMN] col_name
  | DROP {INDEX | KEY} index_name
  | DROP PRIMARY KEY
  | DROP FOREIGN KEY fk_symbol
  | FORCE
  | LOCK [=] {DEFAULT | NONE | SHARED | EXCLUSIVE}
  | MODIFY [COLUMN] col_name column_definition
        [FIRST | AFTER col_name]
  | ORDER BY col_name [, col_name] ...
  | RENAME COLUMN old_col_name TO new_col_name
  | RENAME {INDEX | KEY} old_index_name TO new_index_name
  | RENAME [TO | AS] new_tbl_name
  | {WITHOUT | WITH} VALIDATION
}

partition_options:
    partition_option [partition_option] ...

partition_option: {
    ADD PARTITION (partition_definition)
  | DROP PARTITION partition_names
  | DISCARD PARTITION {partition_names | ALL} TABLESPACE
  | IMPORT PARTITION {partition_names | ALL} TABLESPACE
  | TRUNCATE PARTITION {partition_names | ALL}
  | COALESCE PARTITION number
  | REORGANIZE PARTITION partition_names INTO (partition_definitions)
  | EXCHANGE PARTITION partition_name WITH TABLE tbl_name [{WITH | WITHOUT} VALIDATION]
  | ANALYZE PARTITION {partition_names | ALL}
  | CHECK PARTITION {partition_names | ALL}
  | OPTIMIZE PARTITION {partition_names | ALL}
  | REBUILD PARTITION {partition_names | ALL}
  | REPAIR PARTITION {partition_names | ALL}
  | REMOVE PARTITIONING
}

key_part: {col_name [(length)] | (expr)} [ASC | DESC]

index_type:
    USING {BTREE | HASH}

index_option: {
    KEY_BLOCK_SIZE [=] value
  | index_type
  | WITH PARSER parser_name
  | COMMENT 'string'
  | {VISIBLE | INVISIBLE}
}

table_options:
    table_option [[,] table_option] ...

table_option: {
    AUTOEXTEND_SIZE [=] value
  | AUTO_INCREMENT [=] value
  | AVG_ROW_LENGTH [=] value
  | [DEFAULT] CHARACTER SET [=] charset_name
  | CHECKSUM [=] {0 | 1}
  | [DEFAULT] COLLATE [=] collation_name
  | COMMENT [=] 'string'
  | COMPRESSION [=] {'ZLIB' | 'LZ4' | 'NONE'}
  | CONNECTION [=] 'connect_string'
  | {DATA | INDEX} DIRECTORY [=] 'absolute path to directory'
  | DELAY_KEY_WRITE [=] {0 | 1}
  | ENCRYPTION [=] {'Y' | 'N'}
  | ENGINE [=] engine_name
  | ENGINE_ATTRIBUTE [=] 'string'
  | INSERT_METHOD [=] { NO | FIRST | LAST }
  | KEY_BLOCK_SIZE [=] value
  | MAX_ROWS [=] value
  | MIN_ROWS [=] value
  | PACK_KEYS [=] {0 | 1 | DEFAULT}
  | PASSWORD [=] 'string'
  | ROW_FORMAT [=] {DEFAULT | DYNAMIC | FIXED | COMPRESSED | REDUNDANT | COMPACT}
  | SECONDARY_ENGINE_ATTRIBUTE [=] 'string'
  | STATS_AUTO_RECALC [=] {DEFAULT | 0 | 1}
  | STATS_PERSISTENT [=] {DEFAULT | 0 | 1}
  | STATS_SAMPLE_PAGES [=] value
  | TABLESPACE tablespace_name [STORAGE {DISK | MEMORY}]
  | UNION [=] (tbl_name[,tbl_name]...)
}


ALTER TABLE 테이블명
     ADD        추가필드명   자료형    옵션
     DROP      삭제필드명
     CHANGE  수정할필드명   새로넣을필드명   자료형  옵션
     MODIFY   수정할필드명   자료형  옵션
     RENAME  새로운테이블명

-- 1. 테이블준비
--mysql> desc userinfo;
--+-------+--------------+------+-----+---------+----------------+
--| Field | Type         | Null | Key | Default | Extra          |
--+-------+--------------+------+-----+---------+----------------+
--| no    | int          | NO   | PRI | NULL    | auto_increment |
--| name  | varchar(100) | NO   |     | NULL    |                |
--| age   | int          | NO   |     | NULL    |                |
--+-------+--------------+------+-----+---------+----------------+
--3 rows in set (0.00 sec)