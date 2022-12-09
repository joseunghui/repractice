import React, {useState} from "react";
import axios from "axios";

const BoardListForm = () => {

    const [list, setList] = useState([]);

    axios.post('/board', null, null)
        .then( response => {
            setList(response.data);
            console.log(response.data);
        })
        .catch((Error) => {
            console.log("BoardListForm.js 오류")
        });

    const BoardList = ({list}) => {
        return (
            <div>
                <h3>boardList</h3>
            </div>
        );
    };


};

export default BoardListForm;