package com.lets_book_it_api.validations;

import com.lets_book_it_api.data_objects.user.UserDTO;

import java.util.regex.Pattern;

public class UserValidator
{
    private static final String addressRegex = "^[a-zA-Z0-9 ]*$";
    public static boolean isUserValid(UserDTO userDTO)
    {
        if(!EmailValidator.isEmailValidBoolean(userDTO.getEmail()))
        {
            return false;
        }
        if(!PasswordValidator.isPasswordValidBoolean(userDTO.getPassword()))
        {
            return false;
        }
        if(!NameValidator.isNameValidBoolean(userDTO.getName()))
        {
            return false;
        }
        if(!(userDTO.getAge() > 0 && userDTO.getAge() < 150))
        {
            return false;
        }
        if(!Pattern.compile(addressRegex).matcher(userDTO.getAddress()).matches())
        {
            return false;
        }
        if(!Pattern.compile(addressRegex).matcher(userDTO.getState()).matches())
        {
            return false;
        }
        if(!Pattern.compile(addressRegex).matcher(userDTO.getCountry()).matches())
        {
            return false;
        }
        if(!InterestedBookCategoryValidator.isInterestedBookCategoryValidBoolean(userDTO.getInterestedBookCategory()))
        {
            return false;
        }
        if(!InterestedAuthorValidator.isInterestedAuthorValidBoolean(userDTO.getInterestedAuthors()))
        {
            return false;
        }
        if(!ReadBooksValidator.isReadBooksBoolean(userDTO.getPreviousReadBooks()))
        {
            return false;
        }
        if(!ReadBooksValidator.isCurrentBooksBoolean(userDTO.getCurrentBooks()))
        {
            return false;
        }
        if(!ReadBooksValidator.isWishListBooksBoolean(userDTO.getWishlists()))
        {
            return false;
        }
        if(!RatingReviewValidator.isRatingBooksBoolean(userDTO.getRatedBooks()))
        {
            return false;
        }
        if(!RatingReviewValidator.isReviewBooksBoolean(userDTO.getReviewedBooks()))
        {
            return false;
        }

        return true;
    }
    public static void IsUserValidThrowException(UserDTO userDTO)
    {
        if(!isUserValid(userDTO))
        {
            // throw exception
        }
    }
}
