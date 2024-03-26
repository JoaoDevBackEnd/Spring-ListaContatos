
# LISTA DE CONTATOS JAVA SPRING

Um CRUD Lista de Contatos criado como projeto pessoal, que tem a finalidade de mostrar as operações básicas do protocolo HTTP, e fazer os tratamentos de erros de Exceções.

## TECNOLOGIAS 

 - JAVA MAVEN
 - SPRING BOOT
 - SPRING DATA JPA
 - SPRING MVC
 - SPRING DOC OPENAI
 - SQL
 - JSON


## Práticas Abordadas
- API REST
- Consulta com Banco de Dados Spring DATA JPA
- Tratamento de Erros e Exceção 
- Criação automática de SWAGGER
- Conexão com Banco de dados
## Instalação

Para testar Clone o projeto em um diretório desejado e copie seu endereço
- Navegue até o CD do seu Diretório e execute o seguinte comando

```bash
  git clone https://github.com/JoaoDevBackEnd/Spring-ListaContatos.git
```
- O Banco de dados utilizado é o H2 que é por padrão Java então não a necessidade de configurar o arquivo  application.properties

- Teste a aplicação executando esse comando no Diretório
```bash
  mvn spring-boot:run

```
OBS: Pode se utilizar o Postman,Insomina ou navegar via Swagger (http://localhost:8080/swagger-ui/index.html)
## Documentação da API

#### GET 
Retorna uma busca com base no valor fornecido informar o DTO, qualquer tipo de valor informado é procurado na Query

```http
  GET http://localhost:8080/Procurar
```
- Exemplo JSON: 
```http
    {
	    "procurar":"João"
    }
```
#### POST 

Cria um novo Contato, essa função tem seus campos válidados onde não pode ter números ou email iguais já existante no banco de dados e campos como DDD,Nome,Telefone não pode ser nulos e se o campo email for preenchido ele é válido via Dependência do Apache Commons

```http
  POST http://localhost:8080/Cadastrar
```

- Exemplo JSON: 
```http
    {
        "nome": "String",
        "ddd": "String",
        "numero": "String",
        "email": "String"
    }
```
#### PUT 

Atualiza campos do  contato é requerido uma busca pelo ID  {323}, depois de fornecido fazer uma requição JSON, os campos são válidos para não ter números ou email, iguais cadastrados no banco caso tenha retorna um erro de exceção 

```http
  PUT http://localhost:8080/{id}
```

- Exemplo JSON: 
```http
    {
        "nome": "String",
        "ddd": "String",
        "numero": "String",
        "email": "String"
    }
```
#### DELETE 

Deleta um contato fornecido pelo paramêtro ID na URL {323}

```http
  DELETE http://localhost:8080/281
```



