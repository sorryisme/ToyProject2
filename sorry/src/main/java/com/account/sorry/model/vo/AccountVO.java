package com.account.sorry.model.vo;

import com.account.sorry.model.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVO {

    private String title;
    private String payDate;
    private String price;
    private String consumerType;

    public AccountEntity toEntity(){
        return AccountEntity.builder()
                        .title(this.title)
                        .payDate(this.payDate)
                        .price(this.price)
                        .consumerType(this.consumerType)
                        .build();
    }
}
