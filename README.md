<h1 align="center">
  Payment Microservice
</h1>

## Objetivo do projeto
- Aplicar na prática os conceitos de microsserviços, explorando comunicação assíncrona entre serviços com RabbitMQ, utilizando Spring Boot e Docker.

## Descrição
- Microserviço de Cadastro de Produtos: Responsável pelo cadastro de novos produtos enviados pelos usuários. Ao cadastrar um produto, é possível iniciar o processo de pagamento associado.
- Microserviço de Pagamento: Ao receber uma solicitação de pagamento, este serviço processa a requisição de forma assíncrona e retorna uma resposta aleatória, simulando um pagamento com sucesso ou falha. O resultado do pagamento é então tratado e exibido no console com mensagens específicas para cada situação.

## Tecnologias
- Java
- Spring Boot
- RabbitMQ
- Docker

## Autor
- Projeto desenvolvido por [Isabel Henrique](https://www.linkedin.com/in/isabel-henrique/)
