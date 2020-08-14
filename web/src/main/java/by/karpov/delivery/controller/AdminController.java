package by.karpov.delivery.controller;

import by.karpov.delivery.entity.Category;
import by.karpov.delivery.entity.Dish;
import by.karpov.delivery.entity.Order;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.DishService;
import by.karpov.delivery.service.OrderService;
import by.karpov.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize(value = "hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;
    private final DishService dishService;
    private final OrderService orderService;

    @Autowired
    public AdminController(UserService userService, DishService dishService, OrderService orderService) {
        this.userService = userService;
        this.dishService = dishService;
        this.orderService = orderService;
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        return userService.getUserFromSecurityContext();
    }

    @ModelAttribute("currentOrder")
    public Order getCurrentOrder() {
        return orderService.getLastByUser(getCurrentUser());
    }

    @ModelAttribute("newDish")
    public Dish newDish(){
        return new Dish();
    }

    @GetMapping("/users")
    public String userList(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @GetMapping("/dishes")
    public String dishListView(Model model){
        List<Dish> dishList = dishService.findAll();
        model.addAttribute("dishList", dishList);
        return "dishList";
    }

    @GetMapping("/dish/edit/{dishId}")
    public String dishEditView(@PathVariable Long dishId, Model model){
        Dish currentDish = dishService.getById(dishId);
        model.addAttribute("currentDish", currentDish);
        return "dishEdit";
    }

    @GetMapping("dish/add")
    public String dishAddView(){
        return "dishAdd";
    }

    @PostMapping("/dish/add")
    public String dishAdd(@RequestParam Category category, Dish newDish){
        newDish.setCategory(category);
        dishService.save(newDish);
        return "redirect:/admin/dishes";
    }

    @PostMapping("/dish/edit")
    public String dishEdit(
            @RequestParam Long dishId,
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam BigDecimal price,
            @RequestParam String description
            ){
        Dish dish = dishService.getById(dishId);
        dish.setTitle(title);
        dish.setCategory(Category.valueOf(category));
        dish.setPrice(price);
        dish.setDescription(description);
        dishService.save(dish);
        return "redirect:/admin/dishes";
    }

    @PostMapping("/dish/delete")
    public String dishDelete(@RequestParam Long dishId){
        dishService.delete(dishId);
        return "redirect:/admin/dishes";
    }
}
