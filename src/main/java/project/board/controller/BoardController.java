package project.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.board.dto.BoardForm;
import project.board.service.BoardService;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/new")
    public String createBoard(Model model){
        model.addAttribute("boardForm",new BoardForm());
        return "board/createBoardForm";
    }
}
