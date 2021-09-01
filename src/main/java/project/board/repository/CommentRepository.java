package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
