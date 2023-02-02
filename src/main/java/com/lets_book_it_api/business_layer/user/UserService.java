package com.lets_book_it_api.business_layer.user;

import com.lets_book_it_api.data_objects.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService
{
    private static final String User = "User_";

    public UserDTO getUser(String id)
    {
        return null;
    }
}
