package com.lets_book_it_api.repository;

import com.lets_book_it_api.data_objects.book.BookDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookDTO,String>
{

}
