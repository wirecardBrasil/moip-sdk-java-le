package br.com.moip.api;

import br.com.moip.request.AccountRequest;
import br.com.moip.request.ApiDateRequest;
import br.com.moip.request.CompanyRequest;
import br.com.moip.request.IdentityDocumentRequest;
import br.com.moip.request.PersonRequest;
import br.com.moip.request.PhoneRequest;
import br.com.moip.request.ShippingAddressRequest;
import br.com.moip.request.TaxDocumentRequest;
import br.com.moip.resource.Account;
import com.rodrigosaito.mockwebserver.player.Play;
import com.rodrigosaito.mockwebserver.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class AccountAPITest {

    @Rule
    public Player player = new Player();

    private AccountAPI api;

    @Before
    public void setUp() {
        ClientFactory clientFactory = new ClientFactory();

        api = new AccountAPI(clientFactory.client(player.getURL("").toString()));
    }

    @Play("accounts/get")
    @Test
    public void doReturnAccount(){
        Account account = api.get();

        assertEquals("MPA-AE2OAL41CBB1", account.getId());
        assertEquals("iori@labs.moip.com.br", account.getLogin());
        assertEquals("iorilabsmoip", account.getSoftDescriptor());
        assertEquals("iori@labs.moip.com.br", account.getEmail().getAddress());
        assertEquals(false, account.isTransparentAccount());
    }

    @Play("accounts/check_account")
    @Test
    public void checkExistingAccount() {
        assertTrue(api.checkAccountExists("123.456.798-91"));
    }

    @Play("accounts/check_account")
    @Test
    public void checkNonExistingAccount() {
        assertFalse(api.checkAccountExists("781.513.493-95"));
    }

    @Play("accounts/create")
    @Test
    public void createAccount() {
        Account account = api.create(new AccountRequest()
            .email("dev.moip@labs8489.moip.com.br")
            .type(AccountRequest.Type.MERCHANT)
            .transparentAccount(true)
            .site("https://dev.moip.com.br/")
            .person(new PersonRequest()
                .name("Runscope")
                .lastName("Random 9123")
                .birthDate(new ApiDateRequest().date(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                .nationality("BRA")
                .birthPlace("Santos")
                .taxDocument(TaxDocumentRequest.cpf("232.233.768-44"))
                .address(new ShippingAddressRequest()
                    .street("Av. Brigadeiro Faria Lima")
                    .streetNumber("2927")
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
                .addAlternativePhone(new PhoneRequest()
                    .countryCode("55")
                    .setAreaCode("11")
                    .setNumber("975142244")
                )
                .identityDocument(new IdentityDocumentRequest()
                    .number("434322344")
                    .issuer("SSP")
                    .issueDate(new ApiDateRequest().date(new GregorianCalendar(2000, Calendar.DECEMBER, 12).getTime()))
                    .type(IdentityDocumentRequest.Type.RG)
                )
            )
        );

        assertNotNull(account.getId());
        assertNotNull(account.getAccessToken());
        assertEquals("dev.moip@labs8489.moip.com.br", account.getEmail().getAddress());
        assertEquals("https://dev.moip.com.br", account.getSite());
        assertEquals(Account.Type.MERCHANT, account.getType());
        assertEquals("Runscope", account.getPerson().getName());
        assertEquals("Random 9123", account.getPerson().getLastName());
        assertEquals("1990-01-01", account.getPerson().getBirthDate().getFormatedDate());
        assertEquals("BRA", account.getPerson().getNationality());
        assertEquals("Santos", account.getPerson().getBirthPlace());
        assertEquals("232.233.768-44", account.getPerson().getTaxDocument().getNumber());
        assertEquals("434322344", account.getPerson().getIdentityDocument().getNumber());
        assertEquals("965213244", account.getPerson().getPhone().getNumber());
        assertEquals("975142244", account.getPerson().getAlternativePhones().get(0).getNumber());
        assertNotNull(account.getLinks());
        assertEquals("https://desenvolvedor.moip.com.br/sandbox/AskForNewPassword.do?method=confirm\u0026email=dev.moip%40labs8489.moip.com.br\u0026code=99f009eb1990a96b1d338975211e4109", account.getLinks().getSetPassword().getHref());
    }

    @Play("accounts/create_with_company")
    @Test
    public void createAccountWithCompany() {
        Account account = api.create(new AccountRequest()
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
                    .address(new ShippingAddressRequest()
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
                .address(new ShippingAddressRequest()
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

        assertNotNull(account.getId());
        assertNotNull(account.getAccessToken());
        assertEquals("dev.moip@labs52453.moip.com.br", account.getEmail().getAddress());
        assertEquals("4530", account.getCompany().getAddress().getStreetNumber());
        assertEquals("953.394.633-46", account.getPerson().getTaxDocument().getNumber());
        assertEquals("Teste LTDA", account.getCompany().getName());
        assertEquals("61.148.461/0001-09", account.getCompany().getTaxDocument().getNumber());
        assertEquals("Teste", account.getCompany().getBusinessName());
        assertEquals("2000-01-01", account.getCompany().getOpeningDate().getFormatedDate());
        assertEquals("975142244", account.getCompany().getPhone().getNumber());
        assertEquals("35", account.getBusinessSegment().getId());
        assertNotNull(account.getLinks());
        assertEquals("https://desenvolvedor.moip.com.br/sandbox/AskForNewPassword.do?method=confirm\u0026email=dev.moip%40labs52453.moip.com.br\u0026code=eba4c7ecec76e2af2dac10e81072c17d", account.getLinks().getSetPassword().getHref());
    }
}