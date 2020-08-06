package by.karpov.delivery.controller;

import by.karpov.delivery.entity.*;
import by.karpov.delivery.service.DishService;
import by.karpov.delivery.service.OrderService;
import by.karpov.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;
    private final DishService dishService;
    private final OrderService orderService;

    @Autowired
    public HomeController(UserService userService, DishService dishService, OrderService orderService) {
        this.userService = userService;
        this.dishService = dishService;
        this.orderService = orderService;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser(){
        return userService.getUserFromSecurityContext();
    }

    @GetMapping
    public String homeView() {
        return "home";
    }



    @GetMapping("/dishes")
    public String getDishes(
            @RequestParam String category,
            Model model) {
        model.addAttribute("dishes", dishService.findAllByCategory(Category.valueOf(category.toUpperCase())));
        return "dishes";
    }

    @GetMapping("order")
    public String showOrder(Model model) {
        User user = userService.getUserFromSecurityContext();
        List<Dish> dishes = orderService.getByUser(user).getDishes();
        model.addAttribute("dishes", dishes);
        return "order";
    }
}
