package com.example.subjectcrud.controller;

import com.example.subjectcrud.model.Subject;
import com.example.subjectcrud.repository.SubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectRepository repo;

    public SubjectController(SubjectRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Subject create(@RequestBody Subject s) {
        return repo.save(s);
    }

    @GetMapping
    public List<Subject> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Subject one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject s) {
        Subject db = repo.findById(id).orElseThrow();
        db.setCode(s.getCode());
        db.setName(s.getName());
        return repo.save(db);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
