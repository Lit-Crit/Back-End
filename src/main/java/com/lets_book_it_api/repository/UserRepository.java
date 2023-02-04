package com.lets_book_it_api.repository;

import com.lets_book_it_api.data_objects.user.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDTO,String>
{
    @Query("{ 'email' : ?0}")
    Optional<UserDTO> findUserByEmail(String email);
}
