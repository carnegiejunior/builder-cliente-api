<p align="center">
  <img src="readme_resources/client-cliente.jpg" width="150" title="API - Clientes">
</p>

<h1 align="center">API - CLIENTE</h1>

<img src="https://img.shields.io/badge/Version-1.0-brightgreen"/>

<p align="center">Trabalho apresentado à builders - MVP de uma API para cadastro de clientes</p>


<p align="right">
 Nesta API é possível criar, editar, listar e atualizar os dados por completo e também de forma granular de um cliente
 </p>
 
### Requisitos:

- [x] Permita criação de novos clientes;

- [x] Permita a atualização de clientes existentes;

- [x] Permita que seja possível listar os clientes de forma paginada;

- [x] Permita que buscas por atributos cadastrais do cliente;

- [x] É necessário também que cada elemento retornado pela api de clientes informe a idade;

### Observações:

<p align="left">
O projeto foi empacotado com Docker e orquestrado com o docker-compose;
 </p>

<p align="left">
O banco de dados utilizado foi o MySQL em sua versão 8. 
Dentro deste é carregado automaticamente uma massa de dados com 10 (dez) clientes ao inicializar o sistema através do flyway.
</p>

<p align="left">
O projeto está hospedado no hub.docker.com e poderá ser utilizado conforme instruções abaixo em COMO EXECUTAR.
</p>

### Como executar:
<p align="left">
O sistema poderá ser recompilado e executado através de seu código fonte aqui no GitHub ou baixado automaticamente atráves do repositório docker (hub.docker.com) do docker pelo docker-compose presente no diretório principal deste projeto
</p>

<p align="left">
Em caso de optar-se executar a API por intermédio do STS, deve-se executar primeiro: <b>docker container run -d -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes --name cliente-mysql mysql:8.0</b>
</p>

<p align="left">
Caso, direto pelo repositório, execute:
<strong>docker container run --rm -p 8080:8080 -e DB_HOST=cliente-mysql --network cliente-network carnegiejunior/cliente-api</strong>
para inicializar a aplicação através do docker compose. O parâmetro "--rm" deverá garantir que o container seja excluído após o término de seu uso
</p>

<p align="left">
Após a execução do comando acima, deverá ser possível acessar os endpoints através do postman.
</p>
<p align="left">
O arquivo com os endpoints já preparados estão no diretório raiz do projeto sob o nome postman.json, o qual poderá ser importado pelo respectivo aplicativo.
</p>

### Observações gerais:

<p align="left">
A API fora constituída da melhor forma dentro do DDD.
</p>
<br/>
<p align="left">
Comentários não foram incluídos dentro do fonte do sistema <i>visto não haver nada de difícil entendimento</i> como expressões regulares ou corolários como preceitua <b>Robert C. Martin</b> em seu livro <b>Código Limpo</b>.
Qualquer um que souber ler JAVA poderá entender o código perfeitamente de forma fluída.
</p>
<br/>
<p align="left">
Algumas validações não foram observadas. Apenas aquelas mais imporntantes como campos em branco, nulos ou inválidos como o caso do CPF.
</p>
<br/>
<p align="left">
O campo CPF foi desenvolvido para que fosse armazenado e consultado com sua formação. Ou seja, incluindo pontos e hífen.
</p>
<br/>
<p align="left">
Outros pontos não foram observados por não constar requisitos mais específicos. Sendo assim, optou-se por realizar sempre o mais simples para que, caso necessário, possa implementar-se de forma gradual e refatorada.
</p>

<br/>
<p align="left">
<b>Ressalto que as datas e horas foram mantidas no padrão UTC sem TIMEZONE</b><br/>
</p>

### Observações finais:
<br>
<p align="left">
<b>Por motivos de saúde familiares graves, não foi possível concluir o desabio como eu gostaria.</b> 
<br>
Costumo usar o <b>Restassure</b> para realizar testes de API, o <b>JUnit</b> para testes unitários e integração.
<br>
A documentação normalmente utilizo o <b>Swagger</b>
<br>
Para Entrega contínua, o <b>Jenkins</b> e companhia.
</p>
