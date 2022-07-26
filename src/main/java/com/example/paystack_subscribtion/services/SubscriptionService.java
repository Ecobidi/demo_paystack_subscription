package com.example.paystack_subscribtion.services;

import com.example.paystack_subscribtion.dtos.*;

public interface SubscriptionService {

    /**
     * Create a plan
     * Create a subscription
     * Create a subscription on initialize transaction
     * Listen for subscription events
     */

    CreateSubscriptionPlanResponseDTO createPlan(CreateSubscriptionPlanRequestDTO dto);

    CreateSubscriptionResponseDTO createSubscription(CreateSubscriptionRequestDTO dto);

    CreateSubscriptionResponseDTO createSubscriptionOnTransactionInitialization(CreateSubscriptionOnInitializationRequestDTO dto);



}
