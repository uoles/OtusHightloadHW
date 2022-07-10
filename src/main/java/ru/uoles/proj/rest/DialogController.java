package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.uoles.proj.model.Dialog;

import java.util.ArrayList;
import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 10.07.2022
 * Time: 0:07
 */
@Controller
@RequiredArgsConstructor
public class DialogController {

    @GetMapping("/dialog/list")
    public String getAll(final Model model) {
        List<Dialog> dialogs = new ArrayList<>();
        model.addAttribute("dialogs", dialogs);
        return "dialogs";
    }

    @GetMapping("/dialog/open")
    public String getDialog(@RequestParam("guid") String friendGuid) {
        List<Dialog> dialogs = new ArrayList<>();
        return "dialogs";
    }

    @GetMapping("/dialog/create")
    public String careteDialog(@RequestParam("guid") String friendGuid) {
        List<Dialog> dialogs = new ArrayList<>();
        return "dialog";
    }
}
