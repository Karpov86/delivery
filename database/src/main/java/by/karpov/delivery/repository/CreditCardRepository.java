package by.karpov.delivery.repository;

import by.karpov.delivery.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
