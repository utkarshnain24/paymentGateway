package com.codingshuttle.razorpay.merchant.controller;

import com.codingshuttle.razorpay.merchant.dto.request.ApiKeyCreateRequest;
import com.codingshuttle.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.codingshuttle.razorpay.merchant.repository.ApiKeyRepository;
import com.codingshuttle.razorpay.merchant.service.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/merchant/{merchantId}/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyCreateResponse> create(@PathVariable UUID merchantId, @Valid ApiKeyCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(apiKeyService.create(merchantId, request));
    }

}
