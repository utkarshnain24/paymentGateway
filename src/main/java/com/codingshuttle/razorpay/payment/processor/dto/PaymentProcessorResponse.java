package com.codingshuttle.razorpay.payment.processor.dto;

public sealed interface PaymentProcessorResponse permits
        PaymentProcessorResponse.Pending,
        PaymentProcessorResponse.Success,
        PaymentProcessorResponse.Failure {

    record Pending(String paymentReference) implements PaymentProcessorResponse {}

    record Success(String paymentReference, String bankReference) implements PaymentProcessorResponse {}

    record Failure(String errorCode, String errorDescription) implements PaymentProcessorResponse {}

}
