| 구분 | 사용자 기능 (질문) | 관리자 기능 (질문) |
| --- | --- | --- |
| **Create (생성)** | ① 모임 참가자 질문 작성 | - |
| **Read (조회)** | ② 질문 목록 리스트 (페이징)<br>③ 질문 조회 (질문+답변 포함) | ④ 질문 목록 전체 조회<br>⑤ 질문 리스트 (페이징)<br>⑥ 질문 검색 (작성자, 내용, 날짜) |
| **Update (수정)** | ⑦ 질문 수정 (작성자 본인) | - |
| **Delete (삭제)** | ⑨ 질문 삭제 (작성자 본인) | - |


| 구분 | 사용자 기능 (답변) - 모임의 개설자가 답변 | 관리자 기능 (답변) |
| --- | --- | --- |
| **Create (생성)** | ① 모임 개설자 답변 작성 | - |
| **Read (조회)** | ② 답변 조회 | ③ 답변 전체 조회<br>④ 답변 리스트 (페이징)<br>⑤ 답변 검색 (작성자, 내용, 날짜) |
| **Update (수정)** | ⑥ 답변 수정 (작성자=개설자) | ⑦ 답변 비공개 처리 (상태값 변경) |
| **Delete (삭제)** | ⑧ 답변 삭제 (작성자 본인) | ⑨ 답변 삭제 |



- PENDING(처리대기)
- APPROVED(처리완료)

```sql
CREATE TABLE questions (
  question_id INT AUTO_INCREMENT PRIMARY KEY, -- 질문 고유 ID (PK)
  parent_id INT NOT NULL, -- 상위 엔티티 ID (모임ID 또는 관리자 영역 ID)
  member_id INT NOT NULL, -- 질문 작성자 ID (members 테이블 참조)
  category ENUM('MEETUP','ADMIN') DEFAULT 'MEETUP', -- 질문 출처 구분 (모임/관리자)
  title VARCHAR(200), -- 질문 제목
  content TEXT NOT NULL, -- 질문 내용
  status ENUM('PENDING','ANSWERED') DEFAULT 'PENDING', -- 질문 상태 (처리대기/답변완료)
  is_public ENUM('Y','N') DEFAULT 'Y', -- 공개 여부 (Y=공개, N=비공개)
  delete_yn CHAR(1) DEFAULT 'N', -- 삭제 여부 (N=정상, Y=삭제)
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 생성일시
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일시
  CONSTRAINT fk_question_member FOREIGN KEY (member_id) REFERENCES members(member_id) -- 작성자 FK
);

CREATE TABLE answers (
  answer_id INT AUTO_INCREMENT PRIMARY KEY, -- 답변 고유 ID (PK)
  question_id INT NOT NULL UNIQUE, -- 연결된 질문 ID (질문당 답변 1개만 허용)
  member_id INT NOT NULL, -- 답변 작성자 ID (개설자/관리자)
  content TEXT NOT NULL, -- 답변 내용
  is_public ENUM('Y','N') DEFAULT 'Y', -- 공개 여부 (Y=공개, N=비공개)
  delete_yn CHAR(1) DEFAULT 'N', -- 삭제 여부 (N=정상, Y=삭제)
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 생성일시
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일시
  CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES questions(question_id), -- 질문 FK
  CONSTRAINT fk_answer_member FOREIGN KEY (member_id) REFERENCES members(member_id) -- 작성자 FK
);


```

| question_id |  parent_id | member_id | category | title | content | status | is_public | delete_yn | created_at |
| --- | --- |  --- | --- | --- | --- | --- | --- | --- | --- |
| 1 |   1 | 101 | MEETUP | 참여 조건 | 초보자도 참여 가능한가요? | PENDING | Y | N | 2026-06-16 17:40 |
| 2 |   999 | 999 | ADMIN | 운영 공지 | 이번 모임은 장소가 변경됩니다 | ANSWERED | N | N | 2026-06-16 17:40 |

| answer_id | question_id | member_id | content | is_public | delete_yn | created_at |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | 1 | 201 | 네, 초보자도 참여 가능합니다. | Y | N | 2026-06-16 17:40 |
| 2 | 2 | 999 | 장소는 본관 2층으로 변경되었습니다. | N | N | 2026-06-16 17:40 |


