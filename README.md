<img src="https://gist.githubusercontent.com/joaolucasl/00f53024cecf16410d5c3212aae92c17/raw/1789a2131ee389aeb44e3a9d5333f59cfeebc089/moip-icon.png" align="right" />

# Moip v2 Java SDK
> O jeito mais simples e rápido de integrar o Moip a sua aplicação Java

[![Build Status](https://travis-ci.org/moip/moip-sdk-java.svg?branch=master)](https://travis-ci.org/moip/moip-sdk-java)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/59c15b9d4e35440c8e1d2810c0509836)](https://www.codacy.com/app/rodrigo-saito/moip-sdk-java)

## Índice

- [Instalação](#instalação)

## Requisitos

Java `v1.7ˆ` ![java-cup](https://user-images.githubusercontent.com/32847427/37723265-b8441610-2d0c-11e8-8238-ab27df829a13.png)

## Instalação

### Gradle

![Maven-central](https://img.shields.io/maven-central/v/br.com.moip/java-sdk.svg)

Adicione a dependência ao `build.gradle` do projeto:

```gradle
compile group: 'br.com.moip', name: 'java-sdk', version: 'x.y.z'
```

### Maven

![Maven-central](https://img.shields.io/maven-central/v/br.com.moip/java-sdk.svg)

Adicione a dependência ao `pom.xml` do projeto:

```xml
<dependency>
    <groupId>br.com.moip</groupId>
    <artifactId>java-sdk</artifactId>
    <version>x.y.z</version>
</dependency>

```

## Fluxo

A seguir, o

## Setup

Antes de realizar requisições para a API do Moip, é necessário criar o **setup**, definindo o ambiente e a autenticação que serão utilizados.

### Configurando a autenticação

#### Autenticando por BasicAuth
```java
Authentication auth = new BasicAuth("TOKEN", "SECRET");
```
#### Autenticando por OAuth
```java
Authentication auth = new OAuth("TOKEN_OAUTH");
```

### Configurando o ambiente
Após definir o tipo de autenticação, é necessário gerar o client, informando em qual environment você quer executar suas ações.

#### Sandbox

```java
Client client = new Client(Client.SANDBOX, auth);
```

#### Produção

```java
Client client = new Client(Client.PRODUCTION, auth);
```

Agora você pode instanciar a Api:
```java
API api = new API(client);
```

Confira o exemplo funcional de configuração do [setup](https://github.com/moip/moip-sdk-java/tree/master/src/test/java/br/com/moip/examples/setup/Setup.java).

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
