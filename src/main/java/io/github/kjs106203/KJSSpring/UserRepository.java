package io.github.kjs106203.KJSSpring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByName(String name);
    List<User> findByage(int age);
}
