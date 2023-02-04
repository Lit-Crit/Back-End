package com.lets_book_it_api.database_layer;

import com.lets_book_it_api.data_objects.user.UserDTO;
import com.lets_book_it_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDatabaseRepository
{
    @Autowired
    private final UserRepository userRepository;
    public boolean addUser(UserDTO user)
    {
        userRepository.save(user);
        return true;
    }
}
