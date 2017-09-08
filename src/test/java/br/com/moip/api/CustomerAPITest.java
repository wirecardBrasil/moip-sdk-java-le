package br.com.moip.api;

import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.Customer;
import br.com.moip.resource.FundingInstrument;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CustomerAPITest {

    @Rule
    public Player player = new Player();
    private CustomerAPI api;
    private CustomerRequest customerRequest;

    @Before
    public void setUp() {
        customerRequest = new CustomerRequest();
        api = new CustomerAPI(new ClientFactory().client(player.getURL("").toString()));
    }

    @Play("customer/create")
    @Test
    public void createCustomer() {
        Customer customer = api.create(customerRequest);

        assertEquals("CUS-Y6L4AGQN8HKQ", customer.getId());
        assertEquals("own_id", customer.getOwnId());
        assertEquals("Jose Silva", customer.getFullname());
        assertEquals("11", customer.getPhone().getAreaCode());
        assertEquals("66778899", customer.getPhone().getNumber());
        assertEquals("22222222222", customer.getTaxDocument().getNumber());
        assertEquals("Sao Paulo", customer.getShippingAddress().getCity());
        assertEquals("8", customer.getShippingAddress().getComplement());
        assertEquals("Itaim", customer.getShippingAddress().getDistrict());
        assertEquals("SP", customer.getShippingAddress().getState());
        assertEquals("01234000", customer.getShippingAddress().getZipCode());
        assertEquals("BRA", customer.getShippingAddress().getCountry());
    }

    @Play("customer/get")
    @Test
    public void getCustomer() {
        Customer customer = api.get("CUS-Y6L4AGQN8HKQ");

        assertEquals("CUS-Y6L4AGQN8HKQ", customer.getId());
        assertEquals("own_id", customer.getOwnId());
        assertEquals("Jose Silva", customer.getFullname());
        assertEquals("11", customer.getPhone().getAreaCode());
        assertEquals("66778899", customer.getPhone().getNumber());
        assertEquals("22222222222", customer.getTaxDocument().getNumber());
        assertEquals("Sao Paulo", customer.getShippingAddress().getCity());
        assertEquals("8", customer.getShippingAddress().getComplement());
        assertEquals("Itaim", customer.getShippingAddress().getDistrict());
        assertEquals("SP", customer.getShippingAddress().getState());
        assertEquals("01234000", customer.getShippingAddress().getZipCode());
        assertEquals("BRA", customer.getShippingAddress().getCountry());
    }

    @Play("customer/create_minimal_customer")
    @Test
    public void createMinimalCustomer() {
        Customer customer = api.create(customerRequest);

        assertEquals("CUS-YZA5DJ41GFXU", customer.getId());
        assertEquals("1486483588", customer.getOwnId());
        assertEquals("Jose Silva", customer.getFullname());
        assertNull(customer.getPhone());
        assertNull(customer.getTaxDocument());
        assertNull(customer.getShippingAddress());
    }

    @Play("customer/create_customer_with_funding_instrument")
    @Test
    public void createCustomerWithFundingInstrument() {
        Customer customer = api.create(customerRequest);

        assertEquals("CUS-O7FVGTW6DBJI", customer.getId());
        assertEquals("own_id", customer.getOwnId());
        assertEquals("Jose Silva", customer.getFullname());
        assertEquals("11", customer.getPhone().getAreaCode());
        assertEquals("66778899", customer.getPhone().getNumber());
        assertEquals("22222222222", customer.getTaxDocument().getNumber());
        assertEquals("Sao Paulo", customer.getShippingAddress().getCity());
        assertEquals("8", customer.getShippingAddress().getComplement());
        assertEquals("Itaim", customer.getShippingAddress().getDistrict());
        assertEquals("SP", customer.getShippingAddress().getState());
        assertEquals("01234000", customer.getShippingAddress().getZipCode());
        assertEquals("BRA", customer.getShippingAddress().getCountry());
        assertEquals("MASTERCARD", customer.getFundingInstrument().getCreditCard().getBrand());
        assertEquals("555566", customer.getFundingInstrument().getCreditCard().getFirst6());
        assertEquals("1111", customer.getFundingInstrument().getCreditCard().getLast4());
    }

    @Play("customer/add_credit_card")
    @Test
    public void testAddCreditCardToCustomer() {
        FundingInstrument creditCard = api.addCreditCard(
            new CustomerRequest()
                .fundingInstrument(
                    new FundingInstrumentRequest()
                        .creditCard(
                            new CreditCardRequest()
                                .number("4012001037141112")
                                .cvc(123)
                                .expirationMonth("05")
                                .expirationYear("18")
                                .holder(
                                    new HolderRequest()
                                        .fullname("Jose Portador da Silva")
                                        .birthdate("1988-10-10")
                                        .phone(
                                            new PhoneRequest()
                                                .setAreaCode("11")
                                                .setNumber("55667788")
                                        )
                                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                                )
                        )
                )
                .id("CUS-1RM8JPVKWEVR")
        );

        assertEquals(creditCard.getCreditCard().getId(), "CRC-NMNW6VIY2L0T");
        assertEquals(creditCard.getCreditCard().getFirst6(), "401200");
        assertEquals(creditCard.getCreditCard().getLast4(), "1112");
    }

}
