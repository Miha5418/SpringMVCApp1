package ru.karpeykin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author karpeykin
 * @Date 28.12.2020
 */
@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exit(){
        return "second/exit";
    }
}
