package ru.karpeykin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author karpeykin
 * @Date 28.12.2020
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String hellopage(){
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByPage(){
        return "first/goodbye";
    }
}
