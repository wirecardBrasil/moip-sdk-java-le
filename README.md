<img src="https://gist.githubusercontent.com/joaolucasl/00f53024cecf16410d5c3212aae92c17/raw/1789a2131ee389aeb44e3a9d5333f59cfeebc089/moip-icon.png" align="right" />

# Moip Java SDK
> Moip API v2 Java SDK for client integration.

[![Build Status](https://travis-ci.org/moip/moip-sdk-java.svg?branch=master)](https://travis-ci.org/moip/moip-sdk-java)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/59c15b9d4e35440c8e1d2810c0509836)](https://www.codacy.com/app/rodrigo-saito/moip-sdk-java)
[![Software License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/moip/moip-sdk-java/blob/master/LICENSE)
[![Slack](https://slackin-cqtchmfquq.now.sh/badge.svg)](https://slackin-cqtchmfquq.now.sh/)

<details>
    <summary>Index</summary>

* [Simple flow](#simple-flow)
  * [Setup](#setup)
    * [Setting the authentication](#setting-the-authentication)
    * [Client](#client)
    * [Instantiate API](#instantiate-api)
  * [Create customer](#create-customer)
  * [Create order](#create-order)
  * [Create Payment](#create-payment)
  * [Other examples](#other-examples)
* [Exceptions treatment](#exceptions-treatment)
* [Moip documentation](#moip-documentation)
* [Getting help](#getting-help)
* [Contributing](#contributing)

</details>

## Require

Java `v1.7ˆ` ![java-cup](https://user-images.githubusercontent.com/32847427/37723265-b8441610-2d0c-11e8-8238-ab27df829a13.png)

## Installing

### Gradle

![Maven-central](https://img.shields.io/maven-central/v/br.com.moip/java-sdk.svg)

Add the fallowing dependency to `build.gradle` in the project:

```gradle
compile group: 'br.com.moip', name: 'java-sdk', version: 'x.y.z'
```

### Maven

![Maven-central](https://img.shields.io/maven-central/v/br.com.moip/java-sdk.svg)

Add the fallowing dependency to `pom.xml` in the project:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>x.y.z</version>
</dependency>

```

## How to build

Is necessary to configure your ```gradle.properties``` with these informations:

```properties
artifactory_username=developer
artifactory_password=AP5xrUuUbJEha1sZCWpJqDABhwA
ossrhUsername= moip
ossrhPassword=rtg32oue@MOIP!

signing.keyId=FEBFADD1
signing.password=ittafer
signing.secretKeyRingFile=secring.gpg.enc
```

After this just to run:
```bash
./gradlew build
```

## How to deploy

Today the deploy is performed manually so you need to run:
```bash
./gradlew uploadArchives -PossrhUsername="${MVN_USERNAME}" -PossrhPassword="${MVN_PASSWORD}" -Psigning.keyId="${SIGNING_KEY_ID}" -Psigning.password="${SIGNING_PASSWORD}" -Psigning.secretKeyRingFile="${SIGNING_SECRET_KEY_RING_FILE}"
``` 

After to execute this command you can see the deploy into [Nexus](https://oss.sonatype.org/)

## Simple flow

This step by step will exemplify the integration flow with simple usage examples.

### 1. Setup
Before making requests to Moip API it's necessary make a **setup**, defining the environment and the authentication that will be used.

#### 1.1 Setting the authentication
There are two ways to authenticate the request, some endpoints require a "highest authorization level", it will depend on the endpoint and type of request.

#### By BasicAuth
The following set will generate a hash `Base64` with your Moip account **token** and **key** to authenticate.
```java
Authentication auth = new BasicAuth("TOKEN", "SECRET");
```

> :bulb: If you don't know how to get your **token** and **key**, click [here](https://conta-sandbox.moip.com.br/configurations/api_credentials) (you must be logged in).

#### By OAuth
The following set will create an OAuth authentication object.

> :bulb: Click [here](https://dev.moip.com.br/v2.0/reference#autenticacao-mp) to know how to get your token OAuth.

```java
Authentication auth = new OAuth("TOKEN_OAUTH");
```

#### 1.2 Client
After defining your authentication method, you have to set the **client** specifying the environment where you want to run your application. To set the client, choose the environment and pass the authentication (previously settled) as argument.

##### Sandbox
The test environment. You can use this to simulate all of your business scenarios.

```java
Client client = new Client(Client.SANDBOX, auth);
```

##### Production
**_"The environment of truth"_** :eyes:. This is the environment where the real transactions run.

```java
Client client = new Client(Client.PRODUCTION, auth);
```

> :bulb: Before going to production, you need to request homologation of your application [here](https://dev.moip.com.br/page/homologacao-api-v2).

#### 1.3 Instantiate API
To complete the setup, you have to create an API instance, passing the client (previously settled) as argument.

```java
API api = new API(client);
```

> :white_check_mark: Check the [setup functional example](https://github.com/moip/moip-sdk-java/tree/master/src/test/java/br/com/moip/examples/setup/Setup.java).

### 2. Create customer
With the setup created, you can make requests to Moip API. To start the basic e-commerce flow you need to create a customer. After all, it's whom will order your products or services.

```java
Customer customer = api.customer().create(new CustomerRequest()
    .ownId("CUS-" + System.currentTimeMillis())
    .fullname("Jose da Silva")
    .email("josedasilva@email.com")
    .birthdate(new ApiDateRequest().date(new Date()))
    .taxDocument(TaxDocumentRequest.cpf("22222222222"))
    .phone(new PhoneRequest().setAreaCode("11").setNumber("55443322"))
    .shippingAddressRequest(new ShippingAddressRequest()
        .street("Avenida Faria Lima")
        .streetNumber("3064")
        .complement("12 andar")
        .city("São Paulo")
        .state("SP")
        .district("Itaim")
        .country("BRA")
        .zipCode("01452-000")
    )
);
```
> [:white_check_mark:](https://github.com/moip/moip-sdk-java/tree/master/src/test/java/br/com/moip/examples/CustomerExamples.java) _Click on the icon for more customer functional examples._
> Read more about customer on [API reference](https://dev.moip.com.br/v2.0/reference#clientes-ec).

###  3. Create order
Customer created! It's buy time! :tada:

```java
Order createdOrder = api.order().create(new OrderRequest()
    .ownId("ORD-" + System.currentTimeMillis())
    .amount(new OrderAmountRequest()
        .currency("BRL")
        .subtotals(new SubtotalsRequest()
            .shipping(1000)
            .addition(100)
            .discount(500)
        )
    )
    .addItem("Nome do produto 1", 1, "Mais info...", 100)
    .addItem("Nome do produto 2", 2, "Mais info...", 200)
    .addItem("Nome do produto 3", 3, "Mais info...", 300)
    .customer(new CustomerRequest()
        .id("CUSTOMER_ID")
    )
    .addReceiver(new ReceiverRequest()
        .secondary("MOIP_ACCOUNT_ID", new AmountRequest().percentual(50), false)
    )
);
```
> [:white_check_mark:](https://github.com/moip/moip-sdk-java/tree/master/src/test/java/br/com/moip/examples/OrderExamples.java) _Click on the icon for more order functional examples._
> Read more about order on [API reference](https://dev.moip.com.br/v2.0/reference#pedidos-ec).

### 4. Create Payment
Alright! Do you have all you need? So, lets pay this order. :moneybag:

```java
Payment createdPayment = api.payment().create(new PaymentRequest()
    .orderId("ORDER_ID")
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
```
> [:white_check_mark:](https://github.com/moip/moip-sdk-java/tree/master/src/test/java/br/com/moip/examples/PaymentExamples.java) _Click on the icon for more payment functional examples._
> Read more about payment on [API reference](https://dev.moip.com.br/v2.0/reference#pagamentos-ec).

### Other examples
If you want to see other functional examples, check this folder. [:file_folder:](https://github.com/moip/moip-sdk-java/tree/master/src/test/java/br/com/moip/examples/)

## Exceptions treatment
| errors | cause | status |
| :---: | :---: | :---: |
| UnautorizedException | to authentication errors | == 401 |
| ValidationException | to validation errors | >= 400 && <= 499 (except 401) |
| UnexpectedException | to unexpected errors | >= 500 |

> :warning: To catch these errors, use the bellow treatment:

```java
try {
 Payment createdPayment = api.payment().create(
        //...
    );
} catch(UnauthorizedException e) {
  // StatusCode == 401
} catch(UnexpectedException e) {
  // StatusCode >= 500
} catch(ValidationException e) {
  // StatusCode entre 400 e 499 (exceto 401)
}
```

## Moip documentation

### Docs
To stay up to date about the **Moip Products**, check the [documentation](https://dev.moip.com.br/v2.0/docs).

### References
Read more about the **Moip APIs** in [API reference](https://dev.moip.com.br/v2.0/reference).

## Getting help
We offer many ways to contact us, so if you have a question, do not hesitate, talk to us whatever you need. For questions about API or business rules, contact us by [support](https://dev.moip.com.br/v2.0/) or [slack](https://slackin-cqtchmfquq.now.sh/):slack:. But, if you have a question or suggestion about the SDK, feel free to open an **issue** or **pull request**.

## Contributing
Do you have an enhancement suggest or found something to fix? Go ahead, help us and let your mark on Moip, open **pull requests** and **issues** against this project. If you want to do it, please read the `CONTRIBUTING.md` to be sure everyone follows the same structure and planning of the project. Remember, we :heart: contributions. :rocket: