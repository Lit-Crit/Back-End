package com.lets_book_it_api.database_layer.authentication;

import com.lets_book_it_api.data_objects.authentication.AuthenticateRequest;
import com.lets_book_it_api.data_objects.authentication.AuthenticationResponse;
import com.lets_book_it_api.data_objects.register.RegisterRequest;
import com.lets_book_it_api.repository.AuthenticateUserRepository;
import com.lets_book_it_api.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationRepository
{
    @Autowired
    private final RegisterRepository registerRepository;
    @Autowired
    private final AuthenticateUserRepository authenticateUserRepository;
    public boolean registerUser(RegisterRequest request)
    {
        if(isUserPresent(request.getEmail()))
        {
            return false;
        }

        registerRepository.save(request);

        return true;
    }

    public AuthenticationResponse authenticateUser(AuthenticateRequest request)
    {
        AuthenticationResponse user = authenticateUserRepository.findUserByEmail(request.getEmail());
        return user;
    }

    private boolean isUserPresent(String email)
    {
        return registerRepository.findUserByEmail(email) != null;
    }
}
