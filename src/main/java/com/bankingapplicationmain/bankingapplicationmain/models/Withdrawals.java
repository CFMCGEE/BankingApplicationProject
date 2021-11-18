package com.bankingapplicationmain.bankingapplicationmain.models;

import com.bankingapplicationmain.bankingapplicationmain.models.moreenums.Medium;
import com.bankingapplicationmain.bankingapplicationmain.models.moreenums.Status;
import com.bankingapplicationmain.bankingapplicationmain.models.moreenums.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Withdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type type;
    private String transaction_date;
    private Status status;
    private Long payer_id;
    private Medium medium;
    private Double amount;
    private String description;

    public Withdrawals(Long id, Type type, String transaction_date, Status status, Long payer_id, Medium medium, Double amount, String description) {

        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payer_id = payer_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;

    }

    public Withdrawals() {

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

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Long payer_id) {
        this.payer_id = payer_id;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
