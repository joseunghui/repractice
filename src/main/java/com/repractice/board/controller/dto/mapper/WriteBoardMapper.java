package com.repractice.board.controller.dto.mapper;

import com.repractice.board.controller.dto.WriteBoardFormDto;
import com.repractice.board.domain.model.commands.WriteBoardCommand;
import com.repractice.common.config.MapstructConfig;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public abstract class WriteBoardMapper {

    @Mapping(target = "dateTime", ignore = true)

//    public abstract WriteBoardCommand dtoToCommand(WriteBoardFormDto dto);

//    @AfterMapping
    protected void afterMappingToCommand(

    ) {

    }
}
