package by.karpov.delivery;

import by.karpov.delivery.entity.PersonalInfo;
import by.karpov.delivery.entity.User;
import by.karpov.delivery.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Sql(
        scripts = "/populate_DB_for_test.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void test1() {
    }

    @Test
    void test2() {
        User user = userRepository.getOne(1L);
        PersonalInfo personalInfo = user.getPersonalInfo();
        String string = personalInfo.toString();
        System.out.println(string);
    }
}

