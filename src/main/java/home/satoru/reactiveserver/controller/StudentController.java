package home.satoru.reactiveserver.controller;

import home.satoru.reactiveserver.model.Student;
import home.satoru.reactiveserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/student")
    public Mono<Student> save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/students")
    public Flux<Student> fetchAll(){
        return studentService.fetchAll();
    }

    @GetMapping("/student/{id}")
    public Mono<Student> fetchById(@PathVariable Long id){
        return studentService.fetchById(id);
    }

    @PutMapping("/student/{id}")
    public Mono<Student> update(@RequestBody Student student, @PathVariable Long id){
        return studentService.update(student, id);
    }

    @DeleteMapping("/student/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return studentService.delete(id);
    }

    @DeleteMapping("/student")
    public Mono<Void> deleteAll(){
        return studentService.deleteAll();
    }
}
