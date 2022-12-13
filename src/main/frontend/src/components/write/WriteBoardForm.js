import React, {useState} from "react";
import axios from "axios";
import Board from "../../modules/models/Board";

const WriteBoardForm = () => {

    const [values, setValues] = useState({Board});

    const onchangeInput = (e) => {
        const {name, value} = e.target;
        setValues({...values, [name]: value});
    };

    const onClickBtn = (e) => {
        e.preventDefault();

        // axios.post(url[, data[, config]]) 라서 JSON으로 데이터 보내려면 두번째 인자는 null을 넣어야 함
        axios.post('/board/write',null, { params: {
                writer: values.writer,
                title: values.title,
                content: values.content
            }
        }).then(() => {
            document.location.href = "/board";
        }).catch((Error) => {
            console.log("WriteBoardForm.js ==> 글 등록 시 에러 발생")
        });
    };

    return (
        <div>
            <form>
                <input name={"title"} type={"text"} placeholder={"제목"} onChange={onchangeInput}/><br/>
                <input name={"writer"} type={"text"} placeholder={"작성자"} onChange={onchangeInput}/><br/>
                <textarea name={"content"} cols={30} rows={10} placeholder={"내용"} onChange={onchangeInput}></textarea><br/>
                <input type={"hidden"} name={"dateTime"} onChange={onchangeInput}/>

                <button type={"submit"} onClick={onClickBtn}>등록</button>
            </form>
        </div>
    );
};

export default WriteBoardForm;