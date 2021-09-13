package project.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import project.board.entity.Member;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class BoardForm {

    @NotEmpty(message = "제목은 필수 입니다.")
    private String title;
    private String content;
    private String writer;

}
