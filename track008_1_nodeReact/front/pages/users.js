import { useSelector, useDispatch } from 'react-redux';  // 전역상태, 상태알림
import { useState   , useEffect   } from 'react';  // 변수상태변경, 이벤트변경
import { useRouter } from 'next/router';  // 경로
import { 
   LOAD_USERS_REQUEST, LOG_OUT_REQUEST, UPDATE_NICKNAME_REQUEST, DELETE_USER_REQUEST
} from '../reducers/user';

// useSelector - 전역상태
// useState    - 변수
// useEffect   - 이벤트변경감지
// useDispatch - 스토어알림
// useRouter   - 경로
export default function UsersPage(){
   //1. 코드
   const dispatch = useDispatch();
   const router   = useRouter();
   const {users, isLoading, error, me } = useSelector( (state)=> state.user );

   //1-1 사용자목록불러오기
   useEffect( ()=> {
       if(!me){ router.push('/login'); }  // 로그인이 안되어 있으면, 로그인페이지로 이동
       else{ dispatch({ type:LOAD_USERS_REQUEST }); }  //사용자목록요청
   } , [me, router]);
   //1-2 로그아웃
   const onLogout = ()=>{ dispatch({type:LOG_OUT_REQUEST});  };
   useEffect( ()=>{ if(me === null) router.push('/login'); }, [me, router]);
   //1-3 유저삭제
   const onDelete = (id)=>{
      dispatch({ type: DELETE_USER_REQUEST , data: {id} });
   }

   //1-4 닉네임수정
   const [editId, setEditId] = useState(null);  //닉네임 수정할 id
   const onEdit   = (id)=>{ setEditId(id)};

   const [newNickName, setNewNickName] = useState('');
   const onUpdateNickname = ()=>{
      dispatch({ type: UPDATE_NICKNAME_REQUEST , data:{ id: editId, nickname:newNickName }});
      setEditId(null);
      setNewNickName('');
   };

   //2. 뷰 - 렌더링  <></> , 공백 , 닫기태그
   return (
      <div className="container my-4">
         <h3 className="mb-3">사용자 목록</h3>
         {/* 로딩/에러 상태 표시 */}
         {isLoading && <div className="alert alert-info">로딩 중...</div>}
         {error     && <div className="alert alert-danger">에러메시지</div>}

         {/* 사용자 목록 테이블 */}
          <table className="table table-striped table-bordered table-hover">
            <caption>사용자 목록</caption>
            <thead>
               <tr>
                  <th scope="col">EMAIL</th>
                  <th scope="col">NICKNAME</th>
                  <th scope="col">UPDATE/DELETE</th>
               </tr>
            </thead>
            <tbody>
               {users.map( (u)=>(<tr key={u.id}>
                  <td>{u.email}</td>
                  <td>{ editId === u.id
                     ? <input type="text" className='form-control' placeholder='새닉네임입력'
                        value={newNickName} onChange={ (e) => setNewNickName(e.target.value) }/>
                     : (u.nickname)
                  }</td>
                  <td>{ editId === u.id
                     ? <button className="btn btn-primary btn-sm me-3" onClick={ ()=> onUpdateNickname(u.id)}>수정 완료</button>
                     : <button className="btn btn-primary btn-sm me-3" onClick={ ()=> onEdit(u.id)}>닉네임 수정</button>
                  }
                     <button className="btn btn-danger btn-sm" 
                        onClick={()=> onDelete(u.id)}>삭제</button>
                     </td>
               </tr>) )}
            </tbody>
          </table>

         {/* 로그아웃 버튼 */}
         {me && 
         <div className="mt-3">
            <button className="btn btn-secondary"   onClick={onLogout}>로그아웃</button>
         </div>
         }
      </div>
   );  
};