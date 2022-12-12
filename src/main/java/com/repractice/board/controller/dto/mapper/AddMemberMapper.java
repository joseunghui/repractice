package com.repractice.board.controller.dto.mapper;

import com.repractice.board.controller.dto.AddMemberFormDto;
import com.repractice.board.domain.model.commands.AddMemberCommand;
import com.repractice.common.config.MapstructConfig;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapstructConfig.class)
public abstract class AddMemberMapper {

    public abstract AddMemberCommand dtoToCommand(AddMemberFormDto form);

    @AfterMapping
    protected void afterMappingToCommand(
            @MappingTarget final AddMemberCommand.AddMemberCommandBuilder targetBuilder,
            AddMemberFormDto dto) {
    }
}
