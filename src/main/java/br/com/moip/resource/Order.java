package br.com.moip.resource;

import br.com.moip.MoipException;
import br.com.moip.MoipHttp;
import br.com.moip.ValidationException;
import br.com.moip.resource.structure.Address;
import br.com.moip.resource.structure.Amount;
import br.com.moip.resource.structure.Entry;
import br.com.moip.resource.structure.Errors;
import br.com.moip.resource.structure.Event;
import br.com.moip.resource.structure.Item;
import br.com.moip.resource.structure.Receiver;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order extends MoipResource {
    private String id;
    private String ownId;
    private List<Item> items = new ArrayList<Item>();
    private String status;
    private String createdAt;
    private Amount amount = new Amount();
    private List<Address> addresses;
    private Customer customer;
    private List<Payment> payments;
    private List<Refund> refunds;
    private List<Entry> entries;
    private List<Event> events;
    private List<Receiver> receivers;
    private String updatedAt;
    private String ERROR;
    private List<Errors> errors;

    public Order addAddress(String type, String street, String number,
                            String district, String city, String state, String zip,
                            String complement, String country) {

        Address address = new Address();
        address.setType(type);
        address.setStreet(street);
        address.setStreetNumber(number);
        address.setDistrict(district);
        address.setCity(city);
        address.setState(state);
        address.setZipCode(zip);
        address.setComplement(complement);
        address.setCountry(country);

        addresses.add(address);

        return this;
    }

    public Order addItem(String product, Integer quantity, String detail,
                         Integer price) {
        Item item = new Item();

        item.setProduct(product);
        item.setQuantity(quantity);
        item.setDetail(detail);
        item.setPrice(price);

        items.add(item);

        return this;
    }

    public Order addReceiver(String moipAccount, Integer amount) {
        return addReceiver(moipAccount, amount, "SECONDARY");
    }

    public Order addReceiver(String moipAccount, Integer amount, String type) {
        Receiver receiver = new Receiver();

        receiver.getMoipAccount().setId(moipAccount);

        receiver.setType(type);
        receiver.getAmount().setFixed(amount);

        if (receivers == null) {
            receivers = new ArrayList<Receiver>();
        }

        receivers.add(receiver);

        return this;
    }

    public Order create() {
        Gson gson = new Gson();

        MoipHttp moipHttp = moip.getMoipHttp();
        String json = moipHttp.sendRequest("/v2/orders", "POST",
                gson.toJson(this));

        Order order = gson.fromJson(json, Order.class);
        order.setMoip(moip);

        if (order.hasUnexpectedError()) {
            throw new MoipException();
        }

        if (order.hasValidationError()) {
            throw new ValidationException(order.getErrors());
        }

        return order;
    }

    public Order get(String id) {
        Gson gson = new Gson();

        MoipHttp moipHttp = moip.getMoipHttp();
        String json = moipHttp.sendRequest("/v2/orders/" + id, "GET");

        Order order = gson.fromJson(json, Order.class);
        order.setMoip(moip);

        return order;
    }

    public String getId() {
        return id;
    }

    public String getOwnId() {
        return ownId;
    }

    public Order setOwnId(String ownId) {
        this.ownId = ownId;

        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;

        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Order setCreatedAt(String createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public Amount getAmount() {
        return amount;
    }

    public Order setAmount(Amount amount) {
        this.amount = amount;

        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;

        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Order setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public Integer getShippingAmount() {
        return this.amount.getSubtotals().getShipping();
    }

    public Order setShippingAmount(Integer amount) {
        this.amount.getSubtotals().setShipping(amount);

        return this;
    }

    public Iterator<Entry> getEntryIterator() {
        if (entries == null) {
            entries = new ArrayList<Entry>();
        }

        return entries.iterator();
    }

    public Iterator<Refund> getRefundIterator() {
        if (refunds == null) {
            refunds = new ArrayList<Refund>();
        }

        return refunds.iterator();
    }

    public Iterator<Event> getEventIterator() {
        if (events == null) {
            events = new ArrayList<Event>();
        }

        return events.iterator();
    }

    public Iterator<Payment> getPaymentIterator() {
        if (payments == null) {
            payments = new ArrayList<Payment>();
        }

        Iterator<Payment> i = payments.iterator();

        while (i.hasNext()) {
            i.next().setOrder(this);
        }

        return payments.iterator();
    }

    public Payment payments() {
        Payment payment = new Payment();
        payment.setMoip(moip);
        payment.setOrder(this);

        return payment;
    }

    public Refund refund() {
        Refund refund = new Refund();
        refund.setMoip(moip);
        refund.setOrder(this);

        return refund;
    }

    public String getERROR() {
        return ERROR;
    }

    public void setERROR(String ERROR) {
        this.ERROR = ERROR;
    }

    public boolean hasUnexpectedError() {
        return getERROR() != null;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

    public boolean hasValidationError() {
        return getErrors() != null;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Receiver> getReceivers() {
        return receivers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", ownId='" + ownId + '\'' +
                ", items=" + items +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", amount=" + amount +
                ", addresses=" + addresses +
                ", customer=" + customer +
                ", payments=" + payments +
                ", refunds=" + refunds +
                ", entries=" + entries +
                ", events=" + events +
                ", receivers=" + receivers +
                ", updatedAt='" + updatedAt + '\'' +
                ", ERROR='" + ERROR + '\'' +
                ", errors=" + errors +
                '}';
    }
}
