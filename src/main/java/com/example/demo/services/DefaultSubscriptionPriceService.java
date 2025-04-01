package com.example.demo.services;

import com.example.demo.model.SubscriptionModel;

import java.time.LocalDateTime;

public class DefaultSubscriptionPriceService implements SubscriptionPriceService {
    @Override
    public double calculateNextPaymentAmount(SubscriptionModel subscriptionModel) {
        if (shouldDiscountBeApplied(subscriptionModel)) {
            return subscriptionModel.getPrice() - subscriptionModel.getDiscount();
        }

        return subscriptionModel.getPrice();
    }

    private boolean shouldDiscountBeApplied(SubscriptionModel subscriptionModel) {
        if (subscriptionModel.getDiscount() == null) {
            return false;
        }

        if (subscriptionModel.getDiscount() < 0) {
            throw new IllegalStateException("Discount cannot be negative, but it was for subscription: " + subscriptionModel.getSubscriptionId());
        }

        if (subscriptionModel.getDiscount() > subscriptionModel.getPrice()) {
            throw new IllegalStateException("Discount cannot be higher than the price, but it was for subscription: " + subscriptionModel.getSubscriptionId());
        }

        if (isDiscountExpired(subscriptionModel)) {
            return false;
        }

        return true;
    }

    private boolean isDiscountExpired(SubscriptionModel subscriptionModel) {
        return !isDiscountActive(subscriptionModel);
    }

    private boolean isDiscountActive(SubscriptionModel subscriptionModel) {
        LocalDateTime nextPaymentDate = calculateNextPaymentDate(subscriptionModel);
        return (subscriptionModel.getDiscountStartDate() == null || subscriptionModel.getDiscountStartDate().isBefore(nextPaymentDate))
                && (subscriptionModel.getDiscountEndDate() == null || subscriptionModel.getDiscountEndDate().isAfter(nextPaymentDate));
    }

    private LocalDateTime calculateNextPaymentDate(SubscriptionModel subscriptionModel) {
        return subscriptionModel.getEndDate().minusDays(14);
    }
}
