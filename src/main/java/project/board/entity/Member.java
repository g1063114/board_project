package project.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    public Member(String username, Address address) {
        this.username = username;
        this.address = address;
    }
}
