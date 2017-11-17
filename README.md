<img src="https://gist.githubusercontent.com/joaolucasl/00f53024cecf16410d5c3212aae92c17/raw/1789a2131ee389aeb44e3a9d5333f59cfeebc089/moip-icon.png" align="right" />

# Moip v2 Java SDK
> O jeito mais simples e rápido de integrar o Moip a sua aplicação Java

[![Join the chat at https://gitter.im/moip/moip-sdk-java](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/moip/moip-sdk-java?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/moip/moip-sdk-java.svg?branch=master)](https://travis-ci.org/moip/moip-sdk-java)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/59c15b9d4e35440c8e1d2810c0509836)](https://www.codacy.com/app/rodrigo-saito/moip-sdk-java)

**Índice**

- [Instalação](#instalação)
- [Configurando a autenticação](#configurando-a-autenticação)
  - [Por BasicAuth](#autenticando-por-basicauth)
  - [Por OAuth](#autenticando-por-oauth)
- [Configurando o ambiente](#configurando-o-ambiente)
- [Exemplos de Uso](#clientes):
  - [Pedidos](#pedidos)
    - [Criação](#criação)
    - [Consulta](#consulta)
      - [Pedido Específico](#pedido-específico)
      - [Todos os Pedidos](#todos-os-pedidos)
        - [Sem Filtro](#sem-filtro)
        - [Com Filtros](#com-filtros)
        - [Com Paginação](#com-paginação)
        - [Consulta Valor Específico](#consulta-valor-específico)
  - [Pagamentos](#pagamentos)
    - [Criação](#criação-1)
      - [Cartão de Crédito](#cartão-de-crédito)
      - [Boleto](#boleto)
    - [Consulta](#consulta-1)
    - [Capturar pagamento pré-autorizado](#capturar-pagamento-pré-autorizado)
    - [Cancelar pagamento pré-autorizado](#cancelar-pagamento-pré-autorizado)
  - [Clientes](#clientes)
    - [Criação](#criação-2)
    - [Consulta](#consulta-2)
    - [Adicionar cartão de crédito](#adicionar-cartão-de-crédito)
    - [Deletar cartão de crédito](#deletar-cartão-de-crédito)
  - [Preferências de Notificação](#preferências-de-notificação)
    -  [Criação](#criação-3)
    -  [Consulta](#consulta-3)
    -  [Exclusão](#exclusão)
    -  [Listagem](#listagem)
  - [Reembolsos](#reembolsos)
    - [Pedido](#pedido)
    - [Pagamento](#pagamento)
    - [Consulta](#consulta-4)
  - [Multipedidos](#multipedidos)
    - [Criação](#criação-4)
    - [Consulta](#consulta-5)
  - [Multipagamentos](#multipagamentos)
    - [Criação](#criação-5)
      - [Cartão de Crédito](#cartão-de-crédito-1)
      - [Boleto Bancário](#boleto-bancário)
    - [Consulta](#consulta-6)
    - [Capturar multipagamento pré-autorizado](#capturar-multipagamento-pré-autorizado)
    - [Cancelar multipagamento pré-autorizado](#cancelar-multipagamento-pré-autorizado)
  - [Conta Moip](#conta-moip)
    - [Criação](#criação-6)
    - [Consulta](#consulta-7)
    - [Verifica se usuário já possui Conta Moip](#verifica-se-usuário-já-possui-conta-moip)
  - [Contas Bancárias](#contas-bancárias)
    - [Criação](#criação-7)
    - [Consulta](#consulta-8)
    - [Exclusão](#exclusão-1)
    - [Atualização](#atualização)
    - [Listagem](#listagem-1)  
  - [Custódia](#custódia)
    - [Pagamento com custódia](#pagamento-com-custódia)
    - [Liberação de custódia](#liberação-de-custódia)
  - [OAuth (Moip Connect)](#oauth-(moip-connect))
    - [Solicitar permissões de acesso ao usuário](#solicitar-permissões-de-acesso-ao-usuário)
    - [Gerar Token OAuth](#gerar-token-oauth)
    - [Atualizar Token OAuth](#atualizar-token-oauth)
- [Tratamento de Exceções](#tratamento-de-exceções)
- [Documentação](#documentação)
- [Licença](#licença)

## Instalação

Adicionar no seu pom.xml:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>3.4.0</version>
</dependency>

```

## Configurando a autenticação

### Autenticando por BasicAuth
```java
Authentication auth = new BasicAuth("TOKEN", "SECRET");
```
### Autenticando por OAuth
```java
Authentication auth = new OAuth("TOKEN_OAUTH");
```

## Configurando o ambiente
Após definir o tipo de autenticação, é necessário gerar o client, informando em qual environment você quer executar suas ações:
```java
Client client = new Client(Client.SANDBOX, auth);
```

Agora você pode instanciar a Api:
```java
API api = new API(client);
```

## Pedidos
### Criação
```java
Order createdOrder = api.order().create(new OrderRequest()
  .ownId("order_own_id")
  .addItem("Nome do produto", 1, "Mais info...", 100)
  .customer(new CustomerRequest()
    .ownId("customer_own_id")
    .fullname("Jose da Silva")
    .email("josedasilva@email.com")
    .birthdate(new ApiDateRequest().date(new Date()))
    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
    .phone(new PhoneRequest().setAreaCode("11").setNumber("55443322"))
    .shippingAddressRequest(new ShippingAddressRequest().street("Avenida Faria Lima")
      .streetNumber("3064")
      .complement("12 andar")
      .city("São Paulo")
      .state("SP")
      .district("Itaim")
      .country("BRA")
      .zipCode("01452-000")
    )
  )
);
```

### Consulta
#### Pedido Específico
```java
String orderId = "ORD-HPMZSOM611M2";
Order order = api.order().get(orderId);
System.out.println(order.toString());
```

#### Todos os Pedidos
##### Sem Filtro
```java
OrderListResponse orders = api.order().list();
```

##### Com Filtros
```java
Filters filters = new Filters()
            .between("amount", "1000", "10000")
            .in("status", status);
OrderListResponse orders = api.order().list(filters);
```

##### Com Paginação
```java
OrderListResponse orders = api.order().list(new Pagination(10,0));
```

##### Consulta Valor Específico
```java
OrderListResponse orders = api.order().list("josé silva");
```

> Também é possível usar paginação, filtros e consulta de valor específico juntos

```java
Filters filters = new Filters()
            .between("amount", "1000", "10000")
            .in("status", status);
OrderListResponse orders = api.order().list(new Pagination(10,0), filters, "josé silva");
```

## Pagamentos

### Criação
#### Cartão de crédito
```java
Payment createdPayment = api.payment().create(new PaymentRequest()
  .orderId("ORD-HPMZSOM611M2")
  .installmentCount(1)
  .fundingInstrument(new FundingInstrumentRequest()
    .creditCard(new CreditCardRequest()
      .hash(CC_HASH)
      .holder(new HolderRequest()
        .fullname("Jose Portador da Silva")
        .birthdate("1988-10-10")
        .phone(new PhoneRequest().setAreaCode("11").setNumber("55667788"))
        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
      )
    )
  )
);
```

#### Boleto
```java
Payment createdPayment = api.payment().create(new PaymentRequest()
  .orderId("ORD-GOHHIF4Z6PLV")
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
```

> Para capturar links do boleto:

```java
// Link do Boleto
createdPayment.getLinks().payBoletoLink();

// Link para impressão do boleto
createdPayment.getLinks().payBoletoPrintLink();
```

### Consulta
```java
Payment payment = api.payment().get(PAYMENT_ID);
System.out.println(payment.toString());
```

### Capturar pagamento pré-autorizado
```java
Payment capturedPayment = api.payment().capture("PAY-FRAAY8GN1HSB");
System.out.println(capturedPayment);
```

### Cancelar pagamento pré-autorizado
```java
Payment cancelledPayment = api.payment().cancelPreAuthorized("PAY-1ECF490M0E25");
System.out.println(cancelledPayment);
```

## Clientes
### Criação
```java
Customer customer = api.customer().create(new CustomerRequest()
  .ownId("CUS-" + System.currentTimeMillis())
  .fullname("Jose da Silva")
  .email("josedasilva@email.com")
  .birthdate(new ApiDateRequest().date(new Date()))
  .taxDocument(TaxDocumentRequest.cpf("22222222222"))
  .phone(new PhoneRequest().setAreaCode("11").setNumber("55443322"))
  .shippingAddressRequest(new ShippingAddressRequest().street("Avenida Faria Lima")
    .streetNumber("3064")
    .complement("12 andar")
    .city("São Paulo")
    .state("SP")
    .district("Itaim")
    .country("BRA")
    .zipCode("01452-000")
  )
);
System.out.println(customer.toString());
```

### Consulta
```java
String customerId = "CUS-Q3BL0CAJ2G33";
Customer customer = api.customer().get(customerId);
System.out.println(customer.toString());
```

### Adicionar cartão de crédito
```java
FundingInstrument creditCard = api.customer().addCreditCard(
    new CustomerRequest()
        .fundingInstrument(
            new FundingInstrumentRequest()
                .creditCard(
                    new CreditCardRequest()
                        .number("5555666677778884")
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
System.out.println(creditCard);
```

### Deletar cartão de crédito
```java
api.customer().deleteCreditCard("CRC-NMNW6VIY2L0T")
```

## Preferências de notificação

### Criação
```java
NotificationPreference notificationPreference = api.notification().create(
    new NotificationPreferenceRequest()
        .addEvent("ORDER.*")
        .addEvent("PAYMENT.AUTHORIZED")
        .addEvent("PAYMENT.CANCELLED")
        .target("http://requestb.in/1dhjesw1")
);
```

### Consulta
```java
NotificationPreference notificationPreference = api.notification().get("NPR-NR0GR85KHL10");
System.out.println(notificationPreference.toString());
```

### Exclusão
```java
api.notification().delete("NPR-NR0GR85KHL10"));
```

### Listagem
```java
NotificationPreferenceListResponse notificationList = api.notification().list();
```

### Reembolsos

> Para fazer reembolsos totais basta remover o método ```amount```.

### Pedido
#### Cartão de Crédito
```java
Refund refund = api.refund().order(
    new RefundRequest("ORD-89SOQ6FMPJPX")
        .refundingInstrument(new RefundingInstrumentRequest().creditCard())
        .amount(2000)
);
```

#### Conta Bancária
```java
Refund refund = api.refund().order(
    new RefundRequest("ORD-GS1FSQ3SO9SY")
        .refundingInstrument(new RefundingInstrumentRequest()
            .bankAccount(
                new BankAccountRequest()
                    .checking()
                    .bankNumber("001")
                    .accountNumber("1234")
                    .accountCheckNumber("1")
                    .agencyNumber("4444444")
                    .agencyCheckNumber("2")
                    .holder(new HolderRequest()
                        .fullname("Nome do Portador")
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
            )
        )
        .amount(2000)
);
```

### Pagamento
#### Cartão de Crédito

```java
Refund refund = api.refund().payment(
    new RefundRequest("PAY-70380H9B6L5R")
        .refundingInstrument(new RefundingInstrumentRequest().creditCard())
        .amount(2000)
);
```

#### Conta Bancária
```java
Refund refund = api.refund().payment(
    new RefundRequest("PAY-E4Q0N9TK0BFW")
        .refundingInstrument(new RefundingInstrumentRequest()
            .bankAccount(
                new BankAccountRequest()
                    .checking()
                    .bankNumber("001")
                    .accountNumber("1234")
                    .accountCheckNumber("1")
                    .agencyNumber("4444444")
                    .agencyCheckNumber("2")
                    .holder(new HolderRequest()
                        .fullname("Nome do Portador")
                        .taxDocument(TaxDocumentRequest.cpf("22222222222"))
                    )
            )
        )
        .amount(2000)
);
```

### Consulta
```java
Refund refund = api.refund().get("REF-JR4WALM894UJ");
System.out.println(refund);
```

## Multipedidos

### Criação
```java
Multiorder multiorder = api.multiorder().create(new MultiorderRequest()
    .ownId("meu_multiorder_id")
    .addOrder(new OrderRequest()
        .ownId("pedido_1_id")
        .amount(new OrderAmountRequest()
            .subtotals(new SubtotalsRequest().shipping(2000))
            .currency("BRL")
        )
        .addItem("Camisa Verde e Amarelo - Brasil", 1, "Seleção Brasileira", 2000)
        .customer(new CustomerRequest()
            .ownId("customer[1234]")
            .fullname("Joao Sousa")
            .email("joao.sousa@email.com")
            .birthdate(new ApiDateRequest().date(new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime()))
            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
            .phone(new PhoneRequest()
                .countryCode("55")
                .setAreaCode("11")
                .setNumber("66778899"))
            .shippingAddressRequest(new ShippingAddressRequest()
                .street("Avenida Faria Lima")
                .streetNumber("2927")
                .zipCode("01234000")
                .city("Sao Paulo")
                .state("SP")
                .complement("8")
                .district("Itaim"))
        )
        .addReceiver(new ReceiverRequest()
            .secondary("MPA-E3C8493A06AE", new AmountRequest().fixed(500), false))
        .addReceiver(new ReceiverRequest()
            .primary("MPA-8D5DBB4EF8B8", new AmountRequest(), true))
    )
    .addOrder(new OrderRequest()
        .ownId("pedido_2_id")
        .amount(new OrderAmountRequest()
            .subtotals(new SubtotalsRequest().shipping(3000))
            .currency("BRL")
        )
        .addItem("Camisa Preta - Alemanha", 1, "Camiseta da Copa 2014", 1000)
        .customer(new CustomerRequest()
            .ownId("customer[1234]")
            .fullname("Joao Sousa")
            .email("joao.sousa@email.com")
            .birthdate(new ApiDateRequest().date(new GregorianCalendar(1988, Calendar.DECEMBER, 30).getTime()))
            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
            .phone(new PhoneRequest()
                .countryCode("55")
                .setAreaCode("11")
                .setNumber("66778899"))
            .shippingAddressRequest(new ShippingAddressRequest()
                .street("Avenida Faria Lima")
                .streetNumber("2927")
                .zipCode("01234000")
                .city("Sao Paulo")
                .state("SP")
                .complement("8")
                .district("Itaim"))
        )
        .addReceiver(new ReceiverRequest()
            .primary("MPA-123123123", new AmountRequest())
        )
    )
);
```

### Consulta
```java
Multiorder multiorder = api.multiorder().get("MOR-F2R675E1X97P");
System.out.println(multiorder);
```

## Multipagamentos

### Criação
#### Cartão de Crédito
```java
Multipayment multipayment = api.multipayment().create(new PaymentRequest()
    .orderId("MOR-BMJN4E5LSG6N")
    .installmentCount(1)
    .delayCapture(false)
    .fundingInstrument(
        new FundingInstrumentRequest()
            .creditCard(
                new CreditCardRequest()
                    .hash(CC_HASH)
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
);
```

#### Boleto Bancário
```java
Multipayment multipayment = api.multipayment().create(new PaymentRequest()
        .orderId("MOR-F2R675T1X97P")
        .installmentCount(1)
        .fundingInstrument(new FundingInstrumentRequest()
            .boleto(new BoletoRequest()
                .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2017, Calendar.SEPTEMBER, 30).getTime()))
                .instructionLines(new InstructionLinesRequest()
                    .first("Primeira linha se instrução")
                    .second("Segunda linha se instrução")
                    .third("Terceira linha se instrução")
                )
                .logoUri("http://")
            )
        )
    );
```

### Consulta
```java
Multipayment multipayment = api.multipayment().get("MPY-OUGA0AHH2BOF");
System.out.println(multipayment);
```

### Capturar multipagamento pré-autorizado
```java
Multipayment capturedMultipayment = api.multipayment().capture("MPY-UGZLJMVJ37LX");
System.out.println(capturedMultipayment);
```

### Cancelar multipagamento pré-autorizado
```java
Multipayment cancelledMultipayment = api.multipayment().cancelPreAuthorized("MPY-YDNM3U17OSDD");
System.out.println(cancelledMultipayment);
```

## Conta Moip
### Criação
```java
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
```

### Consulta
```java
Account account = api.account().get("MPA-AE2OAL41CBG1");
System.out.println(account);
```

### Verifica se usuário já possui Conta Moip
```java
api.account().checkAccountExists("123.456.798-91");
```

## Contas Bancárias
### Criação
```java
BankAccount createdBankAccount = api.create("MPA-E0BAC6D15696",
    new BankAccountRequest()
        .bankNumber("237")
        .agencyNumber("12346")
        .agencyCheckNumber("0")
        .accountNumber("12345679")
        .accountCheckNumber("7")
        .checking()
        .holder(new HolderRequest()
            .fullname("Vagner")
            .taxDocument(TaxDocumentRequest.cpf("22222222222"))
        )
);
```
### Consulta
```java
BankAccount createdBankAccount = api.get("BKA-E0BAC6D15696");
```
### Exclusão
```java
api.delete("BKA-E0BAC6D15696");
```
### Atualização
```java
BankAccount createdBankAccount = api.update("BKA-E0BAC6D15696", 
	new BankAccountRequest()
    	.bankNumber("237")
        .agencyNumber("12345")
        .agencyCheckNumber("8")
        .accountNumber("12345678")
        .accountCheckNumber("8")
        .checking()
        .holder(
    		new HolderRequest()
            .fullname("Demo Moip")
            .taxDocument(
        	    TaxDocumentRequest.cpf("62213453322")
            )
        )
);
```

### Listagem
```java
List<BankAccount> createdBankAccounts = api.getList("MPA-E0BAC6D15696");
```

## Custódia
### Pagamento com custódia
```java
Payment payment = api.payment().create(
    new PaymentRequest()
        .orderId("ORD-3435DIB58HYN")
        .installmentCount(1)
        .escrow(new PaymentRequest.EscrowRequest("Teste de descricao"))
        .fundingInstrument(new FundingInstrumentRequest()
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
);
System.out.println(payment);
```

### Liberação de custódia
```java
Escrow escrow = api.escrow().release("ECW-S0QEDXJM7TXT");
System.out.println(escrow);
```

## OAuth (Moip Connect)
### Solicitar permissões de acesso ao usuário
```java
String authURL = api.connect().getAuthorizeUrl("APP-XT5FIAK2F8I7",
    "http://localhost/moip/callback.php",
    new ScopePermissionList(ScopePermission.DEFINE_PREFERENCES
        , ScopePermission.MANAGE_ACCOUNT_INFO
        , ScopePermission.RECEIVE_FUNDS
        , ScopePermission.REFUND
        , ScopePermission.RETRIEVE_FINANCIAL_INFO
        , ScopePermission.TRANSFER_FUNDS
    )
);
System.out.println(authURL);
```

### Gerar token OAuth
```java
Connect connect = api.connect().authorize(new ConnectRequest()
    .clientId("APP-XT5FIAK2F8I7")
    .clientSecret("e2bd3951b87e469eb0f2c2b781a753d5")
    .code("8870af1372ada7a18fdff4fa4ca1a60f4d542272")
    .redirectUri("http://localhost/moip-sdk/callback")
    .grantType(GrantType.authorization_code)
);
System.out.println(connect);
```

### Atualizar token OAuth
```java
Connect connect = api.connect().authorize(new ConnectRequest()
    .refreshToken("80ca5fb244674117be068d2535ecbe2f_v2")
    .grantType(GrantType.refresh_token)
);
System.out.println(connect);
```

## Tratamento de Exceções

Quando ocorre algum erro na API, é lançada a exceção UnexpectedException para erros inesperados e ValidationException 
para erros de validação.

```java
try {
 Payment createdPayment = api.payment().create(
        //...
    );
} catch(UnexpectedException e) {
  //StatusCode >= 500
} catch(ValidationException e) {
  //StatusCode entre 400 e 499 (exceto 401)
}
```

## Documentação

[Documentação oficial](https://moip.com.br/referencia-api/)

## Licença

[The MIT License](https://github.com/moip/moip-sdk-java/blob/master/LICENSE)