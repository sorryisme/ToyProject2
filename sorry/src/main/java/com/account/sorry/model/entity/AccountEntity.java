package com.account.sorry.model.entity;

import com.account.sorry.model.AccountType;
import com.account.sorry.model.vo.AccountVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ACCOUNT")
public class AccountEntity extends AuditingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long price;
    private LocalDateTime payDate;

    @Enumerated(EnumType.STRING)
    private AccountType consumerType;

    private String description;

    @Builder
    public AccountEntity(Long id, String title, Long price, LocalDateTime payDate, AccountType consumerType){
        this.id = id;
        this.title = title;
        this.price = price;
        this.payDate = payDate;
        this.consumerType = consumerType;
    }

    public AccountVO toAccountVO(){
        return AccountVO.builder()
                        .id(this.id)
                        .title(this.title)
                        .price(this.price)
                        .payDate(this.payDate)
                        .consumerType(this.consumerType)
                        .build();
    }
}
