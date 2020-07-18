package by.karpov.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {


    @Column(name = "data")
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "order")
    private List<Dish> dishes;
}
