package ru.karpeykin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message","Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByPage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("one") int a,
                             @RequestParam("two") int b,
                             @RequestParam("action") String action,
                             Model model){

        model.addAttribute("result", "Result: " + count(a, b, action));
        return "first/calculator";
    }

    private static double count(int a, int b, String action){
        double res;
        switch (action){
            case "multiplication":
                res = a * b;
                break;
            case "addition":
                res = a + b;
                break;
            case "subtraction":
                res = a - b;
                break;
            case "division":
                res = a / (double)b;
                break;
            default: res = 666;
            break;
        }
        return res;
    }
}
