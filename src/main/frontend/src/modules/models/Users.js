import React, {useState} from "react";

const Users = () => {
    const [values, setValues] = useState({
        // MEMBER : id(Long, sequence), username, pw(비번 확인O), email
        username: "",
        pw: "",
        confirmPw: "",
        email: "",
    });
};

export default Users;