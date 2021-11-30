package com.bankingapplicationmain.bankingapplicationmain.models;

import com.bankingapplicationmain.bankingapplicationmain.models.enums.Medium;
import com.bankingapplicationmain.bankingapplicationmain.models.enums.Status;
import com.bankingapplicationmain.bankingapplicationmain.models.enums.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Withdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Medium medium;
    
    private String transaction_date;
    private Double amount;
    private String description;
    private Status status;
    private Long payer_id;
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    public Withdrawals(Long id, Medium medium, String transaction_date, Double amount, String description, Status status, Long payer_id, Type type) {

        this.id = id;
        this.medium = medium;
        this.transaction_date = transaction_date;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.payer_id = payer_id;
        this.type = type;

    }

    public Withdrawals() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
