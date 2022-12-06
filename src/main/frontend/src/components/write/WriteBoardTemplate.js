import React from "react";

const WriteBoardTemplate = ({children}) => {
    return (
        <>
            <h4>글을 씁시다~~~</h4>
            <div>
                {children}
            </div>
        </>
    );
};

export default WriteBoardTemplate;