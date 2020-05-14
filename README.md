# java-microservices
## lab #5

### requirements
- docker
- docker-compose

### run application
- Clone project from git
- Enter project directory: `cd java-microservices`
- Build and run project with docker-compose:
  - one instance: `docker-compose up --build`
  - two instances: `docker-compose up --build --scale service=2`
  - stop container: `docker stop <container-name/container-id>`
  - run stoped container: `docker start <container-name/container-id>`
  - grafana default credentials: admin/admin
- Additional information:
  - `dashboard.json` is at the root of the project
  - configurations in config server are stored in `/configurations` folder


### services
- Eureka Server: `http://localhost:8761`  
- Config Server: `http://localhost:8888`  
- Service (instance 1): `http://localhost:8081`  
- Service (instance 2): `http://localhost:8082`  
- Api-gateway: `http://localhost:8080`  
- Grafana UI: `http://localhost:3000`  
- Kafka-consumer: `http://localhost:8088`  
