package com.lets_book_it_api.repository;

import com.lets_book_it_api.data_objects.user.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDTO,String>
{
}
