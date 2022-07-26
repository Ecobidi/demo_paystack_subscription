package com.example.paystack_subscribtion.dtos;

import java.util.Arrays;

public class PaystackCustomerResponseDTO {
    private boolean status;
    private String message;
    private PaystackCustomerData data;

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

    public PaystackCustomerData getData() {
        return data;
    }

    public void setData(PaystackCustomerData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PaystackCustomerRequestDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class PaystackCustomerData {
        private long id;
        private String email;
        private String customer_code;
        private PaystackAuthorization[] authorizations;

        // other fields

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCustomer_code() {
            return customer_code;
        }

        public void setCustomer_code(String customer_code) {
            this.customer_code = customer_code;
        }

        public PaystackAuthorization[] getAuthorizations() {
            return authorizations;
        }

        public void setAuthorizations(PaystackAuthorization[] authorizations) {
            this.authorizations = authorizations;
        }

        @Override
        public String toString() {
            return "PaystackCustomerData{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", customer_code='" + customer_code + '\'' +
                    ", authorizations=" + Arrays.toString(authorizations) +
                    '}';
        }
    }

    public static class PaystackAuthorization {
        private String authorization_code;
        // other fields

        public String getAuthorization_code() {
            return authorization_code;
        }

        public void setAuthorization_code(String authorization_code) {
            this.authorization_code = authorization_code;
        }

        @Override
        public String toString() {
            return "PaystackAuthorization{" +
                    "authorization_code='" + authorization_code + '\'' +
                    '}';
        }
    }
}

