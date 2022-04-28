package ru.uoles.proj.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.uoles.proj.configs.CustomWebAuthenticationDetails;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.model.PersonSearch;
import ru.uoles.proj.service.PersonFriendsService;
import ru.uoles.proj.service.PersonManageService;
import ru.uoles.proj.types.PersonOperationType;

import java.util.ArrayList;
import java.util.List;

import static ru.uoles.proj.utils.SecureHelper.getAuthPersonGUID;

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
    private final PersonFriendsService<Person> personFriendsService;

    @GetMapping("/person/main")
    public String mainPerson(final Model model) {
        Person person = personManageService.findByGuid(getAuthPersonGUID());
        List<Person> persons = personManageService.findFriendPersons(getAuthPersonGUID());
        model.addAttribute("person", person);
        model.addAttribute("persons", persons);
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
        List<Person> persons = personManageService.findNotFriendPersons(getAuthPersonGUID());
        model.addAttribute("persons", persons);
        model.addAttribute("personSearch", new PersonSearch("", ""));
        return "persons";
    }

    @GetMapping("/person/friend/add")
    public String addFriend(@RequestParam("guid") String friendGuid) {
        personFriendsService.addFriend(getAuthPersonGUID(), friendGuid);
        return "redirect:/person/list";
    }

    @GetMapping("/person/friend/delete")
    public String deleteFriend(@RequestParam("guid") String friendGuid) {
        personFriendsService.deleteFriend(getAuthPersonGUID(), friendGuid);
        return "redirect:/person/main";
    }

    @PostMapping("/person/search")
    public String searchPerson(@ModelAttribute PersonSearch personSearch, final Model model) {
        List<Person> result = personManageService.findPersons(personSearch);
        model.addAttribute("persons", result);
        model.addAttribute("personSearch", personSearch);
        return "persons";
    }
}
