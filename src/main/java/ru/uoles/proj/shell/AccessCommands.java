package ru.uoles.proj.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.uoles.proj.model.Authorization;
import ru.uoles.proj.service.AuthorizationManageService;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 19:37
 */
@ShellComponent
@RequiredArgsConstructor
public class AccessCommands {

    private final AuthorizationManageService<Authorization> authorizationManageService;

    @ShellMethod(key = {"authorization"}, value = "Sign in persons")
    public String authorization(@ShellOption String login, @ShellOption String password) {
        Authorization authorization = new Authorization(login, password);
        return authorizationManageService.authorization(authorization);
    }

    @ShellMethod(key = {"registration"}, value = "Registration new persons")
    public String registration(@ShellOption String login, @ShellOption String password) {
        Authorization authorization = new Authorization(login, password);
        return authorizationManageService.registration(authorization);
    }
}
