package ru.karpeykin.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author karpeykin
 * @Date 28.12.2020
 */
@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String sayHello(){
        return "hello_world";
    }
}
