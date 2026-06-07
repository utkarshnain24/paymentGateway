package com.codingshuttle.razorpay.vault.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "card_token")
public class CardToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vault_card_id", nullable = false)
    private VaultCard vaultCard;

    @Column(nullable = false)
    private UUID customerId;

    @Column(nullable = false)
    private UUID merchantId;

}
