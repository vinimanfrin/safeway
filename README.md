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

## Configuração da Aplicação

Para rodar a aplicação corretamente, siga os passos abaixo:

1. **Requisitos de Sistema**:
   - Certifique-se de ter o Java 17 instalado em sua máquina.
   - Garanta que o PostgreSQL esteja instalado e em execução.

2. **Configurações no arquivo application.properties**:
   - Abra o arquivo `src/main/resources/application.properties`.
   - Configure as seguintes propriedades relacionadas ao banco de dados:
     ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.format_sql=true
     ```

3. **Configurações do Webhook**:
   - Para obter o atributo `webhook.url`, acesse o site [webhook.site](https://webhook.site/).
   - Copie a propriedade "Your unique URL" e cole-a no campo `webhook.url` do arquivo `application.properties`.

4. **Configurações do E-mail**:
   - Se quiser receber o email, são necessárias as propriedades do e-mail. Se cadastre o MailTrap e cole suas credenciais :
      ```
     spring.mail.host=
     spring.mail.port=
     spring.mail.username=
     spring.mail.password=
     spring.mail.properties.mail.smtp.auth=true
     spring.mail.properties.mail.smtp.starttls.enable=true
     ```

   ![Configurações do E-mail](caminho/para/imagem.png)

5. **Criação do Schema no Banco de Dados**:
   - Crie um novo schema no seu banco de dados PostgreSQL.
   - Atualize a propriedade `spring.datasource.url` com a URL correta do seu banco de dados e o nome do schema criado.

6. **Execução da Aplicação**:
   - Após configurar todas as propriedades necessárias, execute a aplicação.
   - A aplicação será iniciada em `http://localhost:8080`.

Certifique-se de que todas as configurações estão corretas antes de iniciar a aplicação.
