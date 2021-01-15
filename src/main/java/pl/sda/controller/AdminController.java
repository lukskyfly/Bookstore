package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.service.UserService;

@Controller
@Slf4j
public class AdminController {

    private final UserService userService;

    public AdminController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("delete-user/{userId}")
    public String deleteUser(@PathVariable Integer id) {

        userService.delete(id);

        log.info("Left " + " user");

        return "redirect:/admin-page";
    }
}
