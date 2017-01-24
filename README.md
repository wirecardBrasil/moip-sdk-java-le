# Moip v2 Java client SDK

[![Join the chat at https://gitter.im/moip/moip-sdk-java](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/moip/moip-sdk-java?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/moip/moip-sdk-java.svg?branch=master)](https://travis-ci.org/moip/moip-sdk-java)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/59c15b9d4e35440c8e1d2810c0509836)](https://www.codacy.com/app/rodrigo-saito/moip-sdk-java)

O jeito mais simples e rápido de integrar o moip a sua aplicação Java

## Instalação

Adicionar no seu pom.xml:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>2.0.0-RC6</version>
</dependency>
```

## Configurando sua autenticação

- Autenticando por BasicAuth
```java
Authentication auth = new BasicAuth("TOKEN", "SECRET");
```
- Autenticando por OAuth
```java
Authentication auth = new OAuth("TOKEN_OAUTH");
```

Após deifinir o tipo de autenticação, é necessário gerar o client, informando em qual environment você quer executar suas ações:
```java
Client client = new Client(Client.SANDBOX, auth);
```

Agora você pode instanciar a Api:
```java
API api = new API(client);
```

## Criando um Pedido

```java
Order createdOrder = api.create(new OrderRequest()
                                        .ownId("order_own_id")
                                        .addItem("Nome do produto", 1, "Mais info...", 100)
                                        .customer(new CustomerRequest()
                                                        .ownId("customer_own_id")
                                                        .fullname("Jose da Silva")
                                                        .email("sandbox_v2_1401147277@email.com")
                                        )
);
```

## Criando um pagamento

### Cartão de crédito

```java
Payment createdPayment = api.create(
        new PaymentRequest()
                .orderId("ORD-HPMZSOM611M2")
                .installmentCount(1)
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

### Boleto

```java
 Payment createdPayment = api.create(
        new PaymentRequest()
            .orderId("ORD-GOHHIF4Z6PLV")
            .installmentCount(1)
            .fundingInstrument(new FundingInstrumentRequest()
                .boleto(new BoletoRequest()
                    .expirationDate(new ApiDateRequest().date(new GregorianCalendar(2020, Calendar.NOVEMBER, 10).getTime()))
                    .logoUri("http://logo.com")
                    .instructionLines(new InstructionLinesRequest()
                        .first("Primeira linha")
                        .second("Segunda linha")
                        .third("Terceira linha"))
                )
            )
    );
```

## Tratamento de Exceções

Quando ocorre algum erro na API, você deve utilizar o método hasUnexpectedError() para tratar erros inesperados e
para erros de validação,deverá utilizar o método hasValidationError().
