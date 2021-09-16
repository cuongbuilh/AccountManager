package com.vti.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountFormForCreatingRegister {
    private String email;
    private String username;
    private String fullname;
    private String password;
}

