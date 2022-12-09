import React, {useState} from "react";
import axios from "axios";

const BoardListForm = () => {

    let [list, setList] = useState([]);

    axios.post('/board', null, null)
        .then( (res) => {
            setList(res.data);
        })
        .catch((Error) => {
            console.log("BoardListForm.js 오류")
        });



    return (
        <div>

        </div>
    )
};

export default BoardListForm;