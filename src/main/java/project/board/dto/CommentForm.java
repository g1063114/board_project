package project.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.board.entity.Board;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentForm {

    @NotEmpty(message = "내용은 입력 필수입니다.")
    private String content;
    private Board board;

}
