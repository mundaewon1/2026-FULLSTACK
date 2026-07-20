commit;

ALTER SEQUENCE question_seq RESTART START WITH 1;

SELECT table_name FROM user_tables; -- 테이블 목록
select * from questions;
select * from answers;
SELECT * FROM question_ai_analysis;
create sequence question_seq;
create sequence answer_seq;
create sequence notification_seq;

SELECT * FROM MEMBERS;

SELECT * FROM notifications;

update question_ai_analysis set analysis_status='NORMAL' where analysis_status='PENDING_REVIEW';

update members set member_type_id = 3 where email='1@1';

delete from questions;

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


-- ==========================
-- 질문
-- ==========================

INSERT INTO questions VALUES (
101, 1, 12, 'MEETUP',
'주말 등산 모임 신청 가능한가요?',
'이번 주 토요일 등산 모임에 참여하려고 합니다. 아직 신청 가능한지 궁금합니다.',
'PENDING','Y','N',
TIMESTAMP '2026-07-01 10:12:00',
TIMESTAMP '2026-07-01 10:12:00'
);

INSERT INTO question_ai_analysis VALUES
(101,'NORMAL',8);

------------------------------------------------------------

INSERT INTO questions VALUES (
102,1,18,'MEETUP',
'참가비는 어떻게 결제하나요?',
'현장 결제인지 사전 계좌이체인지 알고 싶습니다.',
'ANSWERED','Y','N',
TIMESTAMP '2026-07-02 14:20:00',
TIMESTAMP '2026-07-02 16:35:00'
);

INSERT INTO question_ai_analysis VALUES
(102,'NORMAL',5);

------------------------------------------------------------

INSERT INTO questions VALUES (
103,2,21,'MEETUP',
'초보자도 참여 가능한가요?',
'등산 경험이 거의 없는데 참여해도 괜찮을까요?',
'PENDING','Y','N',
TIMESTAMP '2026-07-03 09:10:00',
TIMESTAMP '2026-07-03 09:10:00'
);

INSERT INTO question_ai_analysis VALUES
(103,'NORMAL',4);

------------------------------------------------------------

INSERT INTO questions VALUES (
104,3,27,'MEETUP',
'우천 시 일정은 어떻게 되나요?',
'비가 오면 일정이 취소되는지 궁금합니다.',
'ANSWERED','Y','N',
TIMESTAMP '2026-07-05 11:25:00',
TIMESTAMP '2026-07-05 12:30:00'
);

INSERT INTO question_ai_analysis VALUES
(104,'NORMAL',7);

------------------------------------------------------------

INSERT INTO questions VALUES (
105,0,35,'ADMIN',
'닉네임 변경이 되지 않습니다.',
'프로필에서 닉네임을 변경해도 저장되지 않습니다.',
'PENDING','Y','N',
TIMESTAMP '2026-07-07 15:20:00',
TIMESTAMP '2026-07-07 15:20:00'
);

INSERT INTO question_ai_analysis VALUES
(105,'NORMAL',6);

------------------------------------------------------------

INSERT INTO questions VALUES (
106,0,41,'ADMIN',
'로그인이 계속 실패합니다.',
'비밀번호를 정확하게 입력했는데 로그인이 되지 않습니다.',
'ANSWERED','Y','N',
TIMESTAMP '2026-07-08 18:20:00',
TIMESTAMP '2026-07-08 18:55:00'
);

INSERT INTO question_ai_analysis VALUES
(106,'NORMAL',11);

------------------------------------------------------------
-- 발표용 AI 검토 대상
------------------------------------------------------------

INSERT INTO questions VALUES (
107,2,25,'MEETUP',
'운영자가 확인 좀 해주세요.',
'신청을 여러 번 했는데 계속 오류가 발생합니다. 왜 이런 식으로 운영되는 건가요?',
'PENDING','Y','N',
TIMESTAMP '2026-07-10 13:40:00',
TIMESTAMP '2026-07-10 13:40:00'
);

INSERT INTO question_ai_analysis VALUES
(107,'PENDING_REVIEW',74);

------------------------------------------------------------

INSERT INTO questions VALUES (
108,0,32,'ADMIN',
'계속 오류만 발생하네요.',
'며칠째 같은 문제가 반복되고 있습니다. 빠른 확인 부탁드립니다.',
'PENDING','Y','N',
TIMESTAMP '2026-07-12 09:30:00',
TIMESTAMP '2026-07-12 09:30:00'
);

INSERT INTO question_ai_analysis VALUES
(108,'PENDING_REVIEW',82);

------------------------------------------------------------

INSERT INTO questions VALUES (
109,4,29,'MEETUP',
'친구와 같이 신청 가능한가요?',
'2명이 함께 신청하려고 하는데 가능한지 문의드립니다.',
'PENDING','Y','N',
TIMESTAMP '2026-07-13 16:45:00',
TIMESTAMP '2026-07-13 16:45:00'
);

INSERT INTO question_ai_analysis VALUES
(109,'NORMAL',3);

------------------------------------------------------------

INSERT INTO questions VALUES (
110,5,17,'MEETUP',
'모임 장소에 주차 가능한가요?',
'자차를 이용하려고 하는데 주차장이 있는지 궁금합니다.',
'PENDING','Y','N',
TIMESTAMP '2026-07-14 10:05:00',
TIMESTAMP '2026-07-14 10:05:00'
);

INSERT INTO question_ai_analysis VALUES
(110,'NORMAL',4);



INSERT INTO answers VALUES(
1,
102,
1,
'안녕하세요. 참가비는 모임 당일 현장에서 결제하시면 됩니다.',
'Y','N',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP
);

INSERT INTO answers VALUES(
2,
104,
1,
'우천 시에는 전날 공지를 통해 일정 변경 여부를 안내드립니다.',
'Y','N',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP
);

INSERT INTO answers VALUES(
3,
106,
1,
'비밀번호 재설정 후에도 문제가 발생하면 고객센터로 문의 부탁드립니다.',
'Y','N',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP
);

SELECT member_id, nickname
FROM members
ORDER BY member_id;

SELECT member_id, nickname
FROM members
ORDER BY member_id;