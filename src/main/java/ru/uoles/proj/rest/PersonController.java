package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.service.PersonManageService;
import ru.uoles.proj.types.PersonOperationType;

import java.util.Objects;

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
    public String findPerson(@RequestParam("guid") String guid, final Model model) {
        Person person = personManageService.findByGuid(guid);
        if (Objects.isNull(person)) {
            person = new Person();
            person.setGuid(guid);
            person.setOperation(PersonOperationType.SAVE.getCanonicalName());
        }
        model.addAttribute("person", person);

        return "person";
    }

    @PostMapping("/person")
    public String addPerson(@ModelAttribute Person person, final Model model) {
        Person result = personManageService.updatePerson(person);
        model.addAttribute("person", result);
        return "person";
    }
}
