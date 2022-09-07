### docker

docker build -t askyclear/user-service:1.0 .

docker run -d --network ecommerce-network \
-e "spring.cloud.config.uri=http://config-service:8888" \
-e "spring.rabbitmq.host=rabbitmq" \
-e "spring.zipkin.base-url=http://zipkin:9411" \
-e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" \
-e "logging.file=/api-logs/users-ws.log" \
-e "spring.datasource.url=jdbc:mariadb://mariadb:3306/mydb" \
--name user-service askyclear/user-service:1.0