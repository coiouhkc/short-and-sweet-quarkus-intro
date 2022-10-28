---

# Short and sweet

## Intro to Quarkus

##### 10 things I like about quarkus [^1]

[^1]: other modern also frameworks tend to get better (Micronaut, Helidon)

---

# Intro, reason & background

## A brief history of (my experience) time

Deploying/testing new code version requires rebuild of whole application which (depending on the application size) might take from 1 coffee to a 3-course dinner.

* Tomcat/ OSGi
* Grails (slow reload)
* Play! Framework on Java (awesome!)
* Weblogic (project build and redeploy time >30 mins)
* Spring Boot (live reload + devtools had to be added)
* Payara

and finally

* Quarkus (reload on next request)

---

# Demo

## Init using command-line

`quarkus create app org.abratuhi.quarkus:demo`

---

# Demo

## Live reload

* application.properties
* endpoint (resource, controller)

Note: on explicit endpoint call

---

# Demo

## Docker & Kubernetes

* Docker

`quarkus extension add 'container-image-jib'`

`mvn clean package`

* Kubernetes

`quarkus extension add 'kubernetes'`

`kubectl apply -f target/kubernetes/kubernetes.yml`

`kubectl port-forward svc/demo 9090:80`

`curl localhost:9090/hello -o -`
`kubectl delete -f target/kubernetes/kubernetes.yml`

---

# Demo

## Remote Dev

* copy `kubernetes.yml` from `target/kubernetes` to `src/main/kubernetes`

* add

```
- name: QUARKUS_LAUNCH_DEVMODE
  value: "true"
```

to `Deployment.spec.template.spec.containers.spec.env`

`kubectl apply -f src/main/kubernetes/kubernetes.yml`

`kubectl port-forward svc/demo 9090:80`

`mvn quarkus:remote-dev`


Note: do not use in production!

---

# Demo

## Reactive messaging

MQTT -> Kafka with 2 annotations (and a bit of magic)

`quarkus extension add 'quarkus-smallrye-reactive-messaging-mqtt'`

`quarkus extension add 'quarkus-smallrye-reactive-messaging-kafka'`

---

# Demo

## Native build

`mvn package -Pnative`

bratuhia/demo                              1.0.0-SNAPSHOT   d20adb5f0f44   About an hour ago   379MB
vs
bratuhia/demo                              1.0.0-SNAPSHOT   259f4e99bb9b   46 seconds ago   71.1MB

---

# Demo

## Dev Services

* JPA + Postgres

See https://quarkus.io/guides/dev-services
See https://quarkus.io/guides/hibernate-reactive-panache

---

# Demo

## Testing

* Continuous testing (press 'r')
* Test resources
* Test profiles
* And much more!
  * Database-rider?

See https://quarkus.io/guides/getting-started-testing

---

# Demo

## Dev UI

See http://localhost:8080/q/dev/
---

# Further reading

* https://quarkus.io/guides/
* https://www.youtube.com/c/Quarkusio/videos
* https://quarkus.io/guides/virtual-threads (since we were talking about it recently)
* https://github.com/cescoffier and other https://github.com/quarkusio/quarkus/graphs/contributors (multiple Java champions)
* https://www.reactiveprinciples.org/
* https://microservices.io/
* https://smallrye.io/smallrye-reactive-messaging

---

# Q&A

---
