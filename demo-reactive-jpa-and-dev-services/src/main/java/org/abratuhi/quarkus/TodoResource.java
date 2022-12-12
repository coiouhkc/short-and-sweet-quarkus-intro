package org.abratuhi.quarkus;

import io.smallrye.mutiny.Uni;
import lombok.extern.jbosslog.JBossLog;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@JBossLog
@Path("/todo")
public class TodoResource {

    @Inject
    TodoRepository todoRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<List<String>> getAll() {
       Uni<List<Todo>> todos = todoRepository.listAll();

       log.info("'Fetched' todos"); // <---- comes before Hibernate log

       return todos.map(it ->
                        it.stream()
                                .map(Todo::getText)
                                .collect(Collectors.toList())
                );
    }
}
