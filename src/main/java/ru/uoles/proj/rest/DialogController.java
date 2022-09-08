package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.uoles.proj.model.Dialog;
import ru.uoles.proj.model.Message;
import ru.uoles.proj.service.DialogService;

import java.util.List;

import static ru.uoles.proj.utils.DatabaseHelper.getNewMessageTemplate;
import static ru.uoles.proj.utils.SecureHelper.getAuthPersonGUID;

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

    private final DialogService<Dialog> dialogService;

    @GetMapping("/dialog/list")
    public String getAll(final Model model) {
        List<Dialog> dialogs = dialogService.getAllDialogs(getAuthPersonGUID(), 100);
        model.addAttribute("dialogs", dialogs);
        return "dialogs";
    }

    @GetMapping("/dialog/open")
    public String getDialog(@RequestParam("guid") String recipientGuid, final Model model) {
        Dialog dialog = dialogService.getDialog(getAuthPersonGUID(), recipientGuid);

        model.addAttribute("dialog", dialog);
        model.addAttribute("message", getNewMessageTemplate(dialog));
        return "dialog";
    }

    @GetMapping("/dialog/create")
    public String createDialog(@RequestParam("guid") String recipientGuid, final Model model) {
        Dialog dialog = dialogService.addDialog(getAuthPersonGUID(), recipientGuid);

        model.addAttribute("dialog", dialog);
        model.addAttribute("message", getNewMessageTemplate(dialog));
        return "dialog";
    }

    @PostMapping("/dialog/add/message")
    public String addMessage(@ModelAttribute Message message) {
        dialogService.addMessage(message);
        return String.join("", "redirect:/dialog/open?guid=", message.getRecipientGuid());
    }
}
