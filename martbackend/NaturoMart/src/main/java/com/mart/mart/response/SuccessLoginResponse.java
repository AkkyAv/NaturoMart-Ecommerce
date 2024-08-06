package com.mart.mart.response;

import com.mart.mart.model.Buyer;
import com.mart.mart.model.Role;
import com.mart.mart.model.Supplier;
import com.mart.mart.model.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessLoginResponse {
    private String token;
    private String email;
    private Role role;
    private UserDetails userDetails;
    private LocalDate joinedDate;
    private Buyer buyer;
    private Supplier supplier;
    private boolean isActive;
}