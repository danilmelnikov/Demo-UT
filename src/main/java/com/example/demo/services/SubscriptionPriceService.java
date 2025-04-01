package com.example.demo.services;

import com.example.demo.model.SubscriptionModel;

public interface SubscriptionPriceService {
    double calculateNextPaymentAmount(SubscriptionModel subscriptionModel);
}
