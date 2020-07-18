package by.karpov.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BaseEntity {

    @Column(name = "number")
    private String cardNumber;

    @Column(name = "data")
    private String cardData;

    @Column(name = "vcc")
    private String cardVcc;

    @ManyToOne
    @JoinColumn(name = "personalInfo_id")
    private PersonalInfo personalInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(cardData, that.cardData) &&
                Objects.equals(cardVcc, that.cardVcc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardData, cardVcc);
    }
}
