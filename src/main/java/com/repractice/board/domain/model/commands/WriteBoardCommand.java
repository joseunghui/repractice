package com.repractice.board.domain.model.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class WriteBoardCommand {
    private String bnumber;
    private String writer;
    private LocalDateTime dateTime;
    private String title;
    private String content;
}
