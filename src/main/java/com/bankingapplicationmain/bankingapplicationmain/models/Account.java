package com.bankingapplicationmain.bankingapplicationmain.models;

import com.bankingapplicationmain.bankingapplicationmain.models.enums.Type;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    private Type type;
    private String nickname;
    private Integer rewards;
    private Integer balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Withdrawals> withdrawals;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Bill> bills;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Deposits> deposits;
  
    public Account(Long id, Type type, String nickname, Integer rewards, Integer balance, Customer customer, Set<Withdrawals> withdrawals, Set<Bill> bills, Set<Deposits> deposits) {
     
        this.id = id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.customer = customer;
        this.withdrawals = withdrawals;
        this.bills = bills;
        this.deposits = deposits;

    }

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Withdrawals> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(Set<Withdrawals> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<Deposits> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposits> deposits) {
        this.deposits = deposits;
    }

}
