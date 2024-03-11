# Projeto Java Spring SafeWay - Documentação

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- PostgreSQL
- Flyway (para migrações de banco de dados)
- Bean Validation (para validações de formulários)
- Spring Data JPA
- JavaMail Sender (para envio de e-mails)
- Mailtrap (para testar envios de e-mails em ambiente de desenvolvimento)


## Endpoints

`GET` /customer/{id}

Retorna os detalhes de um cliente com o `id` informado

**códigos de status**

`200` sucesso

`404` não encontrado

<br/>

`POST` /customer

Cadastra um novo cliente no sistema

**códigos de status**

`201` criado com sucesso

`400` validação falhou

**exemplo**
```js
{
	"email":"email@example.com",
	"firstName":"firstName",
	"lastName":"lastName",
	"password":"password",
	"cpf":"cpf" 
}
```
**observações**

- todos os campos são obrigatórios
- o cpf informado precisa ser um cpf válido
- o email informado precisa ser um email válido
- após a requisição ser concluída , a url para acessar os detalhes do objeto criado estará no cabeçalho Location 
  
<br/>

`GET` /company/{id}

Retorna os detalhes de uma empresa com o `id` informado

**códigos de status**

`200` sucesso

`404` não encontrado

<br/>

`POST` /company

Cadastra uma nova empresa no sistema.

**códigos de status**

`201` criado com sucesso

`400` validação falhou

**exemplo**
```js
{
	"email":"email@example.com",
	"firstName":"firstName",
	"lastName":"lastName",
	"password":"password",
	"cnpj":"cnpj",
	"fee":"0.10"
}
```
**observações**

- todos os campos são obrigatórios
- o cnpj informado precisa ser um cnpj válido
- o email informado precisa ser um email válido
- após a requisição ser concluída , a url para acessar os detalhes do objeto criado estará no cabeçalho Location
- o valor mínimo para o campo fee (taxa) é 0.01 (1%) e o valor máximo é 1 (100%)  
  
<br/>

`GET` /transaction/{id}

Retorna os detalhes de uma transação com o `id` informado

**códigos de status**

`200` sucesso

`404` não encontrado

<br/>

`POST` /transaction

realiza uma nova transação no sistema.

**códigos de status**

`201` criado com sucesso

`400` validação falhou

**exemplo**
```js
{
	"company_id":"uuid",
	"customer_id":"uuid",
	"value":111,
	"transactionType":"type"
}
```
**observações**

- todos os campos são obrigatórios
- após a requisição ser concluída , a url para acessar os detalhes do objeto criado estará no cabeçalho Location
- os valores aceitos no campo "transactionType" são apenas : WITHDRAW ou DEPOSIT

  
<br/>
