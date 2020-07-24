package by.karpov.delivery.service.impl;

import by.karpov.delivery.entity.Order;
import by.karpov.delivery.repository.OrderRepository;
import by.karpov.delivery.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
