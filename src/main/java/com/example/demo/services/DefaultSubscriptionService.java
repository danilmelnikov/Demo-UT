package com.example.demo.services;

import com.example.demo.dao.SubscriptionDao;
import com.example.demo.model.SubscriptionModel;

import java.util.List;

public class DefaultSubscriptionService implements SubscriptionService {
    private SubscriptionDao subscriptionDao;

    public DefaultSubscriptionService(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    @Override
    public List<SubscriptionModel> findUserSubscriptions(String userId) {
        return subscriptionDao.findUserSubscriptions(userId);
    }
}
