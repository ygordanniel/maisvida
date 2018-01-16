#!/bin/sh

set -e

# Perform all actions as $POSTGRES_USER
export PGUSER="postgres"

# Create the 'template_postgis' template db
psql <<- 'EOSQL'
CREATE DATABASE maisvida TEMPLATE=template_postgis;
EOSQL

psql --dbname="maisvida" <<- 'EOSQL'
CREATE SCHEMA IF NOT EXISTS maisvida;
EOSQL
