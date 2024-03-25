package kuslide.team.kuslide.user.accout.entity;


import jakarta.persistence.*;
import kuslide.team.kuslide.board.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    /**
     * userId != 학교 이메일
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String email;

    private String password;

    @Column(unique = true)
    private String nickname;

    private String gender;

    private String major;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boardList = new ArrayList<>();

}
