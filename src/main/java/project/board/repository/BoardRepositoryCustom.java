package project.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.board.entity.Board;

import java.util.List;

public interface BoardRepositoryCustom {

    // 페이징 처리
    Page<Board> boardPaging(Pageable pageable);
}
