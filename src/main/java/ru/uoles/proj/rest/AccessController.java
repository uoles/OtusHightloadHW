package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.uoles.proj.model.Authorization;
import ru.uoles.proj.service.AuthorizationManageService;

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

    @GetMapping("/login")
    public String authorization(final ModelMap model) {
        model.addAttribute("authorization", new Authorization());
        return "login";
    }

    @PostMapping(value = "/login")
    public ModelAndView authorization(@ModelAttribute Authorization authorization, final ModelMap model) {
        final String personGuid = authorizationManageService.authorization(authorization);

        ModelAndView modelAndView = null;
        if (Objects.nonNull(personGuid)) {
            model.addAttribute("guid", personGuid);
            modelAndView  = new ModelAndView("redirect:/person/view", model);
        } else {
            authorization.setError("Authorization error");
            model.addAttribute("authorization", authorization);
            modelAndView = new ModelAndView("login", model);
        }
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public String registration(@ModelAttribute Authorization authorization, final ModelMap model) {
        model.addAttribute("authorization", new Authorization());
        return "registration";
    }

    @PostMapping(value = "/registration/new")
    public ModelAndView registrationNewPerson(@ModelAttribute Authorization authorization, final ModelMap model) {
        final String personGuid = authorizationManageService.registration(authorization);

        ModelAndView modelAndView = null;
        if (Objects.nonNull(personGuid)) {
            model.addAttribute("guid", personGuid);
            modelAndView  = new ModelAndView("redirect:/person/new", model);
        } else {
            authorization.setError("Registration error");
            model.addAttribute("authorization", authorization);
            modelAndView = new ModelAndView("registration", model);
        }
        return modelAndView;
    }
}
