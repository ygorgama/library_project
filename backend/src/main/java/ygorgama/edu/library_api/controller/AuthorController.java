package ygorgama.edu.library_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import ygorgama.edu.library_api.dto.AuthorDTO;
import ygorgama.edu.library_api.mapper.AuthorMapper;
import ygorgama.edu.library_api.model.Author;
import ygorgama.edu.library_api.service.AuthorService;

import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @GetMapping
    public List<AuthorDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDTO find(@PathVariable Long id){
        logger.info("Find author by ID");
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO author){
        AuthorDTO authorCreated = service.create(author);
        URI authorURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(authorCreated.getId()).toUri();
        return ResponseEntity.created(authorURI).body(authorCreated);
    }

    @PutMapping
    public  ResponseEntity<AuthorDTO> update(@RequestBody AuthorDTO author)
    {
        AuthorDTO authorUpdated = service.update(author);

        return ResponseEntity.ok().body(authorUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
