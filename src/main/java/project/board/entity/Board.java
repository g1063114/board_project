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

    @OneToMany(mappedBy = "board")
    private List<Member> members = new ArrayList<>();

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void changePostMember(Member member){
        members.add(member);
        member.setBoard(this);
    }

}
