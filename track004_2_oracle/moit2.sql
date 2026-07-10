commit;

select * from questions;
ALTER SEQUENCE question_seq RESTART START WITH 1;

SELECT table_name FROM user_tables; -- 테이블 목록
select * from questions;
select * from answers;
SELECT * FROM question_ai_analysis;
create sequence question_seq;
create sequence answer_seq;
create sequence notification_seq;

delete from questions;
select * from members;

INSERT INTO questions (
    question_id,
    parent_id,
    member_id,
    category,
    title,
    content,
    status,
    is_public,
    delete_yn,
    created_at,
    updated_at
)
SELECT
    question_seq.NEXTVAL,
    MOD(LEVEL, 10) + 1,
    31,    -- 모든 문의를 31번 회원이 작성한 것으로 설정
    CASE WHEN MOD(LEVEL, 2) = 0 THEN 'MEETUP' ELSE 'ADMIN' END,
    '테스트 문의 제목 ' || LEVEL,
    '테스트 문의 내용 ' || LEVEL,
    CASE WHEN MOD(LEVEL, 3) = 0 THEN 'ANSWERED' ELSE 'PENDING' END,
    'Y',
    'N',
    SYSDATE,
    SYSDATE
FROM dual
CONNECT BY LEVEL <= 200;

COMMIT;

CREATE TABLE questions (
    question_id NUMBER PRIMARY KEY, -- 질문 고유 ID (PK)
    parent_id NUMBER NOT NULL, -- 상위 엔티티 ID (모임ID 또는 관리자 영역 ID)
    member_id NUMBER NOT NULL, -- 질문 작성자 ID (members 테이블 참조)
    category VARCHAR2(10) DEFAULT 'MEETUP' CHECK (category IN ('MEETUP','ADMIN')), -- 질문 출처 구분 (모임/관리자)
    title VARCHAR2(200) NOT NULL, -- 질문 제목
    content CLOB NOT NULL, -- 질문 내용
    status VARCHAR2(20) DEFAULT 'PENDING' CHECK (status IN ('PENDING','ANSWERED')), -- 질문 상태 (처리대기/처리완료)
    is_public CHAR(1) DEFAULT 'Y' CHECK (is_public IN ('Y','N')), -- 공개 여부 (Y=공개, N=비공개)
    delete_yn CHAR(1) DEFAULT 'N' CHECK (delete_yn IN ('Y','N')), -- 삭제 여부 (N=정상, Y=삭제)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일시
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 수정일시
    CONSTRAINT fk_question_member FOREIGN KEY (member_id) REFERENCES members(member_id) -- 작성자 FK
);
CREATE OR REPLACE TRIGGER trg_questions_updated
BEFORE UPDATE ON questions
FOR EACH ROW BEGIN :NEW.updated_at := CURRENT_TIMESTAMP;
END;
/

CREATE TABLE question_ai_analysis (
    question_id NUMBER PRIMARY KEY, -- 질문 PK (questions와 1:1 관계)
    analysis_status VARCHAR2(20) DEFAULT 'NORMAL' CHECK (analysis_status IN ('NORMAL', 'PENDING_REVIEW', 'REJECTED')), -- AI 분석 상태
    aggression_score NUMBER(5,2), -- AI 공격성 점수 (0~100)
    CONSTRAINT fk_question_ai_analysis FOREIGN KEY (question_id) REFERENCES questions(question_id) ON DELETE CASCADE
);

CREATE TABLE answers (
    answer_id NUMBER PRIMARY KEY, -- 답변 고유 ID (PK)
    question_id NUMBER NOT NULL UNIQUE, -- 연결된 질문 ID (질문당 답변 1개만 허용)
    member_id NUMBER NOT NULL, -- 답변 작성자 ID (게시자/관리자)
    content CLOB NOT NULL, -- 답변 내용
    is_public CHAR(1) DEFAULT 'Y' CHECK (is_public IN ('Y','N')), -- 공개 여부 (Y=공개, N=비공개)
    delete_yn CHAR(1) DEFAULT 'N' CHECK (delete_yn IN ('Y','N')), -- 삭제 여부 (N=정상, Y=삭제)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일시
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 수정일시
    CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES questions(question_id), -- 질문 FK
    CONSTRAINT fk_answer_member FOREIGN KEY (member_id) REFERENCES members(member_id) -- 작성자 FK
);
CREATE OR REPLACE TRIGGER trg_answers_updated
BEFORE UPDATE ON answers
FOR EACH ROW BEGIN :NEW.updated_at := CURRENT_TIMESTAMP;
END;
/

