package com.repractice.board.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class AddMemberFormDto {

    @NotBlank(message = "사이트에서 사용할 이름을 입력해주세요")
    private String username;
    
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String pw;
    
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;
    
    
}
