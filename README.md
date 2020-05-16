## API para pagamento de contas

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java com Spring Boot
- Flyway
- Junit5
- Gradle
- MySQL 8.0
- Java8
- JPA
- Swagger

#### EndPoints:

**POST ->** */contas/incluirConta:* Registra uma nova conta para realização do pagamento.

**Exemplo de request:**

```json
{
  "dataPagamento": "2020-04-13",
  "dataVencimento": "2020-04-02",
  "nome": "eu",
  "valorOriginal": 90
}
```

**GET ->** */contas/listaContas:* Lista todas as contas salvas do banco.

**Exemplo de Response:**

```json
[
  {
    "idConta": 1,
    "nome": "eu",
    "valorOriginal": 90,
    "valorCorrigido": 97.47,
    "dataVencimento": [
      2020,
      4,
      2
    ],
    "dataPagamento": [
      2020,
      4,
      13
    ],
    "diasAtraso": 11
  }
]
```

### Swagger:

`http://localhost:8080/swagger-ui.html#/
`
