package com.fendy.exercise.client;

import lombok.Data;

@Data
public class PaymentGatewayClient {

    // imagine this class as third party or external library
    // that hard to control using bean
    private String endpoint;
    private String privateKey;
    private String publicKey;

}
