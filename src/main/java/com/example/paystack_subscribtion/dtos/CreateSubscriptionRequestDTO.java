package com.example.paystack_subscribtion.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateSubscriptionRequestDTO {

    private String customer;
    // replaces customer field on subscribeOnTransactionInitialization()
    private String email;
    @NotBlank
    private String plan;

    private String start_date;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "CreateSubscriptionRequestDTO{" +
                "customer='" + customer + '\'' +
                ", email='" + email + '\'' +
                ", plan='" + plan + '\'' +
                ", start_date='" + start_date + '\'' +
                '}';
    }
}
