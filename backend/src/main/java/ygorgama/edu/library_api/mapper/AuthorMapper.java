package ygorgama.edu.library_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ygorgama.edu.library_api.dto.AuthorDTO;
import ygorgama.edu.library_api.model.Author;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );

    AuthorDTO authorToAuthorDto(Author author);
    List<AuthorDTO> authorListToAuthorDtoList(List<Author> authorList);

    Author authorDtoToAuthor(AuthorDTO authorDTO);
}
