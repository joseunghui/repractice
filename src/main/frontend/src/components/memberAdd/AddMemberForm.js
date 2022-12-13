import React, {useState} from "react";
import axios from "axios";
import Users from "../../modules/models/Users";

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
                pw: values.pw,
                email: values.email
            }
        }).then(() => {
            document.location.href = "/member/login";
            console.log("회원가입 실행");
        }).catch((Error) => {
            console.log("회원가입 에러 발생");
        });
    }

    return (
      <div style={{textAlign: "center"}}>
          <h4>회원가입</h4>
        <form>
            ID : <input name={"username"} type={"text"} placeholder={"ID를 입력하세요."} onChange={onChangeInput} /><br/>
            PW : <input name={"pw"} type={"password"} placeholder={"비밀번호를 입력하세요."} onChange={onChangeInput} /><br/>
            PW 확인: <input name={"confirmPw"} type={"password"} placeholder={"비밀번호를 확인해주세요."} onChange={onChangeInput} /><br/>
            E-mail : <input name={"email"} type={"email"} placeholder={"E-mail을 입력하세요."} onChange={onChangeInput} /><br/><br/>

            <button type={"submit"} onClick={onChickInput}>회원가입</button>
        </form>
      </div>
    );
};

export default AddMemberForm;