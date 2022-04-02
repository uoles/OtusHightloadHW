package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
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
public class AuthorizationController {

    private final AuthorizationManageService<Authorization> authorizationManageService;

    @GetMapping("/authorization")
    public String authorization(final ModelMap model) {
        model.addAttribute("authorization", new Authorization());
        return "authorization";
    }

    @PostMapping(value = "/authorization")
    public ModelAndView signin(@ModelAttribute Authorization authorization, final ModelMap model) {
        final Long personId = authorizationManageService.authorization(authorization);

        ModelAndView modelAndView = null;
        if (Objects.nonNull(personId)) {
            model.addAttribute("id", personId);
            modelAndView  = new ModelAndView("redirect:/person", model);
        } else {
            authorization.setError("Authorization error");
            model.addAttribute("authorization", authorization);
            modelAndView = new ModelAndView("authorization", model);
        }
        return modelAndView;
    }
}
