package com.account.sorry.model.entity;

import com.account.sorry.model.vo.AccountVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ACCOUNT")
public class AccountEntity extends AuditingEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String price;
    private String payDate;
    private String consumerType;
    private String description;

    @Builder
    public AccountEntity(String title, String price, String payDate,String consumerType){
        this.title = title;
        this.price = price;
        this.payDate = payDate;
        this.consumerType = consumerType;
    }

    public AccountVO toAccountVO(){
        return AccountVO.builder()
                        .title(title)
                        .price(price)
                        .payDate(payDate)
                        .consumerType(consumerType).build();
    }
}
