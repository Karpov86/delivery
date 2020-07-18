package by.karpov.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "dishes")
public class Dish extends BaseEntity {

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sale")
    private Boolean isSale = false;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
