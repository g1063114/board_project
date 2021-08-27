package project.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.board.dto.BoardForm;
import project.board.dto.MemberForm;
import project.board.entity.Board;
import project.board.entity.Member;
import project.board.service.BoardService;
import project.board.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;

    @GetMapping("/board/new")
    public String createBoard(Model model){
        model.addAttribute("boardForm",new BoardForm());
        return "board/createBoardForm";
    }

    @PostMapping("/board/new")
    public String postBoard(@Valid BoardForm boardForm){
        Board posting = new Board(boardForm.getTitle(), boardForm.getContent(),boardForm.getWriter());
        boardService.post(posting);

        return "redirect:/";
    }
}
