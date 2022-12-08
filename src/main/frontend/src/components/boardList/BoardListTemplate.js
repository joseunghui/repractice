import React from "react";

const BoardListTemplate = ({children}) => {
    return (
        <>
            <h4>글 목록</h4>
            <div>
                {children}
            </div>
        </>
    );
};

export default BoardListTemplate;