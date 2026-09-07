
## Part002. Aws
■Step0. 회원가입 / 로그인
■Step1. EC2 
1. 인스턴스 생성
2. public ip
  > 3.35.233.110
3. ssh 클라이언트
  > ssh -i "thejoa703.pem" ubuntu@ec2-3-35-233-110.ap-northeast-2.compute.amazonaws.com

  ※ thejoa703.pem  보관주의
  ```bash
  chmod 400 "thejoa703.pem"     # 소유자(4: r-- 읽기만)  그룹(---)  다른사람(---) rwx
  ```
  - ctrl + ` = 터미널창
  ```
    # 1. 상속 권한 완전히 제거
    icacls "thejoa703.pem" /inheritance:r /grant:r "$($env:USERNAME):(R)"

    # 2. 혹시 남아있을 수 있는 다른 사용자 권한 강제 삭제
    icacls "thejoa703.pem" /remove "NT AUTHORITY\Authenticated Users"
    icacls "thejoa703.pem" /remove "BUILTIN\Users"
    icacls "thejoa703.pem" /remove "NT AUTHORITY\SYSTEM"
  ``` 

4. EC2에서 nginx
- 문지기
- 웹서버연결
- back와 front 연결설정

1. nginx 설치
```
sudo apt update
sudo apt install  nginx  -y
``` 

2. nginx 설정파일 수정
2-1.
```
sudo vi   /etc/nginx/sites-available/default
```

2-2. esc 눌러서 명령모드로 전환 
2-3. :%d 입력한뒤에 enter → 전체삭제
2-4. i 눌러서 입력모드전환  →  붙여넣기
2-5. esc   →  :wq!  저장후 종료
```


