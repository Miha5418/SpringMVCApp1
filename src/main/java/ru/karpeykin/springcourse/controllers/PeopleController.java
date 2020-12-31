package ru.karpeykin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.karpeykin.springcourse.dao.PersonDAO;

/**
 * @author karpeykin
 * @Date 31.12.2020
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        // Получим всех людей из DAO и передадим в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model){
        //Получим одного ччеловека по его ID

        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
