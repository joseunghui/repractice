package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.BoardListService;
import com.repractice.board.application.internal.commandService.WriteBoardCommandService;
import com.repractice.board.controller.dto.WriteBoardFormDto;
import com.repractice.board.controller.dto.mapper.WriteBoardMapper;
import com.repractice.board.domain.model.aggregates.Board;
import com.repractice.board.domain.model.commands.WriteBoardCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.repractice.board.controller.constants.BoardWebUrl.WRITE_BOARD;

@RestController
@RequiredArgsConstructor
public class WriteBoardController {

    private final WriteBoardCommandService writeBoardCommandService;
    private final BoardListService boardListService;

    private final WriteBoardMapper writeBoardMapper;


    @PostMapping(WRITE_BOARD)
    public ResponseEntity write(
            @Valid @ModelAttribute("form") WriteBoardFormDto form) {

        // 글 작성 전에 수기로 입력하지 않은(작성 날짜) 입력 + 데이터 타입 변경해서 저장(LocalDateTime => String)
        WriteBoardCommand command = writeBoardMapper.dtoToCommand(form);

        // 글 작성 내용 등록
        writeBoardCommandService.writeBoard(command);

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
