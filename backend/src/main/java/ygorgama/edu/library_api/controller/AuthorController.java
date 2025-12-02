package ygorgama.edu.library_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import ygorgama.edu.library_api.model.Author;
import ygorgama.edu.library_api.service.AuthorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping
    public List<Author> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Author find(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author){
        Author entity = service.create(author);
        URI authorURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(authorURI).body(entity);
    }

    @PutMapping
    public  ResponseEntity<Author> update(@RequestBody Author author)
    {
        Author entity = service.update(author);

        URI authorURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
