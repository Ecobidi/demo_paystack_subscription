package com.example.paystack_subscribtion.dtos;

import java.time.LocalDateTime;

public class CreateSubscriptionResponseDTO {

    private boolean status;
    private String message;
    private SubscriptionResponseData data;

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

    public SubscriptionResponseData getData() {
        return data;
    }

    public void setData(SubscriptionResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SubscriptionResponseDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class SubscriptionResponseData {
        private String authorization_url;
        private String access_code;
        private String reference;

        public String getAuthorization_url() {
            return authorization_url;
        }

        public void setAuthorization_url(String authorization_url) {
            this.authorization_url = authorization_url;
        }

        public String getAccess_code() {
            return access_code;
        }

        public void setAccess_code(String access_code) {
            this.access_code = access_code;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        @Override
        public String toString() {
            return "SubscriptionResponseData{" +
                    "authorization_url='" + authorization_url + '\'' +
                    ", access_code='" + access_code + '\'' +
                    ", reference='" + reference + '\'' +
                    '}';
        }
    }

}
