■Step4. HTTPS + DOMAIN

1. DuckDns 도메인생성
    1) https://www.duckdns.org/
    2) 로그인
    3) SUB DOMAIN  ->  원하는이름.duckdns.org  ->  add domain
    4) ec2 public ip 연동
    5) Token
    ```
    mundaewon.duckdns.org
    a027860f-a279-47e9-aea4-b94e04616879
    ```

2. EC2 서버에서  DuckDns IP 자동 갱신설정
    > Aws EC2의 인스턴스를 중지했다 켜면, 퍼블릭 ip 주소가 바뀜

    1) ssh 접속
    2) duckdns 폴더만들기
    ```bash
    sudo mkdir  -p ~/duckdns
    cd  ~/duckdns
    ```
    3) duck.sh 쉘스크립트작성
    ```bash
    sudo  vi  duck.sh
    esc  , i
    esc  , :wq!
    ```
    ```bash
    echo url="https://www.duckdns.org/update?domains=도메인명&token=복사해둔토큰&ip=" | curl -k -o ~/duckdns/duck.log -K -

    echo url="https://www.duckdns.org/update?domains=mundaewon&token=a027860f-a279-47e9-aea4-b94e04616879&ip=" | curl -k -o ~/duckdns/duck.log -K -
    ``` 
    ```
    mundaewon.duckdns.org
    a027860f-a279-47e9-aea4-b94e04616879
    ```

    ※ -k : ssl/tls 인증서 건너뛰기
    ※ -o ~/duckdns/duck.log   :  성공 ok, 실패시 ko
    ※ -K 표준입력의 설정 ,,,,, 코드중간에  | curl 설정파일 형태로 읽어들이기

    4) 실행권한주기  소유자 모든권한, 그룹 x, 다른사람x

    ```sql
    sudo chmod 700 duck.sh
    crontab -e
    2

    */5 * * * *  /home/ubuntu/duckdns/duck.sh  >  dev/null  2>&1

    # */5 * * * *  년 [월일 시분] 초  <-
    # 분 시 일 월 요일

    # >/dev/null 화면에 안띄우기
    # 2>&1  에러메시지 무시처리

    crontab -l

    ```

3. Nginx 설정변경
1) 설정파일수정
    ```
    sudo vi   /etc/nginx/sites-available/default
    ```
    ```bash
    #  esc , i

    server {
        listen 80;
        server_name   mundaewon.duckdns.org;
        #   ... 기존내용그대로  ...
   } 
   # esc  :wq!
    ```   
2)  Nginx 재시작
```
sudo nginx -t
sudo systemctl restart nginx
```

4. Certbot으로 Https( SSL ) 인증서 발급받기
1) certbot설치
```bash
sudo apt  update
sudo apt  install snapd -y   #격리된환경
sudo snap install core; 
sudo snap refresh core
sudo snap install --classic certbot  #  certbot   SSL무료 인증서 발급도구
sudo ln -s /snap/bin/certbot /usr/bin/certbot  #  터미널 어디에서든지  certbot 사용가능
```

2) 인증서 발급명령어 실행
```bash
# sudo certbot --nginx -d mytestapp.duckdns.org
sudo certbot --nginx -d mundaewon.duckdns.org

# email 입력 - 만료알림용  ,  약관동의 y , 이메일수신 y , 리다이렉트 설정 2
```

5. 프로젝트 환경변수 및 설정 수정
> before  :  http://3.35.233.110
> after   :  https://mundaewon.duckdns.org

1) boot  :  SecurityConfig , yml
2) react : .env


6. 소셜마무리
1) 카카오개발자
2) 네이버개발자
3) 구글콘솔개발자

```
https://mundaewon.duckdns.org/login/oauth2/code/kakao
https://mundaewon.duckdns.org/login/oauth2/code/naver
https://mundaewon.duckdns.org/login/oauth2/code/google
```