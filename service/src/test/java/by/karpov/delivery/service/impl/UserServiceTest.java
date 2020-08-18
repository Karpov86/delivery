package by.karpov.delivery.service.impl;

import by.karpov.delivery.BaseTest;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceTest extends BaseTest {

    public static final Long BOB_ID = 1L;
    @Autowired
    UserService userService;

    @Test
    void getById() {
        User user = userService.getById(BOB_ID);
        Assert.assertNotNull(user);
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
        User byId = userService.getById(1L);
        byId.setUsername("Boby");
        userService.update(byId);
        System.out.println(userService.getById(1L).getUsername());
    }

    @Test
    void delete() {
        userService.delete(BOB_ID);
    }
}