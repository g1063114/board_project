package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select count(comments) from Board b where b.id =: boardId")
    public int getCommnetCount(@Param("boardId") Long boardId);
}
