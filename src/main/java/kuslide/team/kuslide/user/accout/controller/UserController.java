package kuslide.team.kuslide.user.accout.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kuslide.team.kuslide.user.accout.dto.JoinRequest;
import kuslide.team.kuslide.user.accout.dto.LoginRequest;
import kuslide.team.kuslide.user.accout.entity.UserDetail;
import kuslide.team.kuslide.user.accout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest,
                                   HttpServletRequest request){
        UserDetail userDetail = userService.login(loginRequest);
//        if(userDetail != null){
//            HttpSession session = request.getSession();
//            session.setAttribute(SessionConst.LOGIN_MEMBER,userDetail);
//            session.setMaxInactiveInterval(60*60*24); // 세션 만료 24시간
//        }
        return ResponseEntity.ok("Success Login");
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinRequest joinRequest){
        return ResponseEntity.ok(userService.join(joinRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return ResponseEntity.ok("Success Logout");
    }
}
