package com.repractice.board.application.internal.commandService;

import com.repractice.board.controller.dto.AddMemberFormDto;
import com.repractice.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMemberCommandService {

    private final MemberRepository memberRepository;

    public void addMember(AddMemberFormDto command) {

    }
}
