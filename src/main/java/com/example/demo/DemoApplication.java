package com.example.demo;

import com.example.demo.comparator.SubscriptionDataComparator;
import com.example.demo.converter.SubscriptionDataConverter;
import com.example.demo.dao.MockSubscriptionDao;
import com.example.demo.dao.SubscriptionDao;
import com.example.demo.data.SubscriptionData;
import com.example.demo.facades.DefaultSubscriptionFacade;
import com.example.demo.model.SubscriptionModel;
import com.example.demo.predicates.SubscriptionIsActivePredicate;
import com.example.demo.services.DefaultSubscriptionPriceService;
import com.example.demo.services.DefaultSubscriptionService;
import com.example.demo.services.SubscriptionPriceService;
import com.example.demo.services.SubscriptionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.util.Comparator;
import java.util.function.Predicate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public MockSubscriptionDao subscriptionDao() {
        return new MockSubscriptionDao();
    }

    @Bean
    public DefaultSubscriptionService subscriptionService(SubscriptionDao subscriptionDao) {
        return new DefaultSubscriptionService(subscriptionDao);
    }

    @Bean
    public SubscriptionIsActivePredicate subscriptionIsActivePredicate(SubscriptionDao subscriptionDao) {
        return new SubscriptionIsActivePredicate();
    }

    @Bean
    public DefaultSubscriptionPriceService subscriptionPriceService(SubscriptionDao subscriptionDao) {
        return new DefaultSubscriptionPriceService();
    }

    @Bean
    public SubscriptionDataConverter subscriptionDataConverter(Predicate<SubscriptionModel> subscriptionIsActivePredicate,
                                                         SubscriptionPriceService subscriptionPriceService) {
        return new SubscriptionDataConverter(subscriptionIsActivePredicate, subscriptionPriceService);
    }

	@Bean
	public SubscriptionDataComparator subscriptionDataComparator() {
		return new SubscriptionDataComparator();
	}

    @Bean
    public DefaultSubscriptionFacade subscriptionFacade(SubscriptionService subscriptionService,
                                                        Converter<SubscriptionModel, SubscriptionData> subscriptionDataConverter,
                                                        Comparator<SubscriptionData> subscriptionDataComparator) {
        return new DefaultSubscriptionFacade(subscriptionService, subscriptionDataConverter, subscriptionDataComparator);
    }
}
