package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsername(String username);
}
