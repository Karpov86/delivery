package by.karpov.delivery;

import by.karpov.delivery.entity.Category;
import by.karpov.delivery.entity.Dish;
import by.karpov.delivery.service.DishService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Sql(scripts = "/populate_DB_for_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DishServiceTest {

    @Autowired
    private DishService dishService;

    @Test
    void findAllByCategory() {
        String pizza = "PIZZA";
        Category pizza1 = Category.valueOf("PIZZA");
        List<Dish> allByCategory = dishService.findAllByCategory(pizza1);
        System.out.println(allByCategory.size());
    }
}
