package by.karpov.delivery.service;

import by.karpov.delivery.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getById(Long id);

    User findByUsername(String name);

    List<User> findAll();

    User save(User user);

    User update(User user);

    void delete(Long id);

    UserDetails getUserDetails();

    User getUserFromSecurityContext();

}
