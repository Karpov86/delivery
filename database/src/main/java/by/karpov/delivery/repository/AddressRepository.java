package by.karpov.delivery.repository;

import by.karpov.delivery.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {
}
