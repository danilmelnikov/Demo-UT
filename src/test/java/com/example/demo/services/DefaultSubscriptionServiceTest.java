package com.example.demo.services;

import com.example.demo.dao.SubscriptionDao;
import com.example.demo.model.SubscriptionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class DefaultSubscriptionServiceTest {
    private static final String USER_ID = "userId";

    private DefaultSubscriptionService testInstance;

    @Mock
    private SubscriptionDao subscriptionDao;

    @BeforeEach
    void setUp() {
        testInstance = new DefaultSubscriptionService(subscriptionDao);
    }

    @Test
    void shouldReturnDaoResult() {
        //Given
        List<SubscriptionModel> subscriptions = List.of(new SubscriptionModel());
        when(subscriptionDao.findUserSubscriptions(USER_ID)).thenReturn(subscriptions);

        //When
        List<SubscriptionModel> result = testInstance.findUserSubscriptions(USER_ID);

        //Then
        assertThat(result).isEqualTo(subscriptions);
    }
}