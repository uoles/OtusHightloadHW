package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.uoles.proj.model.News;
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

    private final NewsService<News> newsService;

    @GetMapping("/news/list")
    public String getAll(final Model model) {
        List<News> news = newsService.getNews(getAuthPersonGUID(), 100);
        model.addAttribute("news", news);
        return "news";
    }
}
