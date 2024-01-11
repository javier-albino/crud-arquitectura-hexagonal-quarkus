#!/bin/sh
echo $1
docker build -f src/main/docker/Dockerfile.native -t registry.gitlab.com/bice_vida/rentasvitalicias/renta-privada/microservicios/ms-liquidaciones-rentaprivada:latest -t registry.gitlab.com/bice_vida/rentasvitalicias/renta-privada/microservicios/ms-liquidaciones-rentaprivada:$1 .
docker push registry.gitlab.com/bice_vida/rentasvitalicias/renta-privada/microservicios/ms-liquidaciones-rentaprivada:latest
docker push registry.gitlab.com/bice_vida/rentasvitalicias/renta-privada/microservicios/ms-liquidaciones-rentaprivada:$1
