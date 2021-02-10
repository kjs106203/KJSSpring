package io.github.kjs106203.KJSSpring;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping ("/") //www.naver.com/dfjdjflidf /뒤에 오는 url을 처리하기 위해 달아주는 annotation
    public String home(Model model) { //추가로 웹뷰를 제외한 다른 정보를 제공하고 싶을 때 model에  담아서 전송
        model.addAttribute("user", new User());
        return "home"; //최상단 주소에서 /가 오면 실행 (home이라는 문자열을 반환) -> spring 프레임워크가 받아서 templates 폴더의 home.html 문서를 찾아 사용자에게 보내줌
    }

    @GetMapping ("/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/")
    public String getUserData(User user) {
        System.out.println(user);
        return "redirect:/profile";
    }

}
