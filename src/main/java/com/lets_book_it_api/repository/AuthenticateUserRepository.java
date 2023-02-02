package com.lets_book_it_api.repository;

import com.lets_book_it_api.data_objects.authentication.AuthenticateRequest;
import com.lets_book_it_api.data_objects.authentication.AuthenticationResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticateUserRepository extends MongoRepository<AuthenticateRequest,String>
{
    @Query("{ 'email' : ?0} }")
    AuthenticationResponse findUserByEmail(String email, String password);
}
