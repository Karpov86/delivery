package by.karpov.delivery;

import by.karpov.delivery.entity.PersonalInfo;
import by.karpov.delivery.entity.Role;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.repository.UserRepository;
import by.karpov.delivery.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

@SpringBootTest
@Transactional
@Sql(
        scripts = "/populate_DB_for_test.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class UserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    void test2() {
        User user = userRepository.getOne(1L);
        PersonalInfo personalInfo = user.getPersonalInfo();
        String string = personalInfo.toString();
        System.out.println(string);
    }

    @Test
    void saveUserTest() {

        User user = new User();
        user.setUsername("Bill");
        user.setPassword("123");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        User bill = userService.findByUsername("Bill");
        System.out.println(bill.getUsername() + " " + bill.getPassword() + " " + bill.getRoles().toString());
    }

    @Test
    void findByUsername() {
        User bob = userService.findByUsername("Bob");
        Set<Role> roles = bob.getRoles();
        roles.forEach(System.out::println);
    }
}

