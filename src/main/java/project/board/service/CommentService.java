package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.entity.Board;
import project.board.entity.Comment;
import project.board.repository.BoardRepository;
import project.board.repository.CommentRepository;
import project.board.repository.CommentRepositoryCustom;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentRepositoryCustom commentRepositoryCustom;

    // 댓글 작성
    @Transactional
    public Long postComment(Comment comment){
        Comment save = commentRepository.save(comment);
        return save.getId();
    }

    // 댓글 출력
    public List<Comment> commentList(Long boardId){
        return commentRepositoryCustom.findAllCommentCustom(boardId);
    }
}
