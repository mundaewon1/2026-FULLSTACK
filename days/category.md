---
# 👤 3번 -  지역, 카테고리


| 구분 | 사용자 기능 | 관리자 기능 |
| --- | --- | --- |
| **Create** |  | * 지역 등록 |
| **Read** | * 지역별 인기 모임 조회  | * 지역 목록 조회<br>* 지역별 모임 통계 조회 |
| **Update** |  | * 지역 정보 수정 |
| **Delete** |  | * 지역 삭제 |

```mysql
-- 시도 테이블
CREATE TABLE sidos (
  sido_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

-- 시군구 테이블
CREATE TABLE sigungus (
  sigungu_id INT AUTO_INCREMENT PRIMARY KEY,
  sido_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  FOREIGN KEY (sido_id) REFERENCES sidos(sido_id)
);

```

| sido_id | name |
| --- | --- |
| 1 | 서울특별시 |
| 2 | 인천광역시 |

| sigungu_id | sido_id | name |
| --- | --- | --- |
| 1 | 1 | 강남구 |
| 2 | 1 | 종로구 |
| 3 | 2 | 연수구 |


※ 지역별 인기 모임 조회 
| 구분 | 사용자 기능 | 관리자 기능 |
| --- | --- | --- |
| **Read** | * 지역별 인기 모임 조회 → ``meetups`` + ``sigungus`` 조인 | * 지역별 모임 통계 조회 → ``meetups`` 집계 |

```sql
SELECT m.title, m.like_count, m.application_count
FROM meetups m
JOIN sigungus s ON m.region_id = s.sigungu_id
WHERE s.name = '강남구'
ORDER BY (m.like_count + m.application_count) DESC
LIMIT 3;
```

---

## 카테고리등록

| 구분 | 사용자 기능 | 관리자 기능 |
| --- | --- | --- |
| **Create** |  | * 카테고리 등록 |
| **Read** | * 카테고리별 인기 모임 조회 | * 카테고리 목록 조회<br>* 카테고리별 모임 통계 조회 |
| **Update** |  | * 카테고리 정보 수정 |
| **Delete** |  | * 카테고리 삭제 |


| id | parent_id | 카테고리명 |
| --- | --- | --- |
| 1 | NULL | 운동 |
| 2 | NULL | 문화 |
| 3 | NULL | 스터디 |
| 4 | 1 | 러닝 |
| 5 | 1 | 등산 |
| 6 | 2 | 영화 |
| 7 | 2 | 전시회 |
| 8 | 3 | 취업스터디 |

```sql
SELECT c.name AS category_name, m.title, m.like_count, m.application_count
FROM meetups m
JOIN categories c ON m.category_id = c.id
WHERE c.name = '등산'
ORDER BY (m.like_count + m.application_count) DESC
LIMIT 3;
```


| 구분 | 사용자 기능 | 관리자 기능 |
| --- | --- | --- |
| **Create** |  |  |
| **Read** | * 추천 모임 조회<br>* 관심사 기반 추천 | * 추천 알고리즘 모니터링<br>* 추천 결과 검증 |
| **Update** |  | * 추천 기준/가중치 수정 |
| **Delete** |  | * 추천 규칙 삭제 |


| 구분 | 사용자 기능 | 관리자 기능 |
| --- | --- | --- |
| **Create** |  |  |
| **Read** |  | * 대시보드 조회<br>* 지역별/카테고리별 모임 통계<br>* 신규 등록/삭제 현황 |
| **Update** |  | * 대시보드 설정 변경 (기간, 지표 선택) |
| **Delete** |  | * 불필요한 통계 지표 제거 |

