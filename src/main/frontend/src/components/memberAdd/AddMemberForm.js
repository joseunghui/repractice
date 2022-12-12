import React, {useState} from "react";
import axios from "axios";

const AddMemberForm = () => {

    const [values, setValues] = useState({
        // MEMBER : id(Long, sequence), username, pw(비번 확인O), email
        username: "",
        pw: "",
        confirmPw: "",
        email: "",
    });

    const onChangeInput = (e) => {
        const {name, value} = e.target;
        setValues({...values, [name]: value});


    };

    const onChickInput = (e) => {
        e.preventDefault();

        // axios
        axios.post('/member/add', null, { params: {
            username: values.username,
                pw: values.pw
            }
        }).then(() => {

            document.location.href = "/member/login";
            console.log("회원가입 실행");
        }).catch((Error) => {
            console.log("회원가입 에러 발생");
        });
    }

    return (
      <div>
          <h4>회원가입</h4>
        <form>
            <input name={"username"} type={"text"} placeholder={"ID를 입력하세요."} onChange={onChangeInput} /><br/>
            <input name={"pw"} type={"password"} placeholder={"비밀번호를 입력하세요."} onChange={onChangeInput} /><br/>
            <input name={"confirmPw"} type={"password"} placeholder={"비밀번호를 확인해주세요."} onChange={onChangeInput} /><br/>
            <input name={"email"} placeholder={"E-mail을 입력하세요."} onChange={onChangeInput} /><br/><br/>

            <button type={"submit"} onClick={onChickInput}>회원가입</button>
        </form>
      </div>
    );
};

export default AddMemberForm;