package by.karpov.delivery.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BaseEntity {

    @Column(name = "number")
    private String cardNumber;

    @Column(name = "date")
    private String cardDate;

    @Column(name = "cvv")
    private String cardCvv;

    @ManyToOne
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    public String getCardInfo() {
        return cardNumber + " " + cardDate;
    }

}

