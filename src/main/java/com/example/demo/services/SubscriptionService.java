package com.example.demo.services;

import com.example.demo.model.SubscriptionModel;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionModel> findUserSubscriptions(String userId);
}
