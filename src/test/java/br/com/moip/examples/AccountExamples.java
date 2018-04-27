package br.com.moip.examples;

import br.com.moip.API;
import br.com.moip.examples.setup.Setup;
import br.com.moip.request.RequestTest;
import br.com.moip.request.AccountRequest;
import br.com.moip.request.PersonRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.request.AddressRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.IdentityDocumentRequest;
import br.com.moip.request.CompanyRequest;
import br.com.moip.resource.Account;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AccountExamples extends RequestTest {

    /**
     * To give an amazing on-boarding, you as marketplace should think
     * "what experience I want to give for my sellers".
     * Thinking that, the Moip create two types of account, each one with a
     * different way to administer your business.
     *
     * Read more about Moip accounts on:
     * https://dev.moip.com.br/v2.0/docs/conta-classica-e-conta-transparente
     */

    // API instance
    API api = new Setup().buildSetup();

    /*
     * This method allows you to create a classical Moip account.
     * For more about classical Moip accounts, check the following link:
     * https://dev.moip.com.br/v2.0/reference#classical-account-on-boarding
     */
    public void createClassicalAccount() {

        Account account = api.account().create(new AccountRequest()
            .email("dev.moip@labs52453.moip.com.br")
            .type(AccountRequest.Type.MERCHANT)
            .transparentAccount(false)
            .businessSegment(new AccountRequest.BusinessSegmentRequest("35"))
            .site("https://dev.moip.com.br/")
            .person(new PersonRequest()
                .name("Runscope")
                .lastName("Random 9123")
                .birthDate(new ApiDateRequest().date(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                .nationality("BRA")
                .birthPlace("Santos")
                .taxDocument(TaxDocumentRequest.cpf("953.394.633-46"))
                .address(new AddressRequest()
                    .street("Av. Brigadeiro Faria Lima")
                    .streetNumber("434")
                    .district("Itaim")
                    .city("São Paulo")
                    .state("SP")
                    .country("BRA")
                    .zipCode("01234000")
                )
                .phone(new PhoneRequest()
                    .countryCode("55")
                    .setAreaCode("11")
                    .setNumber("965213244")
                )
                .identityDocument(new IdentityDocumentRequest()
                    .number("434322344")
                    .issuer("SSP")
                    .issueDate(new ApiDateRequest().date(new GregorianCalendar(2000, Calendar.DECEMBER, 12).getTime()))
                    .type(IdentityDocumentRequest.Type.RG)
                )
            )
        );
    }

    /*
     * This method create a transparent Moip account.
     * For more about transparent Moip account rules and conditions, check the fallowing link:
     * https://dev.moip.com.br/v2/reference#transparent-account-on-boarding
     */
    public void createTransparentAccount() {

        Account account = api.account().create(new AccountRequest()
            .email("dev.moip@labs52453.moip.com.br")
            .type(AccountRequest.Type.MERCHANT)
            .transparentAccount(true)
            .businessSegment(new AccountRequest.BusinessSegmentRequest("35"))
            .site("https://dev.moip.com.br/")
            .person(new PersonRequest()
                .name("Runscope")
                .lastName("Random 9123")
                .birthDate(new ApiDateRequest().date(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                .nationality("BRA")
                .birthPlace("Santos")
                .taxDocument(TaxDocumentRequest.cpf("953.394.633-46"))
                .address(new AddressRequest()
                    .street("Av. Brigadeiro Faria Lima")
                    .streetNumber("434")
                    .district("Itaim")
                    .city("São Paulo")
                    .state("SP")
                    .country("BRA")
                    .zipCode("01234000")
                )
                .phone(new PhoneRequest()
                    .countryCode("55")
                    .setAreaCode("11")
                    .setNumber("965213244")
                )
                .identityDocument(new IdentityDocumentRequest()
                    .number("434322344")
                    .issuer("SSP")
                    .issueDate(new ApiDateRequest().date(new GregorianCalendar(2000, Calendar.DECEMBER, 12).getTime()))
                    .type(IdentityDocumentRequest.Type.RG)
                )
            )
        );
    }

    /*
     * This method allows you to create a Moip account registering the company data.
     * TIP: both a classical account and a transparent account can register the company data.
     */
    public void createMoipAccountWithCompany() {

        Account account = api.account().create(new AccountRequest()
            .email("dev.moip@labs52453.moip.com.br")
            .type(AccountRequest.Type.MERCHANT)
            .transparentAccount(true)
            .businessSegment(new AccountRequest.BusinessSegmentRequest("35"))
            .site("https://dev.moip.com.br/")
            .person(new PersonRequest()
                .name("Runscope")
                .lastName("Random 9123")
                .birthDate(new ApiDateRequest().date(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                .nationality("BRA")
                .birthPlace("Santos")
                .taxDocument(TaxDocumentRequest.cpf("953.394.633-46"))
                .address(new AddressRequest()
                    .street("Av. Brigadeiro Faria Lima")
                    .streetNumber("434")
                    .district("Itaim")
                    .city("São Paulo")
                    .state("SP")
                    .country("BRA")
                    .zipCode("01234000")
                )
                .phone(new PhoneRequest()
                    .countryCode("55")
                    .setAreaCode("11")
                    .setNumber("965213244")
                )
                .identityDocument(new IdentityDocumentRequest()
                    .number("434322344")
                    .issuer("SSP")
                    .issueDate(new ApiDateRequest().date(new GregorianCalendar(2000, Calendar.DECEMBER, 12).getTime()))
                    .type(IdentityDocumentRequest.Type.RG)
                )
            )
            .company(new CompanyRequest()
                .name("Teste LTDA")
                .businessName("Teste")
                .address(new AddressRequest()
                    .street("Av. Brigadeiro Faria Lima")
                    .streetNumber("4530")
                    .district("Itaim")
                    .city("São Paulo")
                    .state("SP")
                    .country("BRA")
                    .zipCode("01234000")
                )
                .mainActivity(new CompanyRequest.MainActivityRequest()
                    .cnae("82.91-1/00")
                    .description("Atividades de cobranças e informações cadastrais")
                )
                .taxDocument(TaxDocumentRequest.cnpj("61.148.461/0001-09"))
                .openingDate(new ApiDateRequest().date(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime()))
                .phone(new PhoneRequest()
                    .countryCode("55")
                    .setAreaCode("11")
                    .setNumber("975142244")
                )
            )
        );
    }

    // This method allows you to get a Moip account.
    public void gGetAccount() {

        Account account = api.account().get("MPA-CULBBYHD11");
    }

    // This method allows you to check if someone already has a Moip account, by CPF or CNPJ.
    public void checkAccountExists() {

        api.account().checkAccountExists("255.328.259-12");
    }
}
