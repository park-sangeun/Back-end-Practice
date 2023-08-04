# Back-end-Exercise
>Back-end Server 한이음 실제 사용 서버이다.

## 1_login 연결
Front와 Back login 및 signup을 연결한 코드이다.
1. 기본 시작-/member/login </br>
  1-1. 계정생성 필요 시 아래 버튼 클릭 ->signup으로 넘어감 </br>
  1-2. 접속 시 저장된 계정만 접근 가능 ->id, password 입력 후 로그인 클릭 </br>
2. 회원 가입-/member/signup </br>
  2-1. name, userId, user_password로 가입 가능 ->login으로 넘어감 </br>
  2-2. 만약 계정이 있으면 ->바로 login으로 이동 </br>
3. main-/main </br>
로그인 성공 시 main페이지 진입 </br>

4. 관리자 접근-/admin/list </br>
가입한 회원 목록 확인 가능 </br>
삭제 선택 시 팝업창 띄운 후 삭제 </br>

## 2_Data 연결
라즈베리파이(MariaDB)에서 서버(MySQL)로 예제 데이터 5초마다 전송

## 3_Video 연결
스트리밍 영상 관련 video DB에 저장 및 출력 코드이다.
1. 
