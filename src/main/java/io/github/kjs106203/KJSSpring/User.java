package io.github.kjs106203.KJSSpring;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data //롬복이 이 내용이 데이터 이므로 getter, setter를 적용시킴
@Entity //user라는 것은 db전용이라는 것을 알려줌
public class User {
    //Validation Annotation은 String 형식에만 사용이 가능하다.
    @Id //바로 아랫줄이 primary key라는 것을 알려줌
    @NotBlank(message = "ID는 필수 항목입니다.") //Validation Annotation
    @Size(min = 2, max = 10, message = "ID는 최소 2글자 최대 10글자 제한입니다.") //Validation Annotation
    private String id;
    @NotBlank(message = "이름은 필수 항목입니다.") //Validation Annotation
    private String name;
    private int age;
    private boolean sex;
    @Email(message = "이메일 형식이 올바르지 않습니다.") //Validation Annotation
    private String address;
}
