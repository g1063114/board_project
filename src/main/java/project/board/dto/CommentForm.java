package project.board.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CommentForm {

    @NotEmpty(message = "내용은 입력 필수입니다.")
    private String content;
}
