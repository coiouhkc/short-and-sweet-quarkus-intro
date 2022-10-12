---

# Short and sweet

## Intro to Quarkus

---

# Intro, reason & background

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

## Continuous test execution

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

---

# Demo

## Remote Dev

---

# Demo

## Reactive messaging

---

# Demo

## Native build

---

# Demo

## Test resources

---

# Demo

## Dev UI
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
