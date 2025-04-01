package com.example.demo.facades;

import com.example.demo.data.SubscriptionData;

import java.util.List;

public interface SubscriptionFacade {
    List<SubscriptionData> findUserSubscriptions(String userId);
}
