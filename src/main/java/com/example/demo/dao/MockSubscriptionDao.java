package com.example.demo.dao;

import com.example.demo.model.SubscriptionModel;
import com.example.demo.model.SubscriptionStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MockSubscriptionDao implements SubscriptionDao {
    @Override
    public List<SubscriptionModel> findUserSubscriptions(String userId) {
        return List.of(createMockSubscription1(userId));
    }

    private SubscriptionModel createMockSubscription1(String userId) {
        SubscriptionModel subscription = new SubscriptionModel();
        subscription.setSubscriptionId("subscriptionId1");
        subscription.setUserId(userId);

        subscription.setStartDate(parseDate("2025-02-10T00:00:00"));
        subscription.setEndDate(parseDate("2027-06-10T00:00:00"));

        subscription.setPrice(14.99);

        subscription.setDiscount(5.0);
        subscription.setDiscountStartDate(parseDate("2025-02-10T00:00:00"));
        subscription.setDiscountEndDate(parseDate("2028-12-10T00:00:00"));

        subscription.setStatus(SubscriptionStatus.ACTIVE);

        return subscription;
    }

    private static LocalDateTime parseDate(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_DATE_TIME);
    }
}
