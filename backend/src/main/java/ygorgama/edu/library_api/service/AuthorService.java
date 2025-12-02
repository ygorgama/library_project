package ygorgama.edu.library_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgama.edu.library_api.exception.NotFoundException;
import ygorgama.edu.library_api.model.Author;
import ygorgama.edu.library_api.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author findById(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Author not found"));
    }

    public Author create(Author author){
        return authorRepository.save(author);
    }

    public Author update(Author author){
        Author entity = authorRepository.findById(author.getId())
                .orElseThrow(() -> new NotFoundException("Author not found"));

        entity.setFirstName(author.getFirstName());
        entity.setLastName(author.getLastName());

        return entity;
    }

    public void delete(Long id){
        Author entity = authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Author not found")
        );

        authorRepository.delete(entity);
    }

}
