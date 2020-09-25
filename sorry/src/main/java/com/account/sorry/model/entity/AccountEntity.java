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
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String price;
    private String payDate;
    private String consumerType;
    private String description;

    public AccountVO toAccountVO(){
        return AccountVO.builder()
                        .title(title)
                        .price(price)
                        .payDate(payDate)
                        .consumerType(consumerType).build();
    }
}