CREATE TABLE notifications (
    notification_id NUMBER PRIMARY KEY, -- 알림 PK
    question_id NUMBER NOT NULL, -- 알림 발생 대상 문의
    member_id NUMBER NOT NULL, -- 알림 수신 회원
    type VARCHAR2(30) NOT NULL CHECK (type IN ('QUESTION_CREATED','ANSWER_CREATED','QUESTION_REVIEW','QUESTION_REJECTED')), -- 알림 유형
    message VARCHAR2(255) NOT NULL, -- 알림 메시지
    is_read CHAR(1) DEFAULT 'N' CHECK (is_read IN ('Y','N')), -- 읽음 여부
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    CONSTRAINT fk_notification_question FOREIGN KEY (question_id) REFERENCES questions(question_id), -- 문의 FK
    CONSTRAINT fk_notification_member FOREIGN KEY (member_id) REFERENCES members(member_id) -- 회원 FK
);

--------------------------------------------------------------------------------------------------------------

create table member_type(  -- 회원유형
    member_type_id number primary key,
    type_name varchar2(30) unique not null
);


insert into member_type(member_type_id,type_name) values(1,'ROLE_MEMBER'); -- 유저
insert into member_type(member_type_id,type_name) values(2,'ROLE_PARTNER'); -- 제휴업체
insert into member_type(member_type_id,type_name) values(3,'ROLE_ADMIN'); -- 관리자
insert into member_type(member_type_id,type_name) values(4,'ROLE_SUPERADMIN'); -- 최고 관리자


create table member_status( -- 회원 상태
    status_id number primary key,
    status_name varchar2(30) unique not null
);

insert into member_status (status_id , status_name) values(1,'ACTIVE'); -- 활성화
insert into member_status (status_id , status_name) values(2,'PENDING'); -- 대기중
insert into member_status (status_id , status_name) values(3,'SUSPENDED'); -- 거절
insert into member_status (status_id , status_name) values(4,'DELETED'); -- 정지

create table members(
    member_id number primary key,
    login_id varchar2(50) unique not null,
    mobile varchar2(20) unique not null,
    nickname varchar2(50) unique not null,
    email varchar2(100) unique not null,
    password varchar2(255) unique not null,
    profile_url varchar2(500),
    member_type_id number not null,
    status_id number not null,
    created_at date default sysdate not null,
    update_at date default sysdate not null,
    delete_yn char(1) default 'N' not null,

    constraint fk_member_type
        foreign key(member_type_id)
        references member_type(member_type_id),

    constraint fk_member_status
        foreign key(status_id)
        references member_status(status_id)
);

CREATE SEQUENCE MEETUPS_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE meetups (
    meetup_id          NUMBER PRIMARY KEY,
    member_id          NUMBER NOT NULL,
    title              VARCHAR2(100) NOT NULL,
    content            CLOB NOT NULL,
    max_participants   NUMBER NOT NULL,
    min_participants   NUMBER NOT NULL,
    sigungu_id         NUMBER NOT NULL,
    category_id        NUMBER NOT NULL,
    address            VARCHAR2(255),
    address_detail     VARCHAR2(255), -- 상세 주소
    meetup_at          DATE NOT NULL,

    status             VARCHAR2(20) DEFAULT 'RECRUITING' NOT NULL,

    latitude           NUMBER(10,7), -- 위도
    longitude          NUMBER(11,7), -- 경도    
    weather_status     VARCHAR2(20), -- 감지된 날씨
    rain_probability   NUMBER(3), -- 감지된 강수확률 (0~100)

    delete_yn          CHAR(1) DEFAULT 'N' NOT NULL,
    created_at         DATE DEFAULT SYSDATE NOT NULL,
    updated_at         DATE DEFAULT SYSDATE NOT NULL
);

ALTER TABLE advertisement_click_log
ADD position VARCHAR2(50);

ALTER TABLE advertisement_click_log
ADD CONSTRAINT chk_click_position
CHECK(position IN (
'MAIN',
'MEETUP_LIST_BANNER',
'MEETUP_LIST_SIDEBAR',
'MEETUP_DETAIL_SIDEBAR'
));

ALTER TABLE advertisement_impression_log
ADD position VARCHAR2(50);

ALTER TABLE advertisement_impression_log
ADD CONSTRAINT chk_impression_position
CHECK(position IN (
'MAIN',
'MEETUP_LIST_BANNER',
'MEETUP_LIST_SIDEBAR',
'MEETUP_DETAIL_SIDEBAR'
));

