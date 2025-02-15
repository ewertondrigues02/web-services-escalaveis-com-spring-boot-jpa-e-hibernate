# Sistema de Gerenciamento de Pedidos e Usuários

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para gerenciar pedidos e usuários. Ele permite a criação, leitura, atualização e exclusão de pedidos e usuários, e utiliza **JPA (Jakarta Persistence API)** para persistência de dados, com suporte a relacionamentos entre as entidades.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para o desenvolvimento de APIs RESTful.
- **Spring Data JPA**: Gerenciamento da persistência de dados.
- **H2 Database**: Banco de dados em memória utilizado durante o desenvolvimento (ou PostgreSQL/MySQL em produção).
- **JSON Web Tokens (JWT)**: Para autenticação de usuários (caso queira implementar segurança).
- **Jackson**: Para conversão entre objetos Java e JSON.
- **Lombok**: Para evitar boilerplate no código (se necessário).

## Estrutura do Projeto

O projeto é estruturado em duas principais funcionalidades:
- **Pedidos (Order)**: Gerencia os pedidos feitos pelos usuários.
- **Usuários (User)**: Gerencia o cadastro e manipulação de usuários.

### Entidades

1. **Pedido (Order)**: Representa um pedido feito por um usuário. Cada pedido pode conter múltiplos itens e pode ter um pagamento associado.
2. **Usuário (User)**: Representa um cliente que pode realizar pedidos.

### Endpoints da API

#### Endpoints de Pedidos

- **GET `/orders`**: Retorna todos os pedidos.
- **GET `/orders/{id}`**: Retorna um pedido específico pelo ID.
- **POST `/orders`**: Cria um novo pedido.
- **PUT `/orders/{id}`**: Atualiza um pedido existente.
- **DELETE `/orders/{id}`**: Deleta um pedido existente.

#### Endpoints de Usuários

- **GET `/users`**: Retorna todos os usuários.
- **GET `/users/{id}`**: Retorna um usuário específico pelo ID.
- **POST `/users`**: Cria um novo usuário.
- **PUT `/users/{id}`**: Atualiza um usuário existente.
- **DELETE `/users/{id}`**: Deleta um usuário existente.

## Exemplos de Uso

### Criar um Novo Pedido

**POST `/orders`**

```json
{
  "moment": "2025-02-01T10:15:30Z",
  "orderStatus": 1,
  "client": {
    "id": 1
  },
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

### Buscar um Pedido por ID

**GET `/orders/{id}`**

```json
{
  "id": 1,
  "moment": "2025-02-01T10:15:30Z",
  "orderStatus": 1,
  "client": {
    "id": 1
  },
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ],
  "total": 200.0
}
```

### Criar um Novo Usuário

**POST `/users`**

```json
{
  "name": "Ewerton Rodrigues",
  "email": "ewerton@example.com",
  "password": "password123"
}
```

## Como Rodar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/ewertondrigues02/sistema-de-gestao-de-vendas.git
```

2. Navegue até o diretório do projeto:

```bash
cd sistema-de-gestao-de-vendas
```

3. Execute o projeto

Se você estiver utilizando o Maven, execute o comando abaixo:

```bash
mvn spring-boot:run
```

Ou, se estiver usando o Gradle:

```bash
./gradlew bootRun
```

4. Acesse a API

A API estará disponível em [http://localhost:8080](http://localhost:8080). Você pode usar o Postman ou cURL para testar os endpoints descritos acima.

## Contribuições

Sinta-se à vontade para abrir um pull request para sugestões de melhorias ou correções. Fique à vontade para relatar problemas no Issue Tracker.

## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.
