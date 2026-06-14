package com.codingshuttle.razorpay.merchant.service.impl;

import com.codingshuttle.razorpay.common.exceptions.ResourceNotFoundException;
import com.codingshuttle.razorpay.merchant.dto.request.ApiKeyCreateRequest;
import com.codingshuttle.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.codingshuttle.razorpay.merchant.entity.ApiKey;
import com.codingshuttle.razorpay.merchant.entity.Merchant;
import com.codingshuttle.razorpay.merchant.repository.ApiKeyRepository;
import com.codingshuttle.razorpay.merchant.repository.MerchantRepository;
import com.codingshuttle.razorpay.merchant.service.ApiKeyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;

    @Override
    @Transactional
    public ApiKeyCreateResponse create(UUID merchantId, ApiKeyCreateRequest request) {

        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(
                () -> new ResourceNotFoundException("merchant", merchantId)
        );

        String keyId = "rzp_" + request.environment().toString().toUpperCase() + "_big_random_string";
        String rawSecret = "big_random_secret"; // TODO: replace with cryptographic random hex

        ApiKey apiKey = ApiKey.builder()
                .keyId(keyId)
                .keySecretHash(rawSecret) // TODO: encrypt using Bcrypt
                .merchant(merchant)
                .environment(request.environment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);

        return new ApiKeyCreateResponse(
                apiKey.getId(),
                keyId,
                rawSecret,
                request.environment()
        );
    }
}
