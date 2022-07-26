package com.example.paystack_subscribtion.dtos;

import java.time.LocalDateTime;

public class CreateSubscriptionPlanResponseDTO {
    private boolean status;
    private String message;
    private CreatedPlanData data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CreatedPlanData getData() {
        return data;
    }

    public void setData(CreatedPlanData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CreateSubscriptionPlanResponseDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class CreatedPlanData {
        private long id;
        private String plan_code;
        private int integration;
        private String name;
        private double amount;
        private LocalDateTime createdAt;
        private String interval;
        private String currency;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPlan_code() {
            return plan_code;
        }

        public void setPlan_code(String plan_code) {
            this.plan_code = plan_code;
        }

        public int getIntegration() {
            return integration;
        }

        public void setIntegration(int integration) {
            this.integration = integration;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
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

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", plan_code='" + plan_code + '\'' +
                    ", integration=" + integration +
                    ", name='" + name + '\'' +
                    ", amount=" + amount +
                    ", createdAt=" + createdAt +
                    ", interval='" + interval + '\'' +
                    ", currency='" + currency + '\'' +
                    '}';
        }
    }


}

