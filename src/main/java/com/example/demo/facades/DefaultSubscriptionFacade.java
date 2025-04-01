package com.example.demo.facades;

import com.example.demo.data.SubscriptionData;
import com.example.demo.model.SubscriptionModel;
import com.example.demo.services.SubscriptionService;
import org.springframework.core.convert.converter.Converter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSubscriptionFacade implements SubscriptionFacade {
    private SubscriptionService subscriptionService;
    private Converter<SubscriptionModel, SubscriptionData> subscriptionDataConverter;
    private Comparator<SubscriptionData> subscriptionDataComparator;

    public DefaultSubscriptionFacade(SubscriptionService subscriptionService,
                                     Converter<SubscriptionModel, SubscriptionData> subscriptionDataConverter,
                                     Comparator<SubscriptionData> subscriptionDataComparator) {
        this.subscriptionService = subscriptionService;
        this.subscriptionDataConverter = subscriptionDataConverter;
        this.subscriptionDataComparator = subscriptionDataComparator;
    }

    @Override
    public List<SubscriptionData> findUserSubscriptions(String userId) {
        return subscriptionService.findUserSubscriptions(userId).stream()
                .map(subscriptionDataConverter::convert)
                .sorted(subscriptionDataComparator)
                .collect(Collectors.toList());
    }
}
