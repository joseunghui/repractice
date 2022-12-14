import React, {useEffect, useState} from "react";
import axios from "axios";

const BoardListForm = () => {

    let [list, setList] = useState([]);

    useEffect(() => {
        axios.get('/board', null)
            .then((res) => {
                setList(res.data);
            })
            .catch((Error) => {
                console.log("BoardListForm.js 오류")
            });
    }, []);


    return (
        <div  style={{textAlign: "center"}}>
            <h4>글 목록</h4>
            <table style={{border : "1px solid", borderCollapse : "collapse", textAlign: "center"}}>
                {list.map( board =>
                        <tr style={{border : "1px solid"}}>
                            <td>{board.title}</td>
                            <td>{board.writer}</td>
                            <td>{board.dateTime.slice(0, 10)}</td>
                            <td>{board.content}</td>
                        </tr>
                )}
            </table>
        </div>
    )
};

export default BoardListForm;