## API para pagamento de contas

Este projeto foi desenvolvido para gerenciar o pagamento de contas, permitindo registrar novas contas e listar todas as contas salvas no banco de dados.

## Tecnologias Utilizadas

- **Java com Spring Boot**
- **Flyway**
- **JUnit 5**
- **Gradle**
- **MySQL 8.0**
- **Java 8**
- **JPA**
- **Swagger**

## Endpoints

### 1. Registrar uma Nova Conta

**POST** `/contas/incluirConta`

Registra uma nova conta para realização do pagamento.

#### Exemplo de Request:

```json
{
  "dataPagamento": "2020-04-13",
  "dataVencimento": "2020-04-02",
  "nome": "eu",
  "valorOriginal": 90
}
```

### 2. Listar Todas as Contas

**GET** `/contas/listaContas`

Lista todas as contas salvas no banco de dados.

#### Exemplo de Response:

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
