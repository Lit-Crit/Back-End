package com.lets_book_it_api.business_layer.user;

import com.lets_book_it_api.business_layer.token.JwtService;
import com.lets_book_it_api.common.JwtUniversal;
import com.lets_book_it_api.data_objects.user.UserDTO;
import com.lets_book_it_api.database_layer.authentication.AuthenticationRepository;
import com.lets_book_it_api.database_layer.user.UserDatabaseRepository;
import com.lets_book_it_api.validations.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final JwtService jwtService;
    private final UserDatabaseRepository userDatabaseRepository;
    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;
    public UserDTO getUser()
    {
        String email = jwtService.extractUsername(JwtUniversal.getRemovedAuthTypeToken());

        UserDTO user = userDatabaseRepository.getUserByEmail(email);

        return user;
    }

    public String updateUser(UserDTO updateUser)
    {
        UserDTO user = getUser();

        if(!ValidateUser(updateUser,user))
        {
            return "false";
        }
        updateUser.setId(user.getId());
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        updateUser.setNoOfBooksRated(updateUser.getRatedBooks().size());
        updateUser.setNoOfBooksReviewed(updateUser.getReviewedBooks().size());
        userDatabaseRepository.updateUser(updateUser);
        return "Success";
    }

    private boolean ValidateUser(UserDTO updateUser, UserDTO user)
    {
        if(!UserValidator.isUserValid(updateUser))
        {
            return false;
        }
        if(!updateUser.getEmail().equals(user.getEmail()) && authenticationRepository.isUserPresent(updateUser.getEmail()))
        {
            // throw custom exception email already present in database
            return false;
        }
        return true;
    }
}
