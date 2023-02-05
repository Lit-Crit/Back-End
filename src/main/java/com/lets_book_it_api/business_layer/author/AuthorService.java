package com.lets_book_it_api.business_layer.author;

import com.lets_book_it_api.data_objects.author.AuthorDTO;
import com.lets_book_it_api.database_layer.author.AuthorDatabaseRepository;
import com.lets_book_it_api.validations.IdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorDatabaseRepository authorDatabaseRepository;
    public AuthorDTO getAuthorById(String id)
    {
        if(!IdValidator.IsAuthorIdValidBoolean(id))
        {
            return new AuthorDTO();
        }
        return authorDatabaseRepository.getAuthorById(id);
    }
}
