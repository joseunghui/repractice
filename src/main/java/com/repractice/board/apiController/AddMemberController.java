package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.AddMemberCommandService;
import com.repractice.board.controller.dto.AddMemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AddMemberController {
    private final AddMemberCommandService addMemberCommandService;

    @PostMapping("/member/add")
    public ResponseEntity add(
            @Valid @ModelAttribute("member") AddMemberFormDto form) {

        // 회원가입 등록
        addMemberCommandService.addMember(form);

        return new ResponseEntity<>(
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
