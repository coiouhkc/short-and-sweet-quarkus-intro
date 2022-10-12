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

---

# Demo

## Native build

---

# Demo

## Test resources

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
