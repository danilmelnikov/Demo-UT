package com.example.demo.comparator;

import com.example.demo.data.SubscriptionData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SubscriptionDataComparatorTest {
    private SubscriptionDataComparator testInstance = new SubscriptionDataComparator();

    @Test
    void shouldReturnNegativeWhenFirstSubscriptionIsActiveAndSecondIsNot() {
        //Given
        SubscriptionData subscription1 = createTestSubscription(true);
        SubscriptionData subscription2 = createTestSubscription(false);

        //When
        int result = testInstance.compare(subscription1, subscription2);

        //Then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void shouldReturnPositiveWhenFirstSubscriptionIsNotActiveAndSecondIs() {
        //Given
        SubscriptionData subscription1 = createTestSubscription(false);
        SubscriptionData subscription2 = createTestSubscription(true);

        //When
        int result = testInstance.compare(subscription1, subscription2);

        //Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldReturnZeroWhenBothSubscriptionsAreNotActive() {
        //Given
        SubscriptionData subscription1 = createTestSubscription(false);
        SubscriptionData subscription2 = createTestSubscription(false);

        //When
        int result = testInstance.compare(subscription1, subscription2);

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturnZeroWhenBothSubscriptionsAreActive() {
        //Given
        SubscriptionData subscription1 = createTestSubscription(true);
        SubscriptionData subscription2 = createTestSubscription(true);

        //When
        int result = testInstance.compare(subscription1, subscription2);

        //Then
        assertThat(result).isEqualTo(0);
    }

    private static SubscriptionData createTestSubscription(boolean isActive) {
        SubscriptionData subscription1 = new SubscriptionData();
        subscription1.setActive(isActive);
        return subscription1;
    }
}