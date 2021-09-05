package project.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import project.board.dto.BoardForm;
import project.board.dto.CommentForm;
import project.board.entity.Board;
import project.board.entity.Comment;
import project.board.service.BoardService;
import project.board.service.CommentService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/new")
    public String postComment(@Valid CommentForm form){
        Comment comment = new Comment(form.getContent());
        comment.settingComment(form.getBoard());
        comment.getBoard().addCommentCount();
        commentService.postComment(comment);
        return "redirect:/";
    }
}
