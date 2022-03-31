package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.service.PersonManageService;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 31.03.2022
 * Time: 7:28
 */
@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonManageService<Person> personManageService;

    @GetMapping("/person")
    public String getById(@RequestParam("id") long id, final Model model) {
        final Person person = personManageService.findById(id);
        model.addAttribute("person", person);
        return "person";
    }

}
