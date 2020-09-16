package com.account.sorry.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountVO {

    private String consumerType;
    private String payDate;
    private String price;
    private String title;
}
