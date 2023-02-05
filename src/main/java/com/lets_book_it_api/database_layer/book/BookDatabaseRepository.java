package com.lets_book_it_api.database_layer.book;

import com.lets_book_it_api.data_objects.book.BookDTO;
import com.lets_book_it_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookDatabaseRepository
{
    @Autowired
    private final BookRepository bookRepository;

    public BookDTO getBookById(String id)
    {
        Optional<BookDTO> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent())
        {
            // throw exception
            return new BookDTO();
        }
        return bookOptional.get();
    }
}
