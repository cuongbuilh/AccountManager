package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccontDto {
    private short id;
    private String email;
    private String username;
    private String fullname;
    private String department;
    private String position;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String status;
}
