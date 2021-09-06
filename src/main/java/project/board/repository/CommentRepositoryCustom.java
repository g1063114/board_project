package project.board.repository;

import project.board.entity.Comment;

import java.util.List;

public interface CommentRepositoryCustom {

    // 댓글 계층 출력
    List<Comment> findAllCommentCustom(Long boardId);
}
