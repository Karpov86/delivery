package by.karpov.delivery.repository;

import by.karpov.delivery.entity.Category;
import by.karpov.delivery.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findAllByCategory(Category category);
}
