package com.lets_book_it_api.database_layer.author;

import com.lets_book_it_api.data_objects.author.AuthorDTO;
import com.lets_book_it_api.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorDatabaseRepository
{
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorDTO getAuthorById(String id)
    {
        Optional<AuthorDTO> authorOptional = authorRepository.findById(id);
        if(!authorOptional.isPresent())
        {
            // throw exception
            return new AuthorDTO();
        }
        return authorOptional.get();
    }
}
