package ru.uoles.proj.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.service.PersonManageService;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 13:54
 */
@ShellComponent
@RequiredArgsConstructor
public class PersonCommands {

    private final PersonManageService<Person> personManageService;

    @ShellMethod(key = {"getPersonById"}, value = "Select person by id")
    public String getPersonById(@ShellOption String guid) {
        Person person = personManageService.findByGuid(guid);
        return person.toString();
    }

    @ShellMethod(key = {"addPerson"}, value = "Add new person")
    public String addPerson(@ShellOption String firstName, @ShellOption String secondName, @ShellOption String nickName,
                            @ShellOption String info, @ShellOption int age, @ShellOption String gender,
                            @ShellOption String town
    ) {
        return personManageService.addPerson(firstName, secondName, nickName, info, age, gender, town);
    }
}
