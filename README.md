# Uso básico

### Backend

O sistema usa um banco de dados [PostgreSQL](https://www.postgresql.org/) e já tem um container `Docker` com `Docker Compose` para subir um container do banco com a estrutura necessária.
Para subir o `Docker Compose` basta executar os comandos:

	1. `cd /docker/postgis`
	2. `sudo docker-compose up`

O sistema também ultiliza [Liquibase](http://www.liquibase.org/) para o controle do banco de dados. As `changelogs` estão em `/codigo-fonte/servico/src/main/resources/db/`.

Caso opte por não utilizar de deve-se alterar as configurações no `application.properties` e também nos `changelogs` para adaptação do banco escolhido.
