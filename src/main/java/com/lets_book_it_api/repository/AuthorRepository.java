package com.lets_book_it_api.repository;

import com.lets_book_it_api.data_objects.author.AuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthorRepository extends MongoRepository<AuthorDTO,String>
{
    @Query("{ 'email' : ?0}")
    Optional<AuthorDTO> findAuthorByEmail(String email);
}