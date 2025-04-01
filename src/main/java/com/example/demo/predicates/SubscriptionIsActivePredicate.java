package com.example.demo.predicates;

import com.example.demo.model.SubscriptionModel;
import com.example.demo.model.SubscriptionStatus;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class SubscriptionIsActivePredicate implements Predicate<SubscriptionModel> {
    @Override
    public boolean test(SubscriptionModel subscriptionModel) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return SubscriptionStatus.ACTIVE.equals(subscriptionModel.getStatus()) &&
                subscriptionModel.getStartDate().isBefore(currentDateTime) &&
                subscriptionModel.getEndDate().isAfter(currentDateTime);
    }
}
