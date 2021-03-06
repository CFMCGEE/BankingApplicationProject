package com.bankingapplicationmain.bankingapplicationmain.models;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@RequiredArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String first_Name;
    private String last_Name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Set<Address> getAddress() {
        return addresses;
    }

    public void setAddress(Set<Address> address) {
        this.addresses = address;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
    }
}
