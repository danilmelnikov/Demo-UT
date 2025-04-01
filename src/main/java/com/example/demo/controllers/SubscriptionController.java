package com.example.demo.controllers;

import com.example.demo.data.SubscriptionData;
import com.example.demo.facades.SubscriptionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionFacade subscriptionFacade;

    @GetMapping("/users/{userId}/subscriptions")
    public List<SubscriptionData> index(@PathVariable String userId) {
        return subscriptionFacade.findUserSubscriptions(userId);
    }

}
