package com.codingshuttle.razorpay.payment.entity;

import com.codingshuttle.razorpay.common.entity.Money;
import com.codingshuttle.razorpay.common.enums.RefundStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private RefundStatus status;

    @Column(length = 100)
    private String bankReference;

    @Column(length = 100)
    private String errorCode;

    @Column(length = 255)
    private String errorDescription;

    private LocalDateTime processedAt;
}
