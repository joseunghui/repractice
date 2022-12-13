package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.LoginMemberCommandService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.repractice.board.controller.constants.MemberWebUrl.MEMBER_LOGIN;

@RestController
@NoArgsConstructor
public class LoginMemberController {

    private LoginMemberCommandService loginMemberCommandService;

    @PostMapping(MEMBER_LOGIN)
    public ResponseEntity login(
            @Valid @RequestParam String username, @RequestParam String pw
    ) {
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
