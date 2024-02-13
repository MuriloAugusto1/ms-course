package io.github.muriloaugusto1.repositories;

import io.github.muriloaugusto1.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
