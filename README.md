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
  - [Pagamentos](#pagamentos)
    - [Cartão de Crédito](#cartão-de-crédito)
    - [Boleto](#boleto)
  - [Clientes](#clientes)
    - [Criação](#criação-1)
    - [Consulta](#consulta-1)
  - [Preferências de Notificação](#preferências-de-notificação)
    -  [Criação](#criação-2)
    -  [Consulta](#consulta-2)
    -  [Exclusão](#exclusão)
    -  [Listagem](#listagem)
  - [Reembolsos](#reembolsos)
    - [Pedido](#pedido)
    - [Pagamento](#pagamento)
    - [Consulta](#consulta-3)
- [Tratamento de Exceções](#tratamento-de-exceções)
- [Documentação](#documentação)
- [Licença](#licença)

## Instalação

Adicionar no seu pom.xml:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>2.1.2</version>
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
```java
String orderId = "ORD-HPMZSOM611M2";
Order order = api.order().get(orderId);
System.out.println(order.toString());
```

## Pagamentos

### Cartão de crédito

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

### Boleto

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

## Tratamento de Exceções

Quando ocorre algum erro na API, é lançada a exceção UnexpectecException para erros inesperados e ValidationException 
para erros de validação.

```java
try {
 Payment createdPayment = api.payment().create(
        //...
    );
} catch(UnexpectecException e) {
  //StatusCode >= 500
} catch(ValidationException e) {
  //StatusCode entre 400 e 499 (exceto 401)
}
```

## Documentação

[Documentação oficial](https://moip.com.br/referencia-api/)

## Licença

[The MIT License](https://github.com/moip/moip-sdk-java/blob/master/LICENSE)