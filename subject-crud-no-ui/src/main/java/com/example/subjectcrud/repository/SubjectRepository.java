package com.example.subjectcrud.repository;

import com.example.subjectcrud.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
