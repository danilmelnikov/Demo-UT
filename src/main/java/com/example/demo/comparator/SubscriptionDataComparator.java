package com.example.demo.comparator;

import com.example.demo.data.SubscriptionData;

import java.util.Comparator;

public class SubscriptionDataComparator implements Comparator<SubscriptionData> {
    @Override
    public int compare(SubscriptionData subscription1, SubscriptionData subscription2) {
        return Boolean.compare(subscription2.isActive(), subscription1.isActive());
    }
}
