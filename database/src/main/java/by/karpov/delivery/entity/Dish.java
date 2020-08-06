package by.karpov.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "dishes")
@Proxy
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

    @ManyToMany(mappedBy = "dishes", fetch = FetchType.EAGER)
    private List<Order> order;

}
