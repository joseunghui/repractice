package com.repractice.board.application.internal.commandService;

import com.repractice.board.domain.model.aggregates.Board;
import com.repractice.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardListService {
    private final BoardRepository boardRepository;

    // board
    public List<Board> list() {

        List<Board> boardList = boardRepository.findAll();

        // TODO 삭제
        for (int i = 0; i < boardList.size(); i++) {
            System.out.println("boardList[" + i + "] : " + boardList.get(i));
        }


        return boardList;
    }
}
