package com.lets_book_it_api.business_layer.authentication;

import com.lets_book_it_api.business_layer.token.JwtService;
import com.lets_book_it_api.data_objects.authentication.AuthenticateRequest;
import com.lets_book_it_api.data_objects.authentication.AuthenticationResponse;
import com.lets_book_it_api.data_objects.register.RegisterRequest;
import com.lets_book_it_api.data_objects.register.RegisterResponse;
import com.lets_book_it_api.database_layer.AuthenticationRepository;
import com.lets_book_it_api.validations.EmailValidator;
import com.lets_book_it_api.validations.NameValidator;
import com.lets_book_it_api.validations.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService
{
    private static final String User = "User_";
    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public RegisterResponse register(RegisterRequest request)
    {
        RegisterResponse registerResponse = new RegisterResponse();

        if(!ValidateRegisterRequest(request))
        {
            return registerResponse;
        }

        request = createUserForRegister(request);

        if(!authenticationRepository.registerUser(request))
        {
            return registerResponse;
        }

        var jwtToken = jwtService.generateToken(request.getEmail());

        registerResponse.setToken(jwtToken);
        registerResponse.setId(request.getId());
        registerResponse.setEmail(request.getEmail());

        return registerResponse;
    }

    public AuthenticationResponse authenticate(AuthenticateRequest request)
    {

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        if(!AuthenticateRegisterRequest(request))
        {
            return authenticationResponse;
        }

        var response = authenticationRepository.authenticateUser(request);

        if(response == null)
        {
            return authenticationResponse;
        }

        boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), response.getPassword());

        if(isPasswordMatch)
        {
            var jwtToken = jwtService.generateToken(request.getEmail());
            authenticationResponse.setToken(jwtToken);
            authenticationResponse.setId(response.getId());
            authenticationResponse.setEmail(response.getEmail());
        }

        return authenticationResponse;
    }

    private boolean ValidateRegisterRequest(RegisterRequest request)
    {
        if(request.getName().isBlank() || request.getEmail().isBlank() || request.getPassword().isBlank())
        {
            return false;
        }

        if(!NameValidator.isNameValidBoolean(request.getName()))
        {
            return false;
        }

        if(!EmailValidator.isEmailValidBoolean(request.getEmail()))
        {
            return false;
        }

        if(!PasswordValidator.isPasswordValidBoolean(request.getPassword()))
        {
            return false;
        }

        return true;
    }
    private RegisterRequest createUserForRegister(RegisterRequest registerUser)
    {
        registerUser.setId(User + UUID.randomUUID());
        registerUser.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        return registerUser;
    }

    private boolean AuthenticateRegisterRequest(AuthenticateRequest request)
    {
        if(request.getEmail().isBlank() || request.getPassword().isBlank())
        {
            return false;
        }

        if(!EmailValidator.isEmailValidBoolean(request.getEmail()))
        {
            return false;
        }

        if(!PasswordValidator.isPasswordValidBoolean(request.getPassword()))
        {
            return false;
        }

        return true;
    }
}
