package home.satoru.reactiveserver.service.impl;

import home.satoru.reactiveserver.model.Student;
import home.satoru.reactiveserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class StudentService implements home.satoru.reactiveserver.service.StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Flux<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Override
    public Mono<Student> fetchById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Mono<Student> update(Student student, Long id) {
        return studentRepository.findById(id).map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(opt -> {
                    if(opt.isPresent()){
                        student.setId(id);
                        return studentRepository.save(student);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return studentRepository.deleteAll();
    }
}
