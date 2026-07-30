// sagas/postSaga.js
import { all, call, put, takeLatest} from 'redux-saga/effects';
import axios from 'axios';
import {fetchPostsRequest , fetchPostsSuccess , fetchPostsFailure , 
        fetchPostsDetailRequest , fetchPostsDetailSuccess , fetchPostsDetailFailure , 
        createPostsRequest , createPostsSuccess , createPostsFailure , 
        updatePostsRequest , updatePostsSuccess , updatePostsFailure , 
        deletePostsRequest , deletePostsSuccess , deletePostsFailure , 
        resetUserState // 초기화
} from '../reducers/postReducer';

const POST_API_BASE = 'http://localhost:8080/api/posts';
// watchFetchPosts       -   GET      /api/posts         전체 게시글 조회 
export const fetchPostsAPI = ()=> axios.get(POST_API_BASE);
export function* fetchPosts(){
    try{
        const result = yield call(fetchPostsAPI);
        yield put( fetchPostsSuccess(result.data));
    }catch(err){
        yield put( fetchPostsFailure(err.response?.data?.message || err.message));
    }
}

// watchFetchPostsDetail -   GET      /api/posts{id}     게시글 단건 조회
export const fetchPostsDetailAPI = (id)=> axios.get(`${POST_API_BASE}/${id}`);
export function* fetchPostDetail(action){
    try{
        const result = yield call(fetchPostsDetailAPI , action.payload)  //action.payload 사용자가 넘겨준값
        yield put( fetchPostsDetailSuccess(result.data));
    }catch(err){
        yield put( fetchPostsDetailFailure(err.response?.data?.message || err.message));
    }
}
 
// watchCreatePost       -   POST     /api/posts         게시글 작성
export const createPostsAPI = (postData)=> axios.post( POST_API_BASE , postData );
export function* createPost(action){
    try{
        const result = yield call(createPostsAPI , action.payload)  //action.payload 사용자가 넘겨준값
        yield put( createPostsSuccess(result.data));
    }catch(err){
        yield put( createPostsFailure(err.response?.data?.message || err.message));
    }
}

// watchUpdatePost       -   PUT      /api/posts/{id}    게시글 수정  
export const updatePostsAPI = ({postId, dto}) =>
                                    axios.put( `${POST_API_BASE}/${postId}` , dto );
export function* updatePost(action){
    try{
        const result = yield call(updatePostsAPI , action.payload)  //action.payload 사용자가 넘겨준값
        yield put( updatePostsSuccess(result.data));
    }catch(err){
        yield put( updatePostsFailure(err.response?.data?.message || err.message));
    }
}

// watchDeletePost       -   DELETE   /api/posts/{id}    게시글 삭제 
export const deletePostsAPI = (id)=> axios.delete(`${POST_API_BASE}/${id}`);
export function* deletePost(action){
    // action = { type: , payload:{}}
    try{
        yield call(deletePostsAPI , action.payload)  //action.payload 사용자가 넘겨준값
        yield put( deletePostsSuccess(action.payload))
    }catch(err){
        yield put( deletePostsFailure(err.response?.data?.message || err.message));
    }
}

//  --- watch saga들 ---
function* watchFetchPosts(){        yield takeLatest( fetchPostsRequest.type , fetchPosts ); }
function* watchFetchPostsDetail(){  yield takeLatest( fetchPostsDetailRequest.type , fetchPostDetail ); }
function* watchCreatePost(){        yield takeLatest( createPostsRequest.type , createPost ); }
function* watchUpdatePost(){        yield takeLatest( updatePostsRequest.type , updatePost ); }
function* watchDeletePost(){        yield takeLatest( deletePostsRequest.type , deletePost ); }

export default function* postSaga() {
    yield all([
        call(watchFetchPosts),
        call(watchFetchPostsDetail),
        call(watchCreatePost),
        call(watchUpdatePost),
        call(watchDeletePost),
    ]);
}