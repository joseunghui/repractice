import React from "react";
import axios from "axios";
import {Link} from "react-router-dom";

const BoardListForm = () => {

    axios.post('/board', null, null)
        .then(() => {
        })
        .catch((Error) => {
            console.log("BoardListForm.js 오류")
        });

    return (
        <>
            <h4>BoardListForm</h4>
            <ul>
                <li></li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
            </ul>
        </>
    )
};

export default BoardListForm;