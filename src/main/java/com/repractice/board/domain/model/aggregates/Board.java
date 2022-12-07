package com.repractice.board.domain.model.aggregates;

import com.repractice.board.domain.model.commands.WriteBoardCommand;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Board")
public class Board {

    /**
     * 게시판 :
     * id(sequence)
     * bnumber(글 번호)
     * dateTime(작성일자)
     * title(글 제목)
     * content(글 내용)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bnumber")
    @NotNull
    private String bnumber;

    @NotNull
    private String writer;

    private LocalDateTime dateTime;

    @NotNull
    private String title;

    @NotNull
    private String content;

    public Board(WriteBoardCommand command) {
        this.bnumber = command.getBnumber();
        this.writer = command.getWriter();
        this.dateTime = command.getDateTime();
        this.title = command.getTitle();
        this.content = command.getContent();
    }

    public Board() {

    }

}
