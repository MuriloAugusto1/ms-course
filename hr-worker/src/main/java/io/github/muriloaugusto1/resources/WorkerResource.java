package io.github.muriloaugusto1.resources;

import io.github.muriloaugusto1.entities.Worker;
import io.github.muriloaugusto1.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    private final WorkerRepository workerRepository;
    private final Environment env;

    public WorkerResource(WorkerRepository workerRepository, Environment env) {
        this.workerRepository = workerRepository;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No data!"));
        return ResponseEntity.ok(worker);
    }
}
