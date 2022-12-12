package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.AddMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddMemberController {
    private final AddMemberService addMemberService;

    @PostMapping("/member/add")
    public ResponseEntity add() {
        return new ResponseEntity(
                getSuccessHeader(),
                HttpStatus.OK
        );
    }

    // Http header 이용 에러 설정
    protected HttpHeaders getSuccessHeader() {
        HttpHeaders headers = new HttpHeaders();

        headers.set("resultCode", "0000");
        headers.set("resultMessage", "청상 처리 하였습니다.");

        return headers;
    }
}
