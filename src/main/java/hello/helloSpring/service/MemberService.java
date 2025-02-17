package hello.helloSpring.service;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemberRepository;
import hello.helloSpring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member) {
        vaildateDuplicate(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMember() {
        return memberRepository.findall();
    }

    public Optional<Member> findOne(Long member_id) {
        return memberRepository.findById(member_id);
    }

    private void vaildateDuplicate(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}
