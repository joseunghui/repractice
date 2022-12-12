package com.repractice.board.application.internal.commandService;

import com.repractice.board.domain.model.aggregates.Member;
import com.repractice.board.domain.model.commands.AddMemberCommand;
import com.repractice.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMemberCommandService {
    private final MemberRepository memberRepository;

    public Member addMember(AddMemberCommand command) {

        Member member = new Member(command);
        memberRepository.save(member);

        return member;
    }
}
