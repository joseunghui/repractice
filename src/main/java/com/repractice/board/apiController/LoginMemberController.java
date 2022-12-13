package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.LoginMemberCommandService;
import com.repractice.board.domain.model.aggregates.Member;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Optional;

import static com.repractice.board.controller.constants.MemberWebUrl.MEMBER_LOGIN;

@RestController
@NoArgsConstructor
public class LoginMemberController {

    private LoginMemberCommandService loginMemberCommandService;

    @PostMapping(MEMBER_LOGIN)
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String pw) {

        // 해당 회원 username 값으로 Member 가져오기
//        Optional<Member> member = loginMemberCommandService.login(username);
        Member member = loginMemberCommandService.login(username);
        System.out.println("member = " + member);

        // 비번 동일한지 확인(암호화 안한 버전)
        if (!member.getPw().equals(pw)) {
            try {
                throw new Exception(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<> (
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
