#!/bin/bash
CMD=$1

docker-compose -p testing -f ./docker-compose.yml $CMD