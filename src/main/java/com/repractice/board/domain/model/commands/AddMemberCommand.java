package com.repractice.board.domain.model.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AddMemberCommand {
    private String username;
    private String pw;
    private String email;
}
