package com.bankingapplicationmain.bankingapplicationmain.models;

import com.bankingapplicationmain.bankingapplicationmain.models.enums.Type;

import javax.persistence.*;

@Entity
public class Account {

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
>>>>>>> cc5377a462eeac9a8c89d8db2b6f8c18a11263ec
    private Long id;

    private Type type;
    private String nickname;
    private Integer rewards;
    private Double balance;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
<<<<<<< HEAD
    private int customer_id;

    public Account(Long id, Type type, String nickname, Integer rewards, Double balance, int customer_id) {

=======
    private Customer customer;

    public Account(Long id, Type type, String nickname, Integer rewards, Double balance, Customer customer) {
>>>>>>> cc5377a462eeac9a8c89d8db2b6f8c18a11263ec
        this.id = id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
<<<<<<< HEAD
        this.customer_id = customer_id;

=======
        this.customer = customer;
>>>>>>> cc5377a462eeac9a8c89d8db2b6f8c18a11263ec
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id: " + id + ", \n" +
                "type: " + type + ", \n" +
                "nickname: " + nickname + ", \n" +
                "rewards: " + rewards + ", \n" +
                "balance: " + balance + ", \n" +
               "customer_id: " + customer_id +
                "\n}";
    }

}
