package project.board.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.entity.Member;
import project.board.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        // 회원 중복 검사
        duplicateCheck(member);
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    // 회원 중복 검사
    private void duplicateCheck(Member member) {
        List<Member> findMember = memberRepository.findByUsername(member.getUsername());
        if( !findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 리스트 출력
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 한명 출력
    public Member findOne(Long id){
        return memberRepository.findById(id).get();
    }

}
