package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.entity.Board;
import project.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

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

    // 게시판 리스트 출력
    public List<Board> list(){
        return boardRepository.boardFetchJoin();
    }

    // 게시판 디테일 출력
    public Board detail(Long id){
        Optional<Board> findOne = boardRepository.findById(id);
        return findOne.get();
    }

    // 게시판 수정
    @Transactional
    public void updateBoard(Long id, String title, String content){
        Board findOne = boardRepository.findById(id).get();
        findOne.setTitle(title);
        findOne.setContent(content);
    }
}
