package kuslide.team.kuslide.user.accout.service;


import kuslide.team.kuslide.user.accout.dto.JoinRequest;
import kuslide.team.kuslide.user.accout.dto.LoginRequest;
import kuslide.team.kuslide.user.accout.entity.UserDetail;
import kuslide.team.kuslide.user.accout.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDetail login(LoginRequest loginRequest){
        UserDetail userDetail = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()-> new RuntimeException("Not Found User"));

        if(userDetail.getPassword().equals(loginRequest.getPassword())){
            return userDetail;
        }
        else{
            throw new RuntimeException("Not Match Password");
        }
    }

    @Transactional
    public String join(JoinRequest joinRequest) {
        if (!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        if (userRepository.existsByNickname(joinRequest.getNickname())) {
            throw new RuntimeException("닉네임이 이미 존재합니다.");
        }
        UserDetail userDetail = UserDetail.builder()
                .email(joinRequest.getEmail())
                .password(joinRequest.getEmail())
                .nickname(joinRequest.getNickname())
                .gender(joinRequest.getGender())
                .major(joinRequest.getMajor())
                .build();
        userRepository.save(userDetail);
        return "Success Join";
    }
}
