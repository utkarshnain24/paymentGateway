package com.codingshuttle.razorpay.payment.processor.dto;

import com.codingshuttle.razorpay.common.entity.Money;
import com.codingshuttle.razorpay.common.enums.PaymentMethod;

import java.util.Map;
import java.util.Objects;

public record PaymentProcessorRequest(
        PaymentMethod method,
        Money amount,
        Map<String, Objects> methodDetails
) {
}
