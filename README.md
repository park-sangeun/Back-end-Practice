# Back-end-Exercise
>Back-end Server 한이음 실제 사용 서버이다.

## 1_login 연결
Front와 Back login 및 signup을 연결한 코드이다.
1. 기본 시작-/member/login
  1-1. 계정생성 필요 시 아래 버튼 클릭 ->signup으로 넘어감
  1-2. 접속 시 저장된 계정만 접근 가능 ->id, password 입력 후 로그인 클릭
2. 회원 가입-/member/signup
  2-1. name, userId, user_password로 가입 버튼 클릭 ->login으로 넘어감
  2-2. 만약 계정이 있으면 ->바로 login으로 이동
3. main-/main
로그인 성공 시 바로 main페이지 진입

4. 관리자 접근-/admin/list
가입한 회원 목록 확인 가능
