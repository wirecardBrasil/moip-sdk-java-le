package br.com.moip.request;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

    private String ownId;
    private final List<ItemRequest> items = new ArrayList<ItemRequest>();
    private CustomerRequest customer;
    private final List<ReceiverRequest> receivers = new ArrayList<ReceiverRequest>();
    @SerializedName("checkoutPreferences") private CheckoutPreferencesRequest checkoutPreferences;

    public String getOwnId() {
        return ownId;
    }

    public OrderRequest ownId(final String ownId) {
        this.ownId = ownId;

        return this;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public OrderRequest addItem(final String product, final Integer quantity, final String detail, final Integer price) {
        items.add(new ItemRequest(product, quantity, detail, price));

        return this;
    }

    public List<ReceiverRequest> getReceivers() {
        return receivers;
    }

    public OrderRequest addReceiver(final ReceiverRequest receiverRequest) {
        receivers.add(receiverRequest);

        return this;
    }

    public CustomerRequest getCustomer() {
        return customer;
    }

    public OrderRequest customer(final CustomerRequest customer) {
        this.customer = customer;

        return this;
    }

    public CheckoutPreferencesRequest getCheckoutPreferences() {
        return checkoutPreferences;
    }

    public OrderRequest checkoutPreferences(String urlSuccess, String urlFailure) {
        this.checkoutPreferences = new CheckoutPreferencesRequest(urlSuccess, urlFailure);
        
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder("OrderRequest{")
                .append("ownId='").append(ownId).append('\'')
                .append(", items=").append(items)
                .append(", customer=").append(customer)
                .append(", checkoutPreferences=").append(checkoutPreferences)
                .append('}').toString();
    }

    public static final class ItemRequest {
        private final String product;
        private final Integer quantity;
        private final String detail;
        private final Integer price;

        public ItemRequest(String product, Integer quantity, String detail, Integer price) {
            this.product = product;
            this.quantity = quantity;
            this.detail = detail;
            this.price = price;
        }

        public String getProduct() {
            return product;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public String getDetail() {
            return detail;
        }

        public Integer getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return new StringBuilder("Item{")
                    .append("product='").append(product).append('\'')
                    .append(", quantity=").append(quantity)
                    .append(", detail='").append(detail).append('\'')
                    .append(", price=").append(price)
                    .append('}').toString();
        }
    }
    
    public static final class CheckoutPreferencesRequest {
        @SerializedName("redirectUrls") private RedirectUrlsRequest redirectUrls;

        public CheckoutPreferencesRequest(String urlSuccess, String urlFailure) {
            this.redirectUrls = new RedirectUrlsRequest(urlSuccess, urlFailure);
        }

        public RedirectUrlsRequest getRedirectUrls() {
            return redirectUrls;
        }

        public void setRedirectUrls(RedirectUrlsRequest redirectUrls) {
            this.redirectUrls = redirectUrls;
        }

        @Override
        public String toString() {
            return new StringBuilder("CheckoutPreferencesRequest{")
                    .append("redirectUrls=").append(redirectUrls).append('}').toString();
        }
    }
    
    public static final class RedirectUrlsRequest {
        @SerializedName("urlSuccess") private String urlSuccess;
        @SerializedName("urlFailure") private String urlFailure;

        public RedirectUrlsRequest(String urlSuccess, String urlFailure) {
            this.urlSuccess = urlSuccess;
            this.urlFailure = urlFailure;
        }

        public String getUrlSuccess() {
            return urlSuccess;
        }

        public void setUrlSuccess(String urlSuccess) {
            this.urlSuccess = urlSuccess;
        }

        public String getUrlFailure() {
            return urlFailure;
        }

        public void setUrlFailure(String urlFailure) {
            this.urlFailure = urlFailure;
        }

        @Override
        public String toString() {
            return new StringBuilder("RedirectUrlsRequest{")
                    .append("urlSuccess='").append(urlSuccess).append('\'')
                    .append(", urlFailure='").append(urlFailure).append('\'')
                    .append('}').toString();
        }
    }
}
