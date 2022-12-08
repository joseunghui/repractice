package com.repractice.board.apiController;

import com.repractice.board.application.internal.commandService.BoardListService;
import com.repractice.board.domain.model.aggregates.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.repractice.board.controller.constants.BoardWebUrl.BOARDLIST;

@RestController
@RequiredArgsConstructor
public class BoardListController {

    // service (Mapper 필요없음, 단순조회)
    private final BoardListService boardListService;

    @GetMapping(BOARDLIST)
    public ResponseEntity<Board> list() {

        //TODO 삭제
        System.out.println("board List Controller 실행됨!");

        // service에서 목록 가져오기
        boardListService.list();

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
