package io.github.kjs106203.KJSSpring;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private UserRepository userRepository;

    public HomeController(UserRepository m_userRepository) {
        userRepository = m_userRepository;
    }

    @GetMapping ("/") //www.naver.com/dfjdjflidf /뒤에 오는 url을 처리하기 위해 달아주는 annotation
    public String home(Model model) { //추가로 웹뷰를 제외한 다른 정보를 제공하고 싶을 때 model에  담아서 전송
        model.addAttribute("user", new User());
        return "home"; //최상단 주소에서 /가 오면 실행 (home이라는 문자열을 반환) -> spring 프레임워크가 받아서 templates 폴더의 home.html 문서를 찾아 사용자에게 보내줌
    }

    @GetMapping ("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping ("/idduplicate")
    public String idduplicate() {
        return "idduplicate"; //Spring에서는 return에 ""을 붙이면 templates의 파일로 인식
    }

    @PostMapping("/")
    public String getUserData(@Valid User user, Errors errors) { //@Valid가 붙었기 때문에 User는 유효성 검사를 하고 유효성 검사 결과가 만족되지 않으면 Error 출력
        if(errors.hasErrors()) {
            return "home"; //Spring에서는 return에 ""을 붙이면 templates의 파일로 인식
        }


        Optional result = userRepository.findById(user.getId()); //lombok이 getId를 만들어줌
        List res = userRepository.findByName("jiseong");

        System.out.println(res);

        if(result == Optional.empty()) {
            userRepository.save(user);
            return "redirect:/profile";
        } else {
            return "redirect:/idduplicate";
        }


    }

}
