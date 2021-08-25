package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
