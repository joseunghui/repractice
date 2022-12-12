package com.repractice.board.domain.model.aggregates;

import com.repractice.board.domain.model.commands.AddMemberCommand;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Membeer")
public class Member {
    /**
     * 회원 :
     * id(sequence),
     * username,
     * pw,
     * email
     */

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String pw;

    @NotNull
    private String email;

    public Member(AddMemberCommand command) {
        this.username = command.getUsername();
        this.pw = command.getPw();
        this.email = command.getEmail();
    }

    public Member() {
    }
}
