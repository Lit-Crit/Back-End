package com.lets_book_it_api.business_layer.user;

import com.lets_book_it_api.business_layer.token.JwtService;
import com.lets_book_it_api.common.JwtUniversal;
import com.lets_book_it_api.data_objects.user.UserDTO;
import com.lets_book_it_api.database_layer.user.UserDatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final JwtService jwtService;
    private final UserDatabaseRepository userDatabaseRepository;

    public UserDTO getUser()
    {
        String email = jwtService.extractUsername(JwtUniversal.getRemovedAuthTypeToken());

        UserDTO user = userDatabaseRepository.getUserByEmail(email);

        return user;
    }
}
