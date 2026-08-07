// pages/index.js
import React, {useEffect , useState} from 'react';
import { useSelector, useDispatch } from "react-redux";
import { fetchPostsRequest , updatePostRequest , deletePostRequest} from "../reducers/postReducer";
import { Spin} from "antd";
import PostList from '../components/PostList';
import EditPostModal from '../components/EditPostModal';

export default function Home(){
    const dispatch = useDispatch();
    const { user } = useSelector( (state)=>state.auth);
    const { posts, loading, error} = useSelector( (state)=>state.post);

    //수정모달 : isEditModalVisible , setIsEditModalVisible
    const [isEditModalVisible , setIsEditModalVisible] = useState(false);
    const [uploadFiles, setUploadFiles] = useState([]);
    //수정할 글 : editPost , setEditPost
    const [editPost , setEditPost] = useState(null);
    
    //수정기능 : handleEditSubmit
    const handleEdit = (post)=>{
        setEditPost(post);   // 수정글셋팅
        setIsEditModalVisible(true);  // 수정화면 보이기
        setUploadFiles([]);
    };
    // ##2. saga 넘기는 데이터 확인 { userId, postId, dto, files }
    const handleEditSubmit = (values)=>{
        dispatch( updatePostRequest({ 
            userId: user?.id ,
            postId: editPost.id , 
             dto:{
                content: values.content,
                hashtags: Array.isArray(values.hashtags)
                ? values.hashtags.join(",")
                : values.hashtags,
            } ,
             files: uploadFiles
        }) );  // 수정기능 후
        setIsEditModalVisible(false); // 화면안보이기 
        setEditPost(null);
    };

    const handleDelete = ( postId)=>{
        dispatch(deletePostRequest(postId));  // 해당글번호
    };

    // 페이지가 처음뜰때 게시글 조회 액션 - dispatch
    useEffect( ()=>{
        dispatch(fetchPostsRequest());
    }, [dispatch]);
    //////////
    return (
        <>
            <PostList 
                posts={posts}
                handleEdit={handleEdit}    
                handleDelete={handleDelete}
            />
            <EditPostModal 
                visible={isEditModalVisible}
                onCancel={()=> setIsEditModalVisible(false)}
                editPost={editPost}
                onSubmit={handleEditSubmit}    
                uploadFiles={uploadFiles}
                setUploadFiles={setUploadFiles}
            />
        </>
    );
}
//npm run dev
//  {/* 수정부품 */}