package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.AddMemberCommandService;
import com.repractice.board.controller.dto.AddMemberFormDto;
import com.repractice.board.controller.dto.mapper.AddMemberMapper;
import com.repractice.board.domain.model.commands.AddMemberCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.repractice.board.controller.constants.MemberWebUrl.MEMBER_ADD;

@RestController
@RequiredArgsConstructor
public class AddMemberController {
    private final AddMemberCommandService addMemberCommandService;

    private final AddMemberMapper addMemberMapper;

    @PostMapping(MEMBER_ADD)
    public ResponseEntity add(
            @Valid @ModelAttribute("form") AddMemberFormDto form) {

        // 회원가입 등록
        AddMemberCommand command = addMemberMapper.dtoToCommand(form);
        addMemberCommandService.addMember(command);

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
