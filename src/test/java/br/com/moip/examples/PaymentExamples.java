package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.request.PaymentRequest;
import br.com.moip.request.FundingInstrumentRequest;
import br.com.moip.request.CreditCardRequest;
import br.com.moip.request.HolderRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.BoletoRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.InstructionLinesRequest;
import br.com.moip.request.OnlineBankDebitRequest;
import br.com.moip.examples.setup.Setup;
import br.com.moip.resource.Escrow;
import br.com.moip.resource.Payment;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentExamples {

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
    public void createPaymentWithCreditCardHash() {

        String hash = "CCbe2TVHIsINX+v+bVPP0KSKWfXs6AtrJlHznaSdTgmvNFOvsalZ7pFgoddc3fH7vEdpxCa55ed1DoNIzWWUo3+7KLQgV0Gi/ux0RShBiNzB0wiFf+OBef9x7b3IgcdulZqdNGn84AvGInJ9r6a2iZ8kY0xQ1xONOod5rVkuGDvNgVVOIB7Zs5In9j3f4TENRU7aqx63srT3UPP+wsQBMNJ4wQturogjZBhDIQqEm2sC9Zzx+E8zP/aZ+YBF9O+nfeofF4S2E9bs4A9neWCivntqwENX0O755NamWX/up2MbyHu8N+cm493RrbUT76jibB0RyyT9nkKpSOuJIGU8vA==";

        Payment createdPayment = api.payment().create(new PaymentRequest()
            .orderId("ORD-OYEHY0I2CCE0")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .hash(hash)
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("55667788"))
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
                    .store(true)
                )
            )
        );
    }

    // OKAY
    public void createPaymentWithCreditCard() {

        Payment createdPayment = api.payment().create(new PaymentRequest()
            .orderId("ORD-XF29LOEE180J")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .number("5555666677778884")
                    .cvc(123)
                    .expirationMonth("12")
                    .expirationYear("20")
                    .holder(new HolderRequest()
                        .fullname("Jose Portador da Silva")
                        .birthdate("1988-10-10")
                        .phone(new PhoneRequest()
                            .setAreaCode("11")
                            .setNumber("55667788")
                        )
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
                    .store(true)
                )
            )
        );
    }

    // OKAY
    public void createPaymentWithBoleto() {

        Payment createdPayment = api.payment().create(new PaymentRequest()
            .orderId("ORD-WUBNJLF40ZY1")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .boleto(new BoletoRequest()
                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2020, Calendar.NOVEMBER, 10).getTime()))
                    .logoUri("http://logo.com")
                    .instructionLines(new InstructionLinesRequest()
                        .first("Primeira linha")
                        .second("Segunda linha")
                        .third("Terceira linha")
                    )
                )
            )
        );
    }

    // OKAY
    public void createPaymentWithOnlineBankDebit() {

        Payment payment = api.payment().create(new PaymentRequest()
            .orderId("ORD-KKVQG0G34HY9")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .onlineBankDebit(new OnlineBankDebitRequest()
                    .bankNumber("341")
                    .expirationDate(new ApiDateRequest().date(new Date("2018/11/22")))

                )
            )

        );
    }

    // OKAY
    public void createPaymentWithEscrow() {

        Payment payment = api.payment().create(new PaymentRequest()
            .orderId("ORD-Z4S4QR6V70C3")
            .installmentCount(1)
            .escrow(new PaymentRequest.EscrowRequest("Custódia de pagamento"))
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .number("4012001037141112")
                    .cvc(123)
                    .expirationMonth("05")
                    .expirationYear("18")
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

    // OKAY
    public void releaseEscrow() {

        Escrow escrow = api.escrow().release("ECW-HOB45PCGSOKK");
    }

    // OKAY
    public void createPaymentWithDelayCapture() {

        String hash = "CCbe2TVHIsINX+v+bVPP0KSKWfXs6AtrJlHznaSdTgmvNFOvsalZ7pFgoddc3fH7vEdpxCa55ed1DoNIzWWUo3+7KLQgV0Gi/ux0RShBiNzB0wiFf+OBef9x7b3IgcdulZqdNGn84AvGInJ9r6a2iZ8kY0xQ1xONOod5rVkuGDvNgVVOIB7Zs5In9j3f4TENRU7aqx63srT3UPP+wsQBMNJ4wQturogjZBhDIQqEm2sC9Zzx+E8zP/aZ+YBF9O+nfeofF4S2E9bs4A9neWCivntqwENX0O755NamWX/up2MbyHu8N+cm493RrbUT76jibB0RyyT9nkKpSOuJIGU8vA==";

        Payment payment = api.payment().create(new PaymentRequest()
            .orderId("ORD-Z7GID1ZO7LKQ")
            .installmentCount(1)
            .delayCapture(true)
            .fundingInstrument(new FundingInstrumentRequest()
                .creditCard(new CreditCardRequest()
                    .hash(hash)
                    .holder(new HolderRequest()
                        .fullname("Roberto Oliveira")
                        .birthdate("1988-12-30")
                        .taxDocument(TaxDocumentRequest.cpf("78994193600"))
                        .phone(new PhoneRequest()
                            .countryCode("55")
                            .setAreaCode("11")
                            .setNumber("22849560")
                        )
                    )
                    .store(true)
                )
            )
        );
    }

    // OKAY
    public void capturePreAuthorizedPayment() {

        Payment capturedPayment = api.payment().capture("PAY-JQPQR9F2ITOT");
    }

    // OKAY
    public void cancelPreAuthorizedPayment() {

        Payment cancelledPayment = api.payment().cancelPreAuthorized("PAY-BJ5WQIFZFN24");
    }

    // OKAY
    public void getPayment() {

        Payment payment = api.payment().get("PAY-BJ5WQIFZFN24");
    }
}
