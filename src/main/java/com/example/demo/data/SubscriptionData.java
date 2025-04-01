package com.example.demo.data;

public class SubscriptionData {
    private String subscriptionId;
    private String userId;
    private boolean isActive;
    private double nextPaymentAmount;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getNextPaymentAmount() {
        return nextPaymentAmount;
    }

    public void setNextPaymentAmount(double nextPaymentAmount) {
        this.nextPaymentAmount = nextPaymentAmount;
    }
}
