package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
@AllArgsConstructor
@Table(name = "`Registration_User_Token`")
public class RegistrationUserToken implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", unique = true, nullable = false)
    private int id;

    @Column(name = "`token`", nullable = false, length = 36, unique = true)
    private String token;

    @OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Account account;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`expiryDate`", nullable = false)
    private Date expiryDate;

    public RegistrationUserToken() {
    }

    public RegistrationUserToken(String token, Account account) {
        this.token = token;
        this.account = account;

        // 1h
        expiryDate = new Date(System.currentTimeMillis() + 360000);
    }

}