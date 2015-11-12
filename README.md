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
    <version>2.0.0</version>
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
Order createdOrder = api.order().create(new Order()
    .setOwnId("order_own_id")
    .addItem("Nome do produto", 1, "Mais info...", 100)
    .setCustomer(new Customer()
                    .setOwnId("customer_own_id")
                    .setFullname("Jose da Silva")
                    .setEmail("sandbox_v2_1401147277@email.com")
    )
);
```

## Criando um pagamento

### Cartão de crédito

```java
Payment createdPayment = order.payments()
    .setInstallmentCount(1)
    .setCreditCard(
        new CreditCard()
            .setNumber("4012001038443335")
            .setCvc("123")
            .setExpirationMonth("04")
            .setExpirationYear("18")
            .setHolder(
                new Holder()
                    .setFullname("Jose Portador da Silva")
                    .setBirthDate("1988-10-10")
                    .setPhone(
                        new Phone()
                            .setAreaCode("11")
                            .setNumber("55667788")
                    )
                    .setTaxDocument(TaxDocument.cpf("22222222222"))
            )
    )
    .execute();
```

### Boleto

```java
Payment createdPayment = order.payments()
    .setBoleto(
        new Boleto()
            .setExpirationDate("2015-09-30")
            .setLogoUri("https://")
            .setFirstInstructionLine("Primeira linha do boleto")
            .setSecondInstructionLine("Segunda linha do boleto")
            .setThirdInstructionLine("Terceira linha do boleto")
    )
    .execute();
```

## Tratamento de Exceções

Quando ocorre algum erro na API, você deve utilizar o método hasUnexpectedError() para tratar erros inesperados e
para erros de validação,deverá utilizar o método hasValidationError().
