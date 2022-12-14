package com.repractice.board.application.internal.commandService;

import com.repractice.board.domain.model.aggregates.Board;
import com.repractice.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardListCommandService {
    private final BoardRepository boardRepository;

    // board
    public List<Board> list() {

        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }
}
