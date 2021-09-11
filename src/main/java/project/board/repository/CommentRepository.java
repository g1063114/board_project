package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.board.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>, CommentRepositoryCustom {

}
