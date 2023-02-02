package com.lets_book_it_api.validations;

import java.util.regex.Pattern;

public class UserIdValidator
{
    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    public static boolean isUserIdValidBoolean(String id)
    {
        return Pattern.compile(UUID_REGEX)
                .matcher(id)
                .matches();
    }
    public static void isUserIdValidThrowException(String id)
    {
        if(!isUserIdValidBoolean(id))
        {
            // throw custom exception
        }
    }
}
