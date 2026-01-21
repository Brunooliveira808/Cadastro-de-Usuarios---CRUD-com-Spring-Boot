# 📌 Cadastro de Usuários - CRUD com Spring Boot

Projeto **CRUD de Cadastro de Usuários** desenvolvido com **Spring Boot**, seguindo uma arquitetura simples e organizada, utilizando **Spring Data JPA** e **MySQL** para persistência de dados.

Este projeto tem como objetivo demonstrar boas práticas iniciais no desenvolvimento de APIs REST com Spring Boot, incluindo camadas bem definidas, integração com banco de dados e operações básicas de CRUD.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 4.0.1**
* **Spring Web**
* **Spring Data JPA**
* **MySQL**
* **Maven**
* **Hibernate**
* **Lombok**

---

## 🧱 Arquitetura do Projeto

O projeto está organizado em camadas para melhor manutenção e legibilidade:

```
com.bruno.cadastro_usuario
├── controller
│   └── UsuarioController.java
├── business
│   └── UsuarioService.java
├── infrastructure
│   ├── entities
│   │   └── Usuario.java
│   └── repository
│       └── UsuarioRepository.java
└── CadastroUsuarioApplication.java
```

* **Controller**: Responsável por expor os endpoints da API
* **Service**: Contém a lógica de negócio
* **Repository**: Interface de acesso ao banco de dados
* **Entity**: Representação da tabela no banco de dados

---

## 📋 Funcionalidades

✔ Criar usuário
✔ Buscar usuário por EMAIL
✔ Atualizar usuário por ID
✔ Deletar usuário por EMAIL

---

## 🔗 Endpoints da API

### 📌 Operações por ID

| Método | Endpoint                                                       | Descrição                |
| ------ | -------------------------------------------------------------- | ------------------------ |
| PUT    | //usuario?id=3   &   Body (JSON): {"email": "mailto@email.com"}| Atualizar usuário por ID    |

📌 **Exemplo de PUT por ID**

```
PUT http://localhost:8080/usuario?id=3
```

**Body (JSON):**

```json
{
  "email": "mailto@email.com"
}
```

---

### 📧 Operações por E-mail

Além do ID, o sistema também permite realizar operações utilizando o **e-mail do usuário** como parâmetro de consulta (**query parameter**).

| Método | Endpoint                                                                    | Descrição                    |
| ------ | --------------------------------------------------------------------------- | ---------------------------- |
| GET    | /usuarios?email=[usuario@email.com](mailto:usuario@email.com)               | Buscar usuário por e-mail    |
| POST   | /usuarios   &   Body (JSON): {"email" : "mailto@email.com", "nome" : "mailto"}| Adicionar usuário |
| DELETE | /usuarios?email=[usuario@email.com](mailto:usuario@email.com)               | Deletar usuário por e-mail   |

📌 **Exemplo de POST**

```
PUT http://localhost:8080/usuario
```

**Body (JSON):**

```json
{
"email" : "mailto@email.com",
"nome" : "mailto"
}
```

📌 **Observação:** O e-mail é passado como *query parameter*, seguindo o padrão:

```
/usuarios?email=exemplo@email.com
```

---

## 🛠️ Configuração do Banco de Dados

O projeto utiliza **MySQL**. Certifique-se de que o banco esteja criado antes de rodar a aplicação.

```sql
CREATE DATABASE cadastroUsuario;
```

### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cadastroUsuario
spring.datasource.username=root
spring.datasource.password=SUASENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

server.port=8080
```

⚠️ **Importante:** Altere usuário e senha conforme sua configuração local.

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

* Java 17 ou superior
* Maven
* MySQL

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/cadastro-usuario.git

# Acesse o projeto
cd cadastro-usuario

# Execute o projeto
mvn spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🧪 Testes

O projeto possui estrutura básica para testes com **Spring Boot Test**.

Para executar:

```bash
mvn test
```

---

## 📌 Possíveis Melhorias Futuras

* Validações com Bean Validation
* DTOs para requisições e respostas
* Paginação e ordenação
* Tratamento global de exceções
* Autenticação e autorização com Spring Security
* Documentação com Swagger / OpenAPI

---

## 👨‍💻 Autor

**Bruno**
Projeto desenvolvido para fins de aprendizado e portfólio.

---

## 📄 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para utilizar e modificar.

---

⭐ Se este projeto te ajudou, não esqueça de deixar uma estrela no repositório!
