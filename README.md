# lab3

### requirements
- docker
- docker-compose

### run application
- Clone project from git
- Enter project directory: `cd java-microservices`
- Build and run project with docker-compose:
  - one instance: `docker-compose up --build`
  - two instances: `docker-compose up --build --scale service=2`

### services
- Eureka Server: `http://localhost:8761`  
- Config Server: `http://localhost:8888`  
- Service (instance 1): `http://localhost:8081`  
- Service (instance 2): `http://localhost:8082`  
- Api-gateway: `http://localhost:8080`  
