# Moip v2 Java client SDK

O jeito mais simples e rápido de integrar o moip a sua aplicação Java

## Instalação

Adicionar no seu pom.xml:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Criando um Pedido

```java
Order createdOrder = moip.orders()
    .setOwnId("java_sdk_1")
    .addItem("Nome do produto", 1, "Mais info...", 1000)
    .setShippingAmount(100)
    .setCustomer(
        moip.customers()
            .setOwnId("java_sdk_customer_1")
            .setFullname("Jose da Silva")
            .setEmail("sandbox_v2_1401147277@email.com")
            .setBirthDate("1988-12-30")
            .setTaxDocument("33333333333")
            .setPhone("11", "66778899", "55")
            .setShippingAddress(
                new Address()
                    .setStreet("Avenida Faria Lima")
                    .setStreetNumber("2927")
                    .setComplement("8")
                    .setDistrict("Itaim")
                    .setCity("São Paulo")
                    .setState("SP")
                    .setZipCode("01234000")
            )
    )
    .create();
```

## Criando um pagamento

```java
Order order = moip.orders().get("ORD-JY95N80TXHXV");

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
