package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 10.04.2022
 * Time: 13:16
 */
@Controller
@RequiredArgsConstructor
public class MainPageController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}
