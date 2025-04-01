package com.example.demo.dao;

import com.example.demo.model.SubscriptionModel;

import java.util.List;

public interface SubscriptionDao {
    List<SubscriptionModel> findUserSubscriptions(String userId);
}
