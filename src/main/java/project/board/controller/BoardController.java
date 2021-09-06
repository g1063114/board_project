package project.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.board.dto.BoardForm;
import project.board.dto.CommentForm;
import project.board.dto.MemberForm;
import project.board.entity.Board;
import project.board.entity.Comment;
import project.board.entity.Member;
import project.board.service.BoardService;
import project.board.service.CommentService;
import project.board.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final CommentService commentService;

    @GetMapping("/board/new")
    public String createBoard(Model model){

        List<Member> members = memberService.findMembers();
        model.addAttribute("boardForm",new BoardForm());
        model.addAttribute("members",members);

        return "board/createBoardForm";
    }

    @PostMapping("/board/new")
    public String postBoard(@Valid BoardForm boardForm){
        Board posting = new Board(boardForm.getTitle(), boardForm.getContent());
        Member findMember = memberService.findUserName(boardForm.getWriter());
        posting.settingMember(findMember);
        boardService.post(posting);
        return "redirect:/";
    }

    @GetMapping("/boards")
    public String boardList(Model model){
        List<Board> list = boardService.list();
        model.addAttribute("boardList",list);
        return "board/boardList";
    }

    @GetMapping("/board/{boardId}")
    public String boardDetail(@PathVariable("boardId") Long boardId, Model model){
        Board findOne = boardService.detail(boardId);
        CommentForm temp = new CommentForm();
        temp.setBoard(findOne);
        List<Comment> comments = commentService.commentList(findOne.getId());
        model.addAttribute("board",findOne);
        model.addAttribute("commentForm",temp);
        model.addAttribute("commentList",comments);
        return "board/detail";
    }

    @PostMapping("/board/{boardId}")
    public String updateDetail(@PathVariable Long boardId, @ModelAttribute("form") BoardForm form){
        boardService.updateBoard(boardId,form.getTitle(), form.getContent());
        return "redirect:/boards";
    }
}
