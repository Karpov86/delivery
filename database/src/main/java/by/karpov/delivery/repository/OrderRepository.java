package by.karpov.delivery.repository;

import by.karpov.delivery.entity.Order;
import by.karpov.delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser(User user);
}
