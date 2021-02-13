package io.github.kjs106203.KJSSpring;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data //롬복이 이 내용이 데이터 이므로 getter, setter를 적용시킴
@Entity //user라는 것은 db전용이라는 것을 알려줌
public class User {
    @Id //바로 아랫줄이 primary key라는 것을 알려줌
    private String id;
    private String name;
    private int age;
    private boolean sex;
    private String address;
}
