import React, {useState} from "react";
import axios from "axios";

const LoginForm = () => {

    const [values, setValues] = useState({
        // MEMBER : id(Long, sequence), memberId, pw, name, phone, birth, email
        memberId : "",
        pw : ""
    });

    const onChangeInput = (e) => {
        const {name, value} = e.target;
        setValues({...values, [name]: value});
    };

    const onClickBtn = (e) => {
        e.preventDefault();

        // axios
        axios.post('/member/login', null, {
            params: {
                memberId: values.memberId,
                pw: values.pw
            }
        }).then(() => {

        }).catch((Error) => {

        });
    };


    return (
        <div>
            <h4>로그인</h4>
            <form>
                <input name={"memberId"} type={"text"} placeholder={"아이디를 입력하세요."} onChange={onChangeInput}/>
                <input name={"pw"} type={"password"} placeholder={"비밀번호를 입력하세요."} onChange={onChangeInput}/>
                <button type={"submit"} onClick={onClickBtn}>로그인</button>
            </form>
            
            <a href={"/findId"}>아이디 찾기</a> <p>  </p>
            <a href={"/findPw"}>비밀번호 찾기</a>
        </div>
    );
};

export default LoginForm;