package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Role;
import pl.sda.model.User;
import pl.sda.service.AutoLoginService;
import pl.sda.service.UserService;
import pl.sda.service.impl.RoleService;

import java.util.Arrays;

@Controller
@Slf4j
public class RegistrationController {
    private final RoleService roleService;
    private final UserService userService;
    private final AutoLoginService autoLoginService;

    public RegistrationController(final RoleService roleService, final UserService userService, final AutoLoginService autoLoginService) {
        this.roleService = roleService;
        this.userService = userService;
        this.autoLoginService = autoLoginService;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            log.info("USER EXISTS!" + user.getUsername());
            return "registration";
        }
        Role role = roleService.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userService.save(user);
        log.info("Registered user: " + user.getUsername());
        autoLoginService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/book-list";
    }
}