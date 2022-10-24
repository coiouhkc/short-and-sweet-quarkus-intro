package org.abratuhi.quarkus;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TodoRepository implements PanacheRepository<Todo> {
}
