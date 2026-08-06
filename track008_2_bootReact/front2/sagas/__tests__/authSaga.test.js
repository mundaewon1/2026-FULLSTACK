// sagas/__tests__/authSaga.test.js
// call - 동기 - 제너레이터함수 function* 일시중단 후 결과물 받기 / fork (비동기)
// put  - redux 액션처리
import { call, put } from 'redux-saga/effects';
import axios from 'axios';
import   {signupRequest , signupSuccess , signupFailure , resetUserState,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure
} from '../../reducers/authReducer';
import { signup, login, logout, updateNickname, updateProfileImage } from '../authSaga';

jest.mock('axios');

describe('auth saga', ()=>{
    afterEach(()=>{ jest.clearAllMocks() });
    // --- 회원가입 ---
    it('signup success', ()=>{
        const userData = { email: '1@1' , password:'1' };
        const action   = signupRequest(userData);
        const generator= signup(action);
        //1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다라는 가정하에 결과 값을 전달
        const mockResponse = { data: {email: '1@1'}};
        const putStep = generator.next( mockResponse ).value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(signupSuccess(mockResponse.data)) );
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료 done
    });

    // -- 로그인 --
    it('login', ()=>{
        const userData = { email: '1@1' , password:'1' };
        const action   = loginRequest(userData);
        const generator= login(action);
        //1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다라는 가정하에 결과 값을 전달
        const mockResponse = { data: {id:'1', email: '1@1', nickname:'first'}};
        const putStep = generator.next( mockResponse ).value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(loginSuccess(mockResponse.data)) );
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료 done
    });

    // -- 로그아웃 --
    it('logout', ()=>{
        const action   = logoutRequest();
        const generator= logout(action);
        
        //1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다라는 가정하에 결과 값을 전달
        const putStep = generator.next().value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(logoutSuccess()) );
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료 done
    });

    // -- 닉네임수정 --
    it('updateProfile', ()=>{
        const payload  = { userId:1 , nickname: 'new'};
        const action   = updateNicknameRequest( payload );
        const generator= updateNickname(action);
        
        //1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다라는 가정하에 결과 값을 전달
        const mockResponse = { data: {id:'1', nickname:'new'}};
        const putStep = generator.next(mockResponse).value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(updateNicknameSuccess( mockResponse.data )) );
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료 done
    });
    // -- 프로필이미지수정 --    
        it('updateProfileImage', ()=>{
        const payload  = { userId: 1, file: new Blob(['test']) };  // mypage.js
        const action   = updateProfileImageRequest( payload );
        const generator= updateProfileImage(action);
        
        //1. 1단계 API 호출 (call)
        const callStep = generator.next().value;
        expect(callStep.type).toBe('CALL');

        //2. api 성공했다라는 가정하에 결과 값을 전달
        const mockResponse = { data: {id:'1', ufile:'profile.png'}};
        const putStep = generator.next(mockResponse).value;

        //3. 2단계 성공액션 디스패치
        expect(putStep).toEqual( put(updateProfileImageSuccess( mockResponse.data )) );
        expect(generator.next().done).toBe(true);  // 제너레이터 완전종료 done
    });
});