package com.repractice.board.application.internal.commandService;

import com.repractice.board.domain.model.aggregates.Member;
import com.repractice.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginMemberCommandService {
    private MemberRepository memberRepository;


    public Member login(String username) {
        System.out.println("username = " + username);

        Member member = memberRepository.findByUsername(username);

//        Optional<Member> member = memberRepository.findByUsername(username);
        System.out.println("member = " + member);

        // Validation
        if (member.getId().equals(null)) {
            try {
                throw new Exception(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return member;
    }
}
