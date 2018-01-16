FROM mdillon/postgis:9.4
ENV POSTGRES_PASSWORD="DnkwKnRkka8x9hQ5A57t"
ADD mpoginit.sh /
RUN cat /mpoginit.sh >> /docker-entrypoint-initdb.d/postgis.sh