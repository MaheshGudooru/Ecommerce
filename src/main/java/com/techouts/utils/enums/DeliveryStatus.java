package com.techouts.utils.enums;

public enum DeliveryStatus {


    // 1. Initial Placement
    PENDING,
    CONFIRMED,
    ON_HOLD,

    // 2. Processing
    PROCESSING,
    PACKED,

    // 3. Shipping
    SHIPPED,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,

    // 4. Resolution
    DELIVERED,
    COMPLETED,
    CANCELLED,
    REFUNDED,

    // 5. Exceptions
    FAILED,
    RETURNED

}
