package com.codingshuttle.razorpay.merchant.service;

import com.codingshuttle.razorpay.merchant.dto.request.ApiKeyCreateRequest;
import com.codingshuttle.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, @Valid ApiKeyCreateRequest request);
}
