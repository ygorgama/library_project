package ygorgama.edu.library_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ygorgama.edu.library_api.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
