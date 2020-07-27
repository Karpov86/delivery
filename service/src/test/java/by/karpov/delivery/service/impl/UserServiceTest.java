package by.karpov.delivery.service.impl;

import by.karpov.delivery.BaseTest;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

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
    }

    @Test
    void delete() {
        userService.delete(BOB_ID);
    }
}