package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.entity.Board;
import project.board.entity.Comment;
import project.board.repository.BoardRepository;
import project.board.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 작성
    @Transactional
    public Long postComment(Comment comment){
        Comment save = commentRepository.save(comment);
        return save.getId();
    }
}
