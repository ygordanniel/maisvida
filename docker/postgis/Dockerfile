FROM mdillon/postgis:9.4
ENV POSTGRES_PASSWORD="DnkwKnRkka8x9hQ5A57t"
ADD dbinit.sh /
RUN cat /dbinit.sh >> /docker-entrypoint-initdb.d/postgis.sh