package com.lets_book_it_api.business_layer.book;

import com.lets_book_it_api.data_objects.book.BookDTO;
import com.lets_book_it_api.database_layer.book.BookDatabaseRepository;
import com.lets_book_it_api.validations.IdValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookDatabaseRepository bookDatabaseRepository;
    public BookDTO getBookById(String id)
    {
        if(!IdValidator.IsBookIdValidBoolean(id))
        {
            return new BookDTO();
        }
        return bookDatabaseRepository.getBookById(id);
    }
}
