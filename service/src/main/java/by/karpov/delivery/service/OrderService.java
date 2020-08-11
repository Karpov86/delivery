package by.karpov.delivery.service;

import by.karpov.delivery.entity.Order;
import by.karpov.delivery.entity.User;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order getById(Long id);

    Order save(Order order);

    void delete(Long id);

    Order getByUser(User user);

    BigDecimal getTotalPrice(Order order);

    List<Order> getAllByUser(User user);

    Order getLast(User user);

}
