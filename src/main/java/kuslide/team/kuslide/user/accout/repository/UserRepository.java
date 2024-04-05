package kuslide.team.kuslide.user.accout.repository;

import kuslide.team.kuslide.user.accout.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetail, Long> {

    Optional<UserDetail> findByEmail(String email);

    boolean existsByNickname(String nickname);
}
