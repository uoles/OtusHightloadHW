package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.uoles.proj.model.Authorization;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.service.AuthorizationManageService;
import ru.uoles.proj.service.PersonManageService;

import java.util.Objects;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 01.04.2022
 * Time: 21:22
 */
@Controller
@RequiredArgsConstructor
public class AccessController {

    private final AuthorizationManageService<Authorization> authorizationManageService;
    private final PersonManageService<Person> personManageService;

    @GetMapping("/login")
    public String authorization(final ModelMap model) {
        return "redirect:/login";
    }

    @GetMapping(value = "/registration")
    public String registration(@ModelAttribute Authorization authorization, final ModelMap model) {
        model.addAttribute("authorization", new Authorization());
        model.addAttribute("person", new Person());
        return "registration";
    }

    @PostMapping(value = "/registration/new")
    public ModelAndView registrationNewPerson(
            @ModelAttribute Authorization authorization,
            @ModelAttribute Person person,
            final ModelMap model
    ) {
        final String personGuid = authorizationManageService.registration(authorization);

        ModelAndView modelAndView = null;
        if (Objects.nonNull(personGuid)) {
            person.setGuid(personGuid);
            personManageService.updatePerson(person);

            modelAndView  = new ModelAndView("registration_success");
        } else {
            authorization.setError("Registration error");
            model.addAttribute("authorization", authorization);
            modelAndView = new ModelAndView("registration", model);
        }
        return modelAndView;
    }
}
