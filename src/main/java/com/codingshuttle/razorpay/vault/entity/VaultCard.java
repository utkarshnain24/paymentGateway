package com.codingshuttle.razorpay.vault.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "vault_card")
public class VaultCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "BYTEA", nullable = false)
    private byte[] encryptedPan;

    @Column(columnDefinition = "BYTEA", nullable = false)
    private byte[] encryptedDek;

    @Column(nullable = false, length = 4)
    private String lastFour;

    @Column(length = 20)
    private String brand;

    @Column(length = 6)
    private String bin;

    @Column(nullable = false, length = 2)
    private Integer expiryMonth;

    @Column(nullable = false, length = 4)
    private Integer expiryYear;
}
