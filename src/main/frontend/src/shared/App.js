import React from "react";
import {Routes, Route} from 'react-router-dom';
import WriteBoardPage from "../pages/WriteBoardPage";
import {Home} from "../pages";


console.log("포트 백엔드 8080, 프론트 3000 첫 실행 ->")

function App () {

  return (
      <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/board" element={<Home />} />
          <Route path="/board/write" element={<WriteBoardPage />} />
      </Routes>
           );
}

export default App;
