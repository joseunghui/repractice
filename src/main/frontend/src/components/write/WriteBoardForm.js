import React, {useState} from "react";
import axios from "axios";

const WriteBoardForm = () => {

    const [values, setValues] = useState({
        // BOARD TABLE
        // bnumber(자동 sequence), writer, dateTime(LocalTime), title, content
        writer: "",
        title: "",
        content: "",
        dateTime: "",
    });

    const onchangeInput = (e) => {
        // Input에 값 입력 시, value 변경
        const {name, value} = e.target;
        setValues({...values, [name]: value})
    }

    const onClickBtn = (e) => {
        e.preventDefault();

        axios({
            method: "post",
            url: "/board/write",
            withCredentials: true,
            params: {
                writer: values.writer,
                title: values.title,
                content: values.content,
                dateTime: values.dateTime
            }
        }).then(() => {
            console.log("/board/write -> axios 실행")
            document.location.href = "/board";  //TODO:경로변경
        }).catch((Error) => { console.log("frontend>src>components>write>WriteBoardForm.js ==> 글 등록 시 에러 발생")});
    }

    return (
        <div>
            <form>
                <input name="title" type={"text"} placeholder="제목" onChange={onchangeInput}/><br/>
                <input name="writer" type={"text"} placeholder="작성자" onChange={onchangeInput}/><br/>
                <textarea name={"content"} cols={30} rows={10} placeholder={"내용"} onChange={onchangeInput}></textarea><br/>
                <input type={"hidden"} name={"dateTime"} onChange={onchangeInput}/>

                <button type="submit" onChange={onClickBtn}>등록</button>
            </form>
        </div>
    );
};

export default WriteBoardForm;