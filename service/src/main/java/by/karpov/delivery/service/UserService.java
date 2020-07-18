package by.karpov.delivery.service;

import by.karpov.delivery.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    User getUserById(Long id);
    List<User> findAllUser();
    User save(User user);
    User update(User user);
    void delete(Long id);
}
