package com.example.paystack_subscribtion.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CreateSubscriptionPlanRequestDTO {
    @NotBlank
    private String name;
    @Min(value = 0)
    private int amount;
    @NotBlank
    private String interval;
    private String currency;
    private int invoice_limit;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getInvoice_limit() {
        return invoice_limit;
    }

    public void setInvoice_limit(int invoice_limit) {
        this.invoice_limit = invoice_limit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CreatePlanRequestDTO{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", interval=" + interval +
                ", currency=" + currency +
                ", invoice_limit=" + invoice_limit +
                ", description='" + description + '\'' +
                '}';
    }
}