server {
    listen 80;
    server_name 3.35.233.110;

    # 프론트엔드 (Next.js SSR 서버)
    location / {
        proxy_pass http://localhost:3000;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
        proxy_set_header Cookie $http_cookie; 
    }

    # 백엔드 - 유저 인증 (/auth)
    location /auth {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 일반 API (/api)
    location /api {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 소셜 로그인 (/oauth2)
    location /oauth2 {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 백엔드 - 카카오/구글 리다이렉트 처리
    location /login/oauth2/ {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }

    # 프론트엔드에서 처리해야 하는 콜백
    location /oauth2/callback {
        proxy_pass http://localhost:3000;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_set_header Cookie $http_cookie;
    }

    # 정적 파일 경로
    location /uploads/ {
        alias /home/ubuntu/app/back/build/libs/uploads/;
        autoindex off;
    }
}


```
설명)
   location / {    ←  /여기경로로
        proxy_pass http://localhost:3000;   ←   포트번호 3000번호
        proxy_http_version 1.1;    ←  통신시 http 
        proxy_set_header Upgrade $http_upgrade;  ←  헤더 그대로  전달
        proxy_set_header Connection "upgrade";  ←  헤더 강제 설정
        proxy_set_header Host $host;  ← host 백엔드로 전송
        proxy_cache_bypass $http_upgrade;  ←  연결시 캐시 사용안함.
        proxy_set_header Cookie $http_cookie; ←  쿠키백엔드 서버로 전달
    }

3. nginx 실행 및 테스트
```
sudo nginx -t
sudo systemctl restart nginx
```
5. ECR 리포지토리
- 애플리케이션을 docker이미지로 빌드해서 ecr에 올려두면 어디서든지 가져다가 사용가능하게

    ※ ECR 검색 
    1) 리포지토리이름
    2) 이미지 태그설정  - Mutable (연습용-latest 덮어쓸 수 있음)
    3) 암호화설정 - 기본키 그대로
    ```
    132058735336.dkr.ecr.ap-northeast-2.amazonaws.com/thejoa703
    ```

6. 필수패지키 설정

1) 시스템 업데이트
```
sudo apt  update  &&  sudo apt upgrade -y
```
2) java 17 설치
```
sudo apt install  openjdk-17-jdk   -y
java -version
```
3) git     설치
```
sudo apt install git -y
```
4) docker  설치
```bash
sudo apt install docker.io -y
sudo systemctl enable docker  &&  sudo systemctl start docker
sudo usermod   -aG  docker $USER
#    사용자계정  시스템그룹 docker
#    현재로그인한 사용자에게 docker그룹권한줘서 sudo없이 docker명령어사용가능 
```

5) node.js & npm 설치
```
curl -fsSL https://deb.nodesource.com/setup_24.x | sudo -E bash -
sudo apt install  -y  nodejs
```

6) pm2 설치 ( 계속 실행 - 무중단 자동 재실행 )
```
sudo npm install -g pm2
```

7) nginx 설치 (위에서 설치함)
```
sudo apt install nginx -y
```

8) 실행디렉토리 생성
```bash
#1. 상위폴더 및 uploads 폴더까지 한번에 생성 (-p옵션)
mkdir  -p  /home/ubuntu/app/back/build/libs/uploads

#2. 홈 프로젝트 기본디렉토리 권한설정 (소유자는 모든권한, 그룹/타인은 읽기/실행권한)
sudo chmod  755     /home/ubuntu
sudo chmod  755     /home/ubuntu/app
sudo chmod  755     /home/ubuntu/app/back/build/libs/uploads
sudo chmod  644     /home/ubuntu/app/back/build/libs/uploads/*   # 이미생성
```

9) swap
```bash
  sudo fallocate -l 2G /swapfile
  sudo chmod 600 /swapfile
  sudo mkswap /swapfile
  sudo swapon /swapfile
  echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab
  free -h

  # sudo fallocate -l 2G /swapfile  ←  2GB 파일생성
  # sudo chmod 600 /swapfile  ←  권한유저(rwx)
  # sudo mkswap /swapfile  ←  스왑초기화
  # sudo swapon /swapfile  ←  스왑활성화
  # echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab  ←  설정파일 끝에 추가
  # free -h  ←  메모리 확인
```

10) docker- oracle 컨테이너 실행 ( pull , run , ps , start )
```
sudo docker run -d --name oracle-xe -p 1521:1521 -p 5500:5500 -e ORACLE_PASSWORD=1234 gvenzl/oracle-xe:18-slim
```

11) 접속확인
```bash
        # 1. 오라클이 완전히 실행될 때까지 로그 확인
        sudo docker logs -f oracle-xe | grep "DATABASE IS READY TO USE"

        # 2. system 계정으로 접속 (비밀번호 변경 반영)
        sudo docker exec -it oracle-xe sqlplus system/1234@XE

        # --- (이후 sqlplus 프롬프트 안에서 아래 명령어들을 한 줄씩 실행) ---
        CREATE USER scott IDENTIFIED BY tiger;
        GRANT CONNECT, RESOURCE TO scott;

        CREATE USER boot IDENTIFIED BY react;
        GRANT CONNECT, RESOURCE TO boot;
        exit;

        # 3. 새로 만든 scott 계정으로 접속 확인
        sudo docker exec -it oracle-xe sqlplus boot/react@XE
```

12) docker- redis
```
sudo docker run   -d --name redis   -p 6379:6379   --restart=always   redis:7
```
13) 컨테이너 상태확인
```
sudo docker ps
```

14) ping 테스트
```
sudo docker exec -it redis  redis-cli ping
```

15) ec2 자체에서 자동 실행설정
```
 sudo docker update --restart=always oracle-xe 
 sudo docker update --restart=always redis
```

7. IM 사용자/역할 생성
1) IAM 콘솔 → 사용자추가
2) 권한정책:  
  `AmazonEC2FullAccess` , `AmazonECS_FullAccess` , `AmazonEC2ContainerRegistryFullAccess`
3) Access Key / Secret Key 발급
4) Github Secrets 에 저장
- `AmazonEC2FullAccess`   →  EC2 인스턴스 관리 
- `AmazonECS_FullAccess`     →  ECS/Faragate 서비스관리 
    > Github Actions, Jenkins 외부도구에서 빌드한 도커이미지를 AWS ECR에 올리고
    > 자동배포해주는 권한셋팅
- `AmazonEC2ContainerRegistryFullAccess` →  Docker이미지를 푸시/풀 할수 있게. 레지스트리 접근  



■Step2. GITHUB 
> CI/CD
CI : 지속적 통합
    - 공용저장소에 자주병합
    - 자동빌드/테스트를 통해서 조기에 버그 발견
CD :  지속적 제공/배포
    - 자동으로 프로덕션 환경에 배포

1. git repository 새로만들기
> https://github.com/mundaewon1/track009_aws.git

2. Actions secrets and variables 시크릿키설정




...........................

■Step3. 워크플로우 작성 및 프로젝트 올리기

1. 구조확인
```
track009_aws/                ← 깃허브 저장소 루트
├── .git                  ← Git 저장소 메타데이터
├── .gitignore            ← 불필요한 파일 제외 설정
├── BACK/                 ← 백엔드 (Spring Boot)
│   ├── src/              ← 소스 코드
│   ├── build.gradle      ← Gradle 빌드 설정
│   └── ...               ← 기타 설정/리소스
├── FRONT/                ← 프론트엔드 (React + Next.js)
│   ├── src/              ← 소스 코드
│   ├── package.json      ← npm 의존성 관리
│   └── ...               ← 기타 설정/리소스
└── .github/
    └── workflows/
        └── deploy.yml    ← GitHub Actions 워크플로우 파일
```
git clone https://github.com/mundaewon1/track009_aws.git


1) back  파일 수정
SecurityConfig.java
application.yml
application_oauth.yml

2) front 파일수정
> 이미지파일 설정

3) jar 파일 - boot3
```
./gradlew clean build -x test --refresh-dependencies
```
[boot3]-[build]-[libs]

...........................
4) deploy.yml


...........................
5) 빌드
```
git add .
git commit -m 'test deploy-1'
git push origin main
```

6) 외부테스트
http://3.35.233.110

``` 오류시 확인
1) ssh 접속
2) pm2 list
3) pm2 logs backend

pm2 logs backend --out --lines 200 | grep -E -A 5 "(Exception|Caused by|Error)"
```

해결1)
```bash
#1. 도커에 오라클접속
sudo docker exec -it oracle-xe sqlplus system/1234@XE

#2. 테이블스페이스 할당량 권한 부여
ALTER USER boot QUOTA UNLIMITED ON USERS;
```

