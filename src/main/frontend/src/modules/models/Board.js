import React from "react";
import {useState} from "@types/react";

const Board = () => {
    const [values, setValues] = useState({
        // BOARD TABLE
        // bnumber(자동 sequence), writer, dateTime(LocalTime), title, content
        writer: "",
        title: "",
        content: ""
    });
};

export default Board;