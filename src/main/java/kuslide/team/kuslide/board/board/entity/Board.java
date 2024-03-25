package kuslide.team.kuslide.board.board.entity;

import jakarta.persistence.*;
import kuslide.team.kuslide.user.accout.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardId;

    private String title;

    private String content;

    @CreationTimestamp
    private LocalDateTime writeDate;

    private int heart;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserDetail userDetail;
}