package by.karpov.delivery.service.impl;

import by.karpov.delivery.entity.Dish;
import by.karpov.delivery.entity.Order;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.OrderService;
import by.karpov.delivery.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Sql(
        scripts = "/populate_DB_for_test.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
class OrderServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @Test
    void getById() {
    }

    @Test
    void save() {
        Order order = Order.builder()
                .dateTime(LocalDateTime.now())
                .dishes(new ArrayList<>())
                .build();
        orderService.save(order);
        Long id = order.getId();
        assertNotNull(id);
        System.out.println(id);
    }

    @Test
    void delete() {
    }

    @Test
    void getByUser() {
        User user = userService.getById(1L);
        Order order = orderService.getByUser(user);
        System.out.println(order.getDateTime());
        List<Dish> dishes = order.getDishes();
        dishes.stream().map(d -> d.getTitle() + " " + d.getCategory()).forEach(System.out::println);
    }

}