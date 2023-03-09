# Kafka
```
docker exec -ti docker-compose_kafka_1 /bin/bash
kafka-console-consumer --bootstrap-server localhost:9092 --topic string-out
```
# MQTT
```
docker exec -ti docker-compose_mosquitto_1 /bin/sh
mosquitto_pub -t string-in -m hello
```