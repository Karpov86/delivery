package by.karpov.delivery.controller;

import by.karpov.delivery.entity.CreditCard;
import by.karpov.delivery.entity.PersonalInfo;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user";
    }

    @GetMapping("profile")
    public String profile(Model model) {
        User user = userService.getUserFromSecurityContext();
        model.addAttribute("user", user);
        return "header";
    }

    @GetMapping("{id}")
    public String viewProfile(@PathVariable Long id, Model model) {
        User user = userService.getById(id);
        User currentUser = userService.getUserFromSecurityContext();
        if (user == null){
            return "redirect:/home";
        }
        if (!user.equals(currentUser)) {
            return "redirect:/user/" + currentUser.getId();
        }
        PersonalInfo personalInfo = user.getPersonalInfo();
        if (personalInfo == null) {
            personalInfo = new PersonalInfo();
        }
        Set<CreditCard> creditCards = personalInfo.getCreditCards();
        if (creditCards == null){
            creditCards = Collections.emptySet();
        }
        model.addAttribute("user", user);
        model.addAttribute("info", personalInfo);
        model.addAttribute("credit", creditCards);
        return "profile";
    }

    @PostMapping("/updateUser")
    public String updateProfile(
            @RequestParam String username
    ) {
        User user = userService.getUserFromSecurityContext();
        user.setUsername(username);
        userService.save(user);
        return "redirect:/user/" + user.getId();
    }
}
