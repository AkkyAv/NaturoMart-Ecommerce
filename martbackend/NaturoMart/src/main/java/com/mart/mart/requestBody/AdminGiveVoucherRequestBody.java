package com.mart.mart.requestBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminGiveVoucherRequestBody {
    private String voucherName;
    private int quantity;
}
