package com.lets_book_it_api.database_layer.user;

import com.lets_book_it_api.data_objects.user.UserDTO;
import com.lets_book_it_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UserDTO getUserById(String id)
    {
        Optional<UserDTO> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent())
        {
            // throw exception
            return new UserDTO();
        }
        return userOptional.get();
    }
    public UserDTO getUserByEmail(String email)
    {
        Optional<UserDTO> userOptional = userRepository.findUserByEmail(email);
        if(!userOptional.isPresent())
        {
            // throw exception
            return new UserDTO();
        }
        return userOptional.get();
    }
}
