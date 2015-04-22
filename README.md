# Moip v2 Java client SDK

O jeito mais simples e rápido de integrar o moip a sua aplicação Java

# Instalação

Adicionar no seu pom.xml:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

# Criando um Pedido

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
