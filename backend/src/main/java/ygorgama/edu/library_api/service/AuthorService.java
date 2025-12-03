package ygorgama.edu.library_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ygorgama.edu.library_api.dto.AuthorDTO;
import ygorgama.edu.library_api.exception.NotFoundException;
import ygorgama.edu.library_api.mapper.AuthorMapper;
import ygorgama.edu.library_api.model.Author;
import ygorgama.edu.library_api.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> findAll(){
        return AuthorMapper.INSTANCE.authorListToAuthorDtoList(authorRepository.findAll());
    }

    public AuthorDTO findById(Long id){
        Author entity =  authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author not found"));
        return AuthorMapper.INSTANCE.authorToAuthorDto(entity);
    }

    public AuthorDTO create(AuthorDTO author){
        Author entity = authorRepository.save(
                AuthorMapper.INSTANCE.authorDtoToAuthor(author)
        );

        return AuthorMapper.INSTANCE.authorToAuthorDto(entity);
    }

    public AuthorDTO update(AuthorDTO author){
        Author entity = authorRepository.findById(author.getId())
                .orElseThrow(() -> new NotFoundException("Author not found"));

        entity.setFirstName(author.getFirstName());
        entity.setLastName(author.getLastName());

        authorRepository.save(entity);

        return AuthorMapper.INSTANCE.authorToAuthorDto(entity);
    }

    public void delete(Long id){
        Author entity = authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Author not found")
        );

        authorRepository.delete(entity);
    }
}
