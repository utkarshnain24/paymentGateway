package com.codingshuttle.razorpay.merchant.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
public class MerchantWebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false)
    private String targetUrl;

    @Column(name = "event_type_filter")
    private String eventTypeFilter;

    @Column(nullable = false)
    private boolean enabled;

    @Column(name = "webhook_secret")
    private String webhookSecret;

}
