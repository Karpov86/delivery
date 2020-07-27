package by.karpov.delivery.controller;

import by.karpov.delivery.entity.Order;
import by.karpov.delivery.entity.Role;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.OrderService;
import by.karpov.delivery.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserServiceImpl userService;
    private final OrderService orderService;

    @Autowired
    public RegistrationController(UserServiceImpl userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        User user = User.builder()
                .username(username)
                .password(password)
                .active(true)
                .roles(Collections.singleton(Role.USER))
                .build();
        userService.save(user);
        Order order = Order.builder()
                .dishes(new ArrayList<>())
                .user(user)
                .build();
        orderService.save(order);
        return "redirect:/login";
    }

}
