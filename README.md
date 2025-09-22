Grupo:
Leonardo Mansur RM551659
Gabriel Oliveira RM98565
Gabriel Riqueto RM98685
João Pedro de Souza Vieira RM99805

# 🧑‍💻 XP Smart Advisor

O **XP Smart Advisor** é uma aplicação desenvolvida em **Spring Boot** que simula um assessor virtual inteligente de investimentos.  
O sistema gerencia clientes e seus perfis de investimento, permitindo cadastro, consulta, atualização e exclusão de informações, integrando com **MySQL** e utilizando autenticação básica para segurança.

---

## ⚙️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
  - Spring Security (HTTP Basic Auth)
- **MySQL 8**
- **Maven**
- **Postman** (para testes de API)

---

## 🚀 Configuração e Execução

### 1. Clonar o projeto
```bash
git clone https://github.com/seu-repositorio/xp-smart-advisor.git
cd xp-smart-advisor
```

### 2. Criar banco de dados no MySQL
```sql
CREATE DATABASE xp_smart_advisor;
```

### 3. Configurar `application.properties`
No arquivo `src/main/resources/application.properties`, ajuste conforme seu ambiente:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/xp_smart_advisor?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=fiap
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

spring.security.user.name=admin
spring.security.user.password=123
```

### 4. Compilar e executar o projeto
```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:
```
http://localhost:8080
```

---

## 📌 Exemplos de Requisição e Resposta

### 🔑 Autenticação
Todas as requisições exigem **Basic Auth**:  
```
username: admin
password: 123
```

---

### ➕ Criar Cliente
**POST** `http://localhost:8080/clientes`  
Body (JSON):
```json
{
  "nome": "Roberto Silva",
  "cpf": "11122233344",
  "profissao": "Engenheiro",
  "endereco": {
    "logradouro": "Rua das Flores",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01010000",
    "pais": "Brasil",
    "complemento": "Apto 101"
  },
  "email": "roberto@email.com",
  "telefone": "11999999999",
  "dataNascimento": "1990-01-01",
  "objetivoInvestimento": "LONGO_PRAZO",
  "preferenciaInvestimentos": "RENDA_FIXA",
  "banco": "Banco do Brasil",
  "agencia": "1234",
  "numeroConta": "56789-0",
  "tipoConta": "CORRENTE",
  "titularConta": "Roberto Silva",
  "rendaMensal": 10000,
  "patrimonioLiquido": 50000,
  "nacionalidade": "BR",
  "experienciaInvestimentos": "Intermediário",
  "perfilInvestidor": "MODERADO",
  "ativo": true
}
```

Resposta:
```json
{
  "id": 1,
  "nome": "Roberto Silva",
  "cpf": "11122233344",
  "email": "roberto@email.com",
  "objetivoInvestimento": "LONGO_PRAZO",
  "perfilInvestidor": "MODERADO",
  "ativo": true
}
```

---

### 📋 Listar Clientes
**GET** `http://localhost:8080/clientes`  

Resposta:
```json
[
  {
    "id": 1,
    "nome": "Roberto Silva",
    "cpf": "11122233344",
    "email": "roberto@email.com"
  }
]
```

---

### 🔍 Buscar Cliente por ID
**GET** `http://localhost:8080/clientes/1`

Resposta:
```json
{
  "id": 1,
  "nome": "Roberto Silva",
  "cpf": "11122233344",
  "profissao": "Engenheiro",
  "email": "roberto@email.com"
}
```

---

### ✏️ Atualizar Cliente
**PUT** `http://localhost:8080/clientes/1`  
Body:
```json
{
  "telefone": "11988888888",
  "rendaMensal": 12000
}
```

Resposta:
```json
{
  "id": 1,
  "nome": "Roberto Silva",
  "telefone": "11988888888",
  "rendaMensal": 12000
}
```

---

### ❌ Excluir Cliente
**DELETE** `http://localhost:8080/clientes/1`  

Resposta:
```json
{
  "mensagem": "Cliente removido com sucesso!"
}
```

---

## ✅ Próximos Passos
- Criar testes automatizados com **JUnit + MockMvc**.  
- Implementar autenticação **JWT** para substituir Basic Auth.  
- Deploy em nuvem (Heroku, AWS, GCP ou Azure).  

---
👨‍💻 Desenvolvido como parte do projeto acadêmico de Engenharia de Software - FIAP
