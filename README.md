# Uso básico

### Backend

O sistema usa um banco de dados [PostgreSQL](https://www.postgresql.org/) e já tem um container [Docker](https://www.docker.com/) com [Docker Compose](https://docs.docker.com/compose/) para subir um container do banco com a estrutura necessária.
Para subir o `Docker Compose` basta executar os comandos:

	cd /docker/postgis
	sudo docker-compose up

O sistema também ultiliza [Liquibase](http://www.liquibase.org/) para o controle do banco de dados. As `changelogs` estão em `/codigo-fonte/servico/src/main/resources/db/`.

Caso opte por não utilizar de deve-se alterar as configurações no `application.properties` e também nos `changelogs` para adaptação do banco escolhido.

A aplicação foi ultiliza [Spring Boot](https://projects.spring.io/spring-boot/) e para subi-la basta executar o comandos:

	cd /codigo-fonte/servico
	mvn spring-boot:run

### Frontend

A parte do cliente foi feita em [Ionic 3](https://ionicframework.com/) e para subir o cliente basta executar os comandos:

	npm i
	ionic serve

Caso não tenha o [NPM](https://www.npmjs.com/get-npm?utm_source=house&utm_medium=homepage&utm_campaign=free%20orgs&utm_term=Install%20npm) ou [Ionic CLI](https://ionicframework.com/getting-started) clique nos links para instalar.
