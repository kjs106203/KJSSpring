package io.github.kjs106203.KJSSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Annotation 자바 코드 실행에 영향을 주지 않지만 spring이 시작되는 지점이라고 알려줌
public class KJSSpringApplication {
    public static void main (String[] args) {
        SpringApplication.run(KJSSpringApplication.class, args);
    }
}
