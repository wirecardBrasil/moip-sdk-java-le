package br.com.moip.examples;

import br.com.moip.request.PaymentRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.BoletoRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.InstructionLinesRequest;
import br.com.moip.request.OnlineBankDebitRequest;
import br.com.moip.resource.Multipayment;
import br.com.moip.resource.Payment;
import br.com.moip.resource.Escrow;
import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MultipaymentExamples {

    /**
     * The multipayment is a collection of payments associated with a multiorder.
     * It's used in the implementation of the shopping cart/multiorder,
     * when it is necessary charge for different sellers with only one checkout.
     * When a multipayment is created Moip creates a payment for each order
     * of a multiorder and does the auto-charge.
     *
     * IMPORTANT: In cases of multipayment with credit card,
     * multiple authorizations are generated, one for each payment,
     * dividing the charges of a customer, to facilitate the management
     * of the Marketplace or Platform.
     *
     * Read more about multipayments on:
     * https://dev.moip.com.br/v2/reference#multipagamentos-1
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * To create an multipayment with credit card hash it's necessary to encrypt the credit card data.
     * TIP: To encrypt the credit card date you can use our solution (http://moip.github.io/moip-sdk-js/).
     *      Read more on https://github.com/moip/moip-sdk-js.
     */
    public void createMultipaymentWithCreditCardHash() {

        String hash = "HhL0kbhfid+jwgj5l6Kt9EPdetDxQN8s7uKUHDYxDC/XoULjzik44rSda3EcWuOcL17Eb8JjWc1JI7gsuwg9P0rJv1mJQx+d3Dv1puQYz1iRjEWWhnB1bw0gTvnnC/05KbWN5M8oTiugmhVK02Rt2gpbcTtpS7VWyacfgesBJFavYYMljYg8p2YGHXkXrMuQiOCeemKLk420d0OTMBba27jDVVJ663HZDrObnjFXJH/4B5irkj+HO5genV+V4PYoLcOESG4nrI3oFAsMGsLLcdJo0NNvkEmJpn0e9GzureKKFYisYU+BEd9EMr/odS0VMvOYRV65HbPTspIkjl2+3Q==";

        Multipayment multipayment = api.multipayment().create(new PaymentRequest()
            .orderId("MOR-BUPA74EUD3KM")
            .installmentCount(1)
            .delayCapture(false)
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .hash(hash)
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .taxDocument(TaxDocumentRequest.cpf("33333333333"))
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("66778899")
                        )
                    )
                )
            )
        );
    }

    /*
     * This method allows you to create an multipayment with boleto.
     * TIP: We already run with the new registered boleto's rules. Check the bellow link for more information.
     * https://dev.moip.com.br/v2.0/docs/boleto#section-boletos-registrados
     */
    public void createMultipaymentWithBoleto() {

        Multipayment multipayment = api.multipayment().create(new PaymentRequest()
            .orderId("MOR-R5FB3ZCS8T5X")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .boleto(new BoletoRequest()
                    .expirationDate(new ApiDateRequest()
                        .date(new GregorianCalendar(2020, Calendar.SEPTEMBER, 30).getTime())
                    )
                    .instructionLines(new InstructionLinesRequest()
                        .first("Primeira linha se instrução")
                        .second("Segunda linha se instrução")
                        .third("Terceira linha se instrução")
                    )
                    .logoUri("http://")
                )
            )
        );
    }

    // This method allows you to create an payment with online bank debit.
    public void createMultipaymentWithOnlineBankDebit() {

        Multipayment multipayment = api.multipayment().create(new PaymentRequest()
            .orderId("MOR-IG5UUJVUOWWI")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .onlineBankDebit(new OnlineBankDebitRequest()
                    .bankNumber("341")
                    .expirationDate(new ApiDateRequest().date(new Date("2020/11/22")))
                )
            )
        );
    }


    /*
     * This method allows you to create an multipayment with escrow.
     * Read more about escrow on https://dev.moip.com.br/v2.0/docs/cust%C3%B3dia.
     * TIP: The escrow can be release only for payments created with OAuth authentication.
     */
    public void createMultipaymentWithEscrow() {

        String hash = "HhL0kbhfid+jwgj5l6Kt9EPdetDxQN8s7uKUHDYxDC/XoULjzik44rSda3EcWuOcL17Eb8JjWc1JI7gsuwg9P0rJv1mJQx+d3Dv1puQYz1iRjEWWhnB1bw0gTvnnC/05KbWN5M8oTiugmhVK02Rt2gpbcTtpS7VWyacfgesBJFavYYMljYg8p2YGHXkXrMuQiOCeemKLk420d0OTMBba27jDVVJ663HZDrObnjFXJH/4B5irkj+HO5genV+V4PYoLcOESG4nrI3oFAsMGsLLcdJo0NNvkEmJpn0e9GzureKKFYisYU+BEd9EMr/odS0VMvOYRV65HbPTspIkjl2+3Q==";

        Multipayment payment = api.multipayment().create(new PaymentRequest()
            .orderId("MOR-83HM4D4UQP3R")
            .installmentCount(1)
            .escrow(new PaymentRequest.EscrowRequest("Custódia de pagamento"))
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .hash(hash)
                    .holder(new HolderRequest()
                        .fullname("Jose da Silva")
                        .birthdate("1988-12-30")
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("66778899")
                        )
                        .taxDocument(TaxDocumentRequest.cpf("33333333333"))
                    )
                )
            )
        );
    }

    // This method allows you to release an payment with escrow by escrow's Moip ID.
    public void releaseEscrow() {

        Escrow escrow = api.escrow().release("ECW-9I2WBALJGA8P");
    }

    /*
     * This method allows you to create an multipayment with delay capture.
     * Read more about delay capture on https://dev.moip.com.br/v2.0/docs/pagamento-pr%C3%A9-autorizado-1.
     */
    public void createMultipaymentWithDelayCapture() {

        String hash = "HhL0kbhfid+jwgj5l6Kt9EPdetDxQN8s7uKUHDYxDC/XoULjzik44rSda3EcWuOcL17Eb8JjWc1JI7gsuwg9P0rJv1mJQx+d3Dv1puQYz1iRjEWWhnB1bw0gTvnnC/05KbWN5M8oTiugmhVK02Rt2gpbcTtpS7VWyacfgesBJFavYYMljYg8p2YGHXkXrMuQiOCeemKLk420d0OTMBba27jDVVJ663HZDrObnjFXJH/4B5irkj+HO5genV+V4PYoLcOESG4nrI3oFAsMGsLLcdJo0NNvkEmJpn0e9GzureKKFYisYU+BEd9EMr/odS0VMvOYRV65HbPTspIkjl2+3Q==";

        Multipayment multipayment = api.multipayment().create(new PaymentRequest()
            .orderId("MOR-CPB5TML672KD")
            .installmentCount(1)
            .delayCapture(true)
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .hash(hash)
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .taxDocument(TaxDocumentRequest.cpf("33333333333"))
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("66778899")
                        )
                    )
                )
            )
        );
    }

    // This method allows yout to capture an pre-authorized multipayment.
    public void capturePreAuthorizedMultipayment() {

        Multipayment capturedMultipayment = api.multipayment().capture("MPY-PZWPJ1SGUGDK");
    }

    // This method allows you to cancel an pre-authorized multipayment.
    public void cancelPreAuthorizedMultipayment() {

        Multipayment cancelledPayment = api.multipayment().cancelPreAuthorized("MPY-7GUXTEGLG0ZT");
    }

    // This method allows you to get a multipayment.
    public void getMultipayment() {

        Multipayment multipayment = api.multipayment().get("MPY-7GUXTEGLG0ZT");
    }
}
