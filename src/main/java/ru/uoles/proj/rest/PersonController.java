package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.uoles.proj.configs.CustomWebAuthenticationDetails;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.service.PersonFriendsService;
import ru.uoles.proj.service.PersonManageService;
import ru.uoles.proj.types.PersonOperationType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    private final PersonFriendsService<Person> personMaFriendsService;

    @GetMapping("/person/main")
    public String mainPerson(final Model model) {
        Person person = personManageService.findByGuid(getAuthPersonGUID());
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/person/view")
    public String viewPerson(@RequestParam("guid") String guid, final Model model) {
        Person person = personManageService.findByGuid(guid);
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/person/new")
    public String addPerson(@RequestParam("guid") String guid, final Model model) {
        Person person = new Person();
        person.setGuid(guid);
        person.setOperation(PersonOperationType.SAVE.getCanonicalName());
        model.addAttribute("person", person);
        return "person";
    }

    @PostMapping("/person/update")
    public String addPerson(@ModelAttribute Person person, final Model model) {
        Person result = personManageService.updatePerson(person);
        model.addAttribute("person", result);
        return "person";
    }

    @GetMapping("/person/list")
    public String getAll(final Model model) {
        List<Person> authors = personManageService.findNotFriendPersons(getAuthPersonGUID());
        model.addAttribute("persons", authors);
        return "persons";
    }

    @GetMapping("/person/friend/add")
    public String addFriend(@RequestParam("guid") String friendGuid) {
        personMaFriendsService.addFriend(getAuthPersonGUID(), friendGuid);
        return "redirect:/person/list";
    }

    private String getAuthPersonGUID() {
        CustomWebAuthenticationDetails details =
                (CustomWebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return details.getPersonGuid();
    }
}
