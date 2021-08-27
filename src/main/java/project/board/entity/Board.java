package project.board.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Board extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    @Lob
    private String content;

    private String writer;

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
