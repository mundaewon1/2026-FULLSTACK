select * from sidos;
SELECT
    question_id,
    parent_id,
    member_id,
    category,
    title,
    delete_yn,
    is_public
FROM questions
ORDER BY question_id DESC;

INSERT INTO member_report_status
    (report_status_id, status_code, status_name)
VALUES
    (1, 'ACTIVE', '정상');

INSERT INTO member_report_status
    (report_status_id, status_code, status_name)
VALUES
    (2, 'WARNING', '주의');

INSERT INTO member_report_status
    (report_status_id, status_code, status_name)
VALUES
    (3, 'DANGER', '위험');
INSERT INTO interest (interest_id, interest_name) VALUES (1, '운동');
INSERT INTO interest (interest_id, interest_name) VALUES (2, '여행');
INSERT INTO interest (interest_id, interest_name) VALUES (3, '게임');
INSERT INTO interest (interest_id, interest_name) VALUES (4, '독서');
INSERT INTO interest (interest_id, interest_name) VALUES (5, '맛집');
INSERT INTO interest (interest_id, interest_name) VALUES (6, '영화');
INSERT INTO interest (interest_id, interest_name) VALUES (7, '음악');
INSERT INTO interest (interest_id, interest_name) VALUES (8, '요리');    

COMMIT;

UPDATE MEMBERS
SET status_ID = 1
WHERE status_ID = '3';

SELECT * FROM question_images;
SELECT * FROM questions;
delete from questions;
SELECT USER FROM dual; -- 오라클 접속 계정
SELECT table_name FROM user_tables; -- 테이블 목록

create sequence question_seq;
create sequence answer_seq;
create sequence notification_seq;
CREATE SEQUENCE question_image_seq;

CREATE TABLE questions (
    question_id NUMBER PRIMARY KEY, -- 질문 고유 ID (PK)
    parent_id NUMBER NOT NULL, -- 상위 엔티티 ID (모임ID 또는 관리자 영역 ID)
    member_id NUMBER NOT NULL, -- 질문 작성자 ID (members 테이블 참조)
    category VARCHAR2(10) DEFAULT 'MEETUP' CHECK (category IN ('MEETUP','ADMIN')), -- 질문 출처 구분 (모임/관리자)
    title VARCHAR2(200) NOT NULL, -- 질문 제목
    content CLOB NOT NULL, -- 질문 내용
    qna_status VARCHAR2(20) DEFAULT 'PENDING' CHECK (qna_status IN ('PENDING','ANSWERED')), -- 질문 상태 (처리대기/처리완료)
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
    analysis_status VARCHAR2(20) DEFAULT 'NORMAL' CHECK (analysis_status IN ('NORMAL', 'PENDING_REVIEW')), -- AI 분석 상태
    aggression_score NUMBER(5,2), -- AI 공격성 점수 (0~100)
    ai_category VARCHAR2(20) CHECK (ai_category IN ('LOGIN', 'PAYMENT', 'ACCOUNT', 'REPORT', 'BUG', 'OTHER')), -- AI 자동분류 결과
    CONSTRAINT fk_question_ai_analysis FOREIGN KEY (question_id) REFERENCES questions(question_id) ON DELETE CASCADE
);

CREATE TABLE answers (
    answer_id NUMBER PRIMARY KEY, -- 답변 고유 ID (PK)
    question_id NUMBER NOT NULL UNIQUE, -- 연결된 질문 ID (질문당 답변 1개만 허용)
    member_id NUMBER NOT NULL, -- 답변 작성자 ID (게시자/관리자)
    content CLOB NOT NULL, -- 답변 내용
    is_public CHAR(1) DEFAULT 'Y' CHECK (is_public IN ('Y','N')), -- 공개 여부 (Y=공개, N=비공개)
    delete_yn CHAR(1) DEFAULT 'N' CHECK (delete_yn IN ('Y','N')), -- 삭제 여부 (N=정상, Y=삭제)
    rating NUMBER(1), -- 답변 만족도 점수 (1~5)
    feedback VARCHAR2(1000), -- 답변 만족도 의견
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일시
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 수정일시
    CONSTRAINT chk_answers_rating CHECK (rating IS NULL OR rating BETWEEN 1 AND 5), -- 평점은 NULL 또는 1~5
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

CREATE TABLE question_images (
    image_id NUMBER PRIMARY KEY, -- 문의 이미지 고유 ID (PK)
    question_id NUMBER NOT NULL, -- 연결된 문의 ID
    original_name VARCHAR2(255) NOT NULL, -- 원본 파일명
    stored_name VARCHAR2(255) NOT NULL, -- 서버에 저장된 파일명
    image_path VARCHAR2(500) NOT NULL, -- 이미지 저장 경로
    image_size NUMBER, -- 이미지 크기(byte)
    content_type VARCHAR2(100), -- 이미지 타입 (image/jpeg, image/png 등)
    delete_yn CHAR(1) DEFAULT 'N' CHECK (delete_yn IN ('Y','N')), -- 삭제 여부
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일시
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 수정일시

    CONSTRAINT fk_question_image_question
        FOREIGN KEY (question_id)
        REFERENCES questions(question_id)
);
CREATE OR REPLACE TRIGGER trg_question_images_updated
BEFORE UPDATE ON question_images
FOR EACH ROW
BEGIN
    :NEW.updated_at := CURRENT_TIMESTAMP;
END;
/

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


