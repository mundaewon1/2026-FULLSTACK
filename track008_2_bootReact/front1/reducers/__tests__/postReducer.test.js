//__test__/postReducer.test.js
import postReducer, {
        fetchPostsRequest , fetchPostsSuccess , fetchPostsFailure , 
        fetchPostsDetailRequest , fetchPostsDetailSuccess , fetchPostsDetailFailure , 
        createPostsRequest , createPostsSuccess , createPostsFailure , 
        updatePostsRequest , updatePostsSuccess , updatePostsFailure , 
        deletePostsRequest , deletePostsSuccess , deletePostsFailure , 
        resetUserState // 초기화
} from '../postReducer';

describe('post' , ()=>{
    const initialState={
        posts : [] ,       // 전체게시글 목록
        currentPost: null, // 단건 조회된 상세 게시글
        loading: false,
        error: null,
        success: false,
    };

    it('fetchPostsRequest & fetchPostsSuccess', ()=>{
        let state = postReducer( initialState , fetchPostsRequest());
        // 1. fetchPostsRequest() 실행 - 인자없음
        // 2. 리듀서툴킷에서 { type:fetchPostsRequest , payload:undefined } 객체만들기
        // 3. 리듀서의 fetchPostsRequest: (state, action)=>{} 액션받아서 처리
        //  action = { type:resetUserState , payload:undefined }
        expect(state.loading).toBe(true);

        const posts = [ {id:1, content:'첫 번째 글'} ];
        state = postReducer( initialState , fetchPostsSuccess(posts));
        expect(state.loading).toBe(false);
        expect(state.posts).toEqual(posts);
        expect(state.success).toBe(true);
    });
    // fetchPostsDetailSuccess  - 단건 조회
    it('fetchPostsDetailSuccess', ()=>{
        const post = [ {id:1, content:'첫 번째 글'} ];
        const state = postReducer( initialState , fetchPostsDetailSuccess(post));
        expect(state.currentPost).toEqual(post);
        expect(state.loading).toBe(false);
    });
    // createPostsSuccess   - 글쓰기
    it('createPostsSuccess', ()=>{
        const newPost = [ {id:3, content:'새 글'} ];
        const state = postReducer( initialState , createPostsSuccess(newPost));
        expect(state.posts[0]).toEqual(newPost);
        expect(state.success).toBe(true);
    });
    // updatePostsSuccess   - 글수정
    it('updatePostsSuccess', ()=>{
        const prev    = { ...initialState , posts : [ {id:3, content:'새 글'} ]};
        const updated = {id:3, content:'수정 후'};  //서버에서 받아온값

        const state = postReducer( prev , updatePostsSuccess(updated));
        expect(state.posts[0].content).toBe('수정 후');
        expect(state.currentPost).toEqual(updated);
    });
    // deletePostsSuccess   - 글삭제
    it('deletePostsSuccess', ()=>{
        const prev    = { ...initialState , posts : [ {id:1, content:'새 글'} ]};
        const state = postReducer( prev , deletePostsSuccess(1));
        expect(state.posts.length).toBe(0);
        expect(state.success).toBe(true);
    });
    // resetUserState   - 초기화
    it('resetUserState', ()=>{
        const prev    = { ...initialState , loading:true, error:'error', success:true};
        const state = postReducer( prev , resetUserState());
        expect(state.loading).toBe(false);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });
});

// npm test postReducer