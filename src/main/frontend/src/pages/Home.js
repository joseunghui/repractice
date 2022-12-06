import React from "react";
import {Link} from "react-router-dom";

const Home = () => {
    
    return (
        <>
            <Link to="/board/write">
                <button>글쓰기</button>
            </Link>
            <Link to="/board">
                <button>게시판 목록</button>
            </Link>
        </>
    )
}

export default Home;