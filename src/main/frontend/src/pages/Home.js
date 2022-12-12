import React from "react";
import {Link, NavLink} from "react-router-dom";

const Home = () => {
    
    return (
        <>
            <Link to="/board/write">
                <button>글쓰기</button>
            </Link>
            <Link to="/board">
                <button>게시판 목록</button>
            </Link>
            <br/><br/><br/>
            <Link to="/member/add">
                <button>회원가입</button>
            </Link>
            <Link to="/member/login">
                <button>로그인</button>
            </Link>
        </>
    )
}

export default Home;