// reducers/postReducer.js
import {createSlice} from "@reduxjs/toolkit";

const initialState={
    posts : [] ,       // 전체게시글 목록
    currentPost: null, // 단건 조회된 상세 게시글
    loading: false,
    error: null,
    success: false,
};

const postReducer=createSlice({
    name: "post",
    initialState ,
    reducers :{
        // --- 전체 게시글 ---
        fetchPostsRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        fetchPostsSuccess: (state , action)=>{
            state.loading = false;
            state.posts   = action.payload;
            state.success = true;
        },
        fetchPostsFailure: (state , action)=>{
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },
        // --- 단건 게시글 ---
        fetchPostsDetailRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        fetchPostsDetailSuccess: (state , action)=>{
            state.loading     = false;
            state.currentPost = action.payload;
            state.success     = true;
        },
        fetchPostsDetailFailure: (state , action)=>{
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },
        // --- 게시글 작성 ---
        createPostsRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        createPostsSuccess: (state , action)=>{
            state.loading = false;
            state.posts   = [action.payload,   ...state.posts]; // 새글을 목록상단추가
            state.success = true;
        },
        createPostsFailure: (state , action)=>{
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },
        // --- 게시글 수정 ---
        updatePostsRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        updatePostsSuccess: (state , action)=>{
            state.loading = false;
            state.posts   = state.posts.map( post=>
                post.id === action.payload.id ?action.payload : post
            );
            state.currentPost = action.payload;
            state.success = true;
        },
        updatePostsFailure: (state , action)=>{
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },
        // --- 게시글 삭제 ---
        deletePostsRequest: (state)=>{
            state.loading = true;
            state.error   = null;
            state.success = false;
        },
        deletePostsSuccess: (state , action)=>{
            state.loading = false;
            // 삭제된 게시글의 id받아서 목록에서 제외
            state.posts   = state.posts.filter(post=> post.id !== action.payload);
            state.success = true;
        },
        deletePostsFailure: (state , action)=>{
            state.loading = false;
            state.error   = action.payload;
            state.success = false;
        },
        // --- 상태 초기화 ---
        resetUserState : (state)=>{
            state.loading = false;
            state.error   = null;
            state.success = false;
        },

    }
});

export const {fetchPostsRequest , fetchPostsSuccess , fetchPostsFailure , 
        fetchPostsDetailRequest , fetchPostsDetailSuccess , fetchPostsDetailFailure , 
        createPostsRequest , createPostsSuccess , createPostsFailure , 
        updatePostsRequest , updatePostsSuccess , updatePostsFailure , 
        deletePostsRequest , deletePostsSuccess , deletePostsFailure , 
        resetUserState // 초기화
} = postReducer.actions;
export default postReducer.reducer;