import { useSelector, useDispatch } from 'react-redux';  // 전역상태, 상태알림
import { useState   , useEffect   } from 'react';  // 변수상태변경, 이벤트변경
import { useRouter } from 'next/router';  // 경로
import { LOG_IN_REQUEST } from '../reducers/user';

// useSelector - 전역상태
// useState    - 변수
// useEffect   - 이벤트변경감지
// useDispatch - 스토어알림
// useRouter   - 경로

export default function LoginPage(){
   //1. 코드
   // 초기화
   const dispatch = useDispatch();
   const router = useRouter();
   const {me, isLoading, error} = useSelector( (state)=> state.user );
   // form 연결
   const [email, setEmail]       = useState('');   // email 변수, email 셋팅함수
   const [password, setPassword] = useState('');

   //1-1. 회원가입했다고하면 알림창
   useEffect( ()=> {
      if( router.query.signUpSuccess == 'true') {
         alert('회원가입이 완료되었습니다. 로그인 해주세요');
         // 알림창 띄우고 쿼리제거 / 새로고침해도 알림창이 다시 안뜨게
         //          주소표시창줄, 주소표시창줄 감출필요 없어서
         router.replace('/login',             undefined, {shallow : true} );
      }
   }, [router.query]);
   //1-2. 로그인
   const onSubmit = (e)=>{
      e.preventDefault();
      if(!email.trim())   { alert('이메일을 입력해주세요.');  return; }
      if(!password.trim()){ alert('비밀번호를 입력해주세요.'); return; }
      dispatch({ type: LOG_IN_REQUEST , data:{ email, password } });
   };
   //1-3. 로그인후 사용자목록페이지로 이동
   useEffect(()=>{
      if(me) router.push('/users');    // replace : 주소표시창줄 바뀜, history추가 x
                                       // push    : 주소표시창줄 바뀜, history추가 o
   } , [me, router]);
   //2. 뷰 - 렌더링  <></> , 공백 , 닫기태그
   return (
      <div className="container my-4">
         <h3 className="mb-3">로그인</h3>
         <form className="w-50 mx-auto" onSubmit={onSubmit} >
         {/* 이메일 입력 */}
         <div className="mb-3">
            <input type="email" className="form-control" 
               placeholder="이메일" title="이메일입력" 
               value={email}
               onChange={(e)=>{ setEmail(e.target.value);}}/>
         </div>
         {/* 비밀번호 입력 */}
         <div className="mb-3">
            <input type="password" className="form-control" 
               placeholder="비밀번호입력" title="비밀번호입력"
               value={password}
               onChange={(e)=>{ setPassword(e.target.value);}} />
         </div>
         {/* 버튼 입력 */}
         <div className="mb-3">
            <button type="submit" className="btn btn-primary w-100" disabled={isLoading}>로그인</button>
         </div>
         </form>
         {/* 에러 메시지 */}
         {error && <div className="alert alert-danger mt-3">{error}</div>}
      </div>
   ); 
};