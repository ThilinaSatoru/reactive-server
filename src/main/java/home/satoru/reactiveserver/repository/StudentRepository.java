package home.satoru.reactiveserver.repository;

import home.satoru.reactiveserver.model.Student;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends R2dbcRepository<Student, Long> {
}
