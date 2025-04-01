package com.example.demo.converter;

import com.example.demo.data.SubscriptionData;
import com.example.demo.model.SubscriptionModel;
import com.example.demo.services.SubscriptionPriceService;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Predicate;

public class SubscriptionDataConverter implements Converter<SubscriptionModel, SubscriptionData> {
    private Predicate<SubscriptionModel> isActivePredicate;
    private SubscriptionPriceService subscriptionPriceService;

    public SubscriptionDataConverter(Predicate<SubscriptionModel> isActivePredicate,
                                     SubscriptionPriceService subscriptionPriceService) {
        this.isActivePredicate = isActivePredicate;
        this.subscriptionPriceService = subscriptionPriceService;
    }

    @Override
    public SubscriptionData convert(SubscriptionModel source) {
        SubscriptionData subscriptionData = new SubscriptionData();
        subscriptionData.setSubscriptionId(source.getSubscriptionId());
        subscriptionData.setUserId(source.getUserId());
        subscriptionData.setActive(isActivePredicate.test(source));
        subscriptionData.setNextPaymentAmount(subscriptionPriceService.calculateNextPaymentAmount(source));

        return subscriptionData;
    }
}
