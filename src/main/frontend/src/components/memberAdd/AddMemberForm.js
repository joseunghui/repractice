import React, {useState} from "react";

const AddMemberForm = () => {

    const [values, setValues] = useState({
        // MEMBER : id(Long, sequence), memberId, pw, name, phone, birth, email
        memberId: values.memberId,
        pw: values.pw,
        name: values.name,
        phone: values.phone,
        birth: values.birth,
        email: values.email,
    });

    return (
      <div>
          <h4>회원가입</h4>
        {/*<form>
            <input name={"memberId"} placeholder={"ID를 입력하세요."} onChange={} />
        </form>*/}
      </div>
    );
};

export default AddMemberForm;