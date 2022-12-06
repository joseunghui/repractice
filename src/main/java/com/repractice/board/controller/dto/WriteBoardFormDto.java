package com.repractice.board.controller.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class WriteBoardFormDto {

    @NotBlank(message = "로그인 후 이용해주세요. (샘플임)")
    private String writer;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    private String dataTime;
}
