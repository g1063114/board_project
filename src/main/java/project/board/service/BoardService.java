package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.entity.Board;
import project.board.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시판 게시
    @Transactional
    public Long post(Board form){
        Board posting = boardRepository.save(form);
        return posting.getId();
    }

    // 게시판 출력
    public List<Board> boardList(){
        return boardRepository.findAll();
    }
}
