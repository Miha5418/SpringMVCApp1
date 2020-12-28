package ru.karpeykin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author karpeykin
 * @Date 28.12.2020
 */
@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String hellopage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname){

        System.out.println("Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByPage(){
        return "first/goodbye";
    }
}
