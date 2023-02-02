package com.lets_book_it_api.repository;

import com.lets_book_it_api.data_objects.register.RegisterRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends MongoRepository<RegisterRequest,String>
{
    @Query("{ 'email' : ?0 }")
    RegisterRequest findUserByEmail(String email);
}

