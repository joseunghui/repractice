package com.repractice.board.controller.dto.mapper;

import com.repractice.board.controller.dto.WriteBoardFormDto;
import com.repractice.board.domain.model.commands.WriteBoardCommand;
import com.repractice.common.config.MapstructConfig;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper(config = MapstructConfig.class)
public abstract class WriteBoardMapper {

    // dateTime을 현재 시각으로 설정 해야 함
    @Mapping(target = "dateTime", ignore = true)
    // bnumber 설정
    @Mapping(target = "bnumber", ignore = true)

    public abstract WriteBoardCommand dtoToCommand(WriteBoardFormDto form);

    @AfterMapping
    protected void afterMappingToCommand(
            @MappingTarget final WriteBoardCommand.WriteBoardCommandBuilder targetBuilder,
            WriteBoardFormDto dto) {

        // 생년 월일을 현재 날짜로 변경해서 저장
        targetBuilder.dateTime(LocalDateTime.now());

        // bnumber 설정
        targetBuilder.bnumber(dto.getWriter() + dto.getDataTime());
    }
}
