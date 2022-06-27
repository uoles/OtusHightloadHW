package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.model.PersonSearch;
import ru.uoles.proj.service.NewsService;

import java.util.List;

import static ru.uoles.proj.utils.SecureHelper.getAuthPersonGUID;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 27.06.2022
 * Time: 11:50
 */
@Controller
@RequiredArgsConstructor
public class NewsController {

    private NewsService newsService;

    @GetMapping("/news/list")
    public String getAll(final Model model) {
        List<Person> persons = newsService.getNews(getAuthPersonGUID(), 100);
        model.addAttribute("persons", persons);
        model.addAttribute("personSearch", new PersonSearch("", ""));
        return "persons";
    }
}
