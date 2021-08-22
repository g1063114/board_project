package project.board.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.board.repository.MemberRepository;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void init(){
        Member member1 = new Member("member1", new Address("서울", "화곡동", "07685"));
        Member member2 = new Member("member2", new Address("서울", "우장산동", "00001"));
        Member member3 = new Member("member3", new Address("서울", "발산동", "00002"));
        Member member4 = new Member("member4", new Address("서울", "화곡동", "00003"));

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();
    }

    @Test
    public void findByUsername(){
        List<Member> findMember = memberRepository.findByUsername("member1");
        Member member = findMember.get(0);

        assertThat(member.getUsername()).isEqualTo("member1");
    }
}