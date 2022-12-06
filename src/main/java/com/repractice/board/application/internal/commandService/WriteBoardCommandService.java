package com.repractice.board.application.internal.commandService;

import com.repractice.board.domain.model.aggregates.Board;
import com.repractice.board.domain.model.commands.WriteBoardCommand;
import com.repractice.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteBoardCommandService {
    private final BoardRepository boardRepository;

    // board/write
    public Board writeBoard(WriteBoardCommand command) {

        // command 사용해서 parameter 내용 board 객체에 담기
        Board board = new Board(command);
        // board 객체에 담긴 내용 JPA - save 로 저장
        boardRepository.save(board);

        return board;
    }
}
