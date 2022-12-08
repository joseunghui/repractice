import React, {useState} from "react";
import axios from "axios";

const WriteBoardForm = () => {
    
    console.log("WriteBoardForm 실행")

    const [values, setValues] = useState({
        // BOARD TABLE
        // bnumber(자동 sequence), writer, dateTime(LocalTime), title, content
        writer: "",
        title: "",
        content: ""
    });

    const onchangeInput = (e) => {
        // Input에 값 입력 시, value 변경
        console.log("input 입력 : ", values.writer, values.title, values.content);

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
            console.log("/board/write -> axios 실행")
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

            <span style={{display: 'inline-block'}}>
                이거 잘 뜨나?
            </span>

        </div>
    );
};

export default WriteBoardForm;