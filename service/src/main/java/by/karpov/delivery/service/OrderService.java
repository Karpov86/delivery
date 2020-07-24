package by.karpov.delivery.service;

import by.karpov.delivery.entity.Order;

public interface OrderService {
    Order getById(Long id);
    Order save(Order order);
    void delete(Long id);
}
