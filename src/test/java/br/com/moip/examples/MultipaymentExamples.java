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

    // API instance
    API api = new Setup().buildSetup();

    // OKAY
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

    // OKAY
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

    // OKAY
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


    // OKAY
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

    // OKAY
    public void releaseEscrow() {

        Escrow escrow = api.escrow().release("ECW-9I2WBALJGA8P");
    }

    // OKAY
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

    // OKAY
    public void capturePreAuthorizedMultipayment() {

        Multipayment capturedMultipayment = api.multipayment().capture("MPY-PZWPJ1SGUGDK");
    }

    // OKAY
    public void cancelPreAuthorizedMultipayment() {

        Multipayment cancelledPayment = api.multipayment().cancelPreAuthorized("MPY-7GUXTEGLG0ZT");
    }

    // OKAY
    public void getMultipayment() {

        Multipayment multipayment = api.multipayment().get("MPY-7GUXTEGLG0ZT");
    }
}
