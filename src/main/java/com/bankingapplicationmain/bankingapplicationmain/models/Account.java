package com.bankingapplicationmain.bankingapplicationmain.models;

import com.bankingapplicationmain.bankingapplicationmain.models.enums.Type;

import javax.persistence.*;

@Entity
public class Account {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Long id;

    private Type type;
    private String nickname;
    private Integer rewards;
    private Double balance;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(Long id, Type type, String nickname, Integer rewards, Double balance, Customer customer) {
        this.id = id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.customer = customer;
    }

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long accountID) {
        this.id = accountID;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id: " + id + ", \n" +
                "type: " + type + ", \n" +
                "nickname: " + nickname + ", \n" +
                "rewards: " + rewards + ", \n" +
                "balance: " + balance +
                "\n}";
    }

}
