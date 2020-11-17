package com.account.sorry.model.vo;

import com.account.sorry.model.AccountType;
import com.account.sorry.model.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVO {

    private Long id;
    private String title;
    private LocalDateTime payDate;
    private Long price;
    private AccountType consumerType;

    public AccountEntity toEntity(){
        return AccountEntity.builder()
                        .id(this.id)
                        .title(this.title)
                        .payDate(this.payDate)
                        .price(this.price)
                        .consumerType(this.consumerType)
                        .build();
    }
}
