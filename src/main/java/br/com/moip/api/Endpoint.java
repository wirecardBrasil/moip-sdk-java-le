package br.com.moip.api;

import br.com.moip.request.RefundRequest;

public class Endpoint {

    private static String REFUNDS_ORDER = "/v2/orders/%s/refunds";

    private static String REFUNDS_PAYMENT = "/v2/payments/%s/refunds";

    private static String REFUNDS_GET = "/v2/refunds/%s";

    public String buildRefundEndpointForOrder(RefundRequest refundRequest) {
        return String.format(REFUNDS_ORDER, refundRequest.getId());
    }

    public String buildRefundEndpointForPayment(RefundRequest refundRequest) {
        return String.format(REFUNDS_PAYMENT, refundRequest.getId());
    }

    public String buildRefundEndpointForGet(String refundId) {
        return String.format(REFUNDS_GET, refundId);
    }

    public String buildRefundEndpointForListByOrder(String id) {
        return String.format(REFUNDS_ORDER, id);
    }

    public String buildRefundEndpointForListByPayment(String id) {
        return String.format(REFUNDS_PAYMENT, id);
    }
}
