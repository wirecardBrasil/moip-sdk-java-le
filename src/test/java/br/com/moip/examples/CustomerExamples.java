package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import br.com.moip.request.RequestTest;
import br.com.moip.request.CustomerRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.AddressRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.resource.Customer;
import br.com.moip.resource.FundingInstrument;

import java.util.Date;

public class CustomerExamples extends RequestTest {

    /**
     * The Customer is a service's user or a buyer of a virtual store.
     *
     * Read more about customers on:
     * https://dev.moip.com.br/v2/reference#clientes-ec
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * If you want to persist and save your customer data, that's the way to create it.
     * TIP: Don't forget to set the customer ownId, here we using a logic to
     * automate the tests.
     */
    public void createCustomer() {

        Customer customer = api.customer().create(new CustomerRequest()
            .ownId("CUS-" + System.currentTimeMillis())
            .fullname("Jose da Silva")
            .email("josedasilva@email.com")
            .birthdate(new ApiDateRequest().date(new Date()))
            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
            .phone(new PhoneRequest().setAreaCode("11").setNumber("55443322"))
            .shippingAddressRequest(new AddressRequest()
                .street("Avenida Faria Lima")
                .streetNumber("3064")
                .complement("12 andar")
                .city("São Paulo")
                .state("SP")
                .district("Itaim")
                .country("BRA")
                .zipCode("01452-000")
            )
        );
    }

    // To save the credit card data of a customer, making easy your next purchase.
    public void addCreditCard() {

        FundingInstrument creditCard = api.customer().addCreditCard(new CustomerRequest()
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .number("5555666677778884")
                    .cvc(123)
                    .expirationMonth("05")
                    .expirationYear("18")
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("55667788")
                        )
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
                )
            )
            .id("CUS-5P13683GQKXS")     // The customer's Moip ID
        );
    }

    // Another way is create the customer and add your credit card in the same request.
    public void createCustomerWithCreditCard() {

        Customer customer = api.customer().create(new CustomerRequest()
            .ownId("CUS-" + System.currentTimeMillis())
            .fullname("Jose da Silva")
            .email("josedasilva@email.com")
            .birthdate(new ApiDateRequest().date(new Date()))
            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
            .phone(new PhoneRequest().setAreaCode("11").setNumber("55443322"))
            .shippingAddressRequest(new AddressRequest().street("Avenida Faria Lima")
                .streetNumber("3064")
                .complement("12 andar")
                .city("São Paulo")
                .state("SP")
                .district("Itaim")
                .country("BRA")
                .zipCode("01452-000")
            )
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .expirationMonth("05")
                    .expirationYear("22")
                    .number("4012001037141112")
                    .cvc(123)
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("55667788")
                        )
                        .taxDocument(TaxDocumentRequest.cpf("22222222222")
                        )
                    )
                )
            )
        );
    }

    // This method allows you to delete a credit card from customer's funding instruments.
    public void deleteCreditCard() {

        api.customer().deleteCreditCard("CRC-P4QWBIO6YR59");  // Credit card ID
    }

    // This method allows you to get a customer by your Moip ID.
    public void getCustomer() {

        Customer customer = api.customer().get("CUS-5P13683GQKXS");
    }
}
