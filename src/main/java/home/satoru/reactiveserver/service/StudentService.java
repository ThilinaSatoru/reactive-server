package home.satoru.reactiveserver.service;

import home.satoru.reactiveserver.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Mono<Student> save(Student student);

    Flux<Student> fetchAll();

    Mono<Student> fetchById(Long id);

    Mono<Student> update(Student student, Long id);

    Mono<Void> delete(Long id);

    Mono<Void> deleteAll();
}
