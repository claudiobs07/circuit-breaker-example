# Circuit Breaker Example

Exemplos simples de utilização de Spring Boot com o Padrão Circuit Breaker

Projeto possui os seguintes modulos:

* simple
* histrix-dashboard
* simple-retry

### simple
Utiliza Hystrix como implementação do Padrão Circuit Breaker 

Para rodar a aplicação, execute o comando:

`./mvnw spring-boot:run -pl simple`

Quando o sistema estiver UP, execute a chamada:

`curl -X GET http://localhost:8000/boom`

Como resultado:
- receberá `1` se não entrou no fallback
- receberá `2` se entrou no fallback

Obs: execute a chamada quantas vezes for necessária para observar os resultados.

Para verificar as métricas do Hystrix, utilize o comando:

`curl -X GET http://localhost:8000/actuator/hystrix.stream`

### histrix-dashboard
Utiliza Hystrix Dashboard que é um recurso do Hystrix que permite visualizar as métricas de forma mais eficiente.

Para rodar a aplicação, execute:

`./mvnw spring-boot:run -pl histrix-dashboard`

Abra o navegador, e acesse a url:

`http://localhost:8010/hystrix`

A seguinte pagina irá aparecer

<img src="https://i.stack.imgur.com/tcQ7I.png" width="500">

Insira a url de métricas do Histrix da aplicação (`http://localhost:8000/actuator/hystrix.stream`), e aperte `Monitor Stream`.<br>
OBS: Garanta que a aplicação `simple` esteja executando

Abrirá uma tela com gráficos e métricas da aplicação.

### simple-retry
Utiliza Spring Retry

Para rodar a aplicação, execute:

`./mvnw spring-boot:run -pl simple-retry`

Quando o sistema estiver UP, execute a chamada:

`http://localhost:8020/boom`

Como resultado:
- receberá `1` se não entrou no fallback
- receberá `2` se entrou no fallback
