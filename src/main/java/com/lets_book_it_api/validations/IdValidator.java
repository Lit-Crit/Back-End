package com.lets_book_it_api.validations;

import java.util.regex.Pattern;

public class IdValidator
{
    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String User = "User_";
    private static final String Book = "Book_";
    private static final String Author = "Author_";
    public static boolean idValidBoolean(String id)
    {
        return Pattern.compile(UUID_REGEX)
                .matcher(id)
                .matches();
    }
    public static void isIdValidThrowException(String id)
    {
        if(!idValidBoolean(id))
        {
            // throw custom exception
        }
    }
    public static boolean IsUserIdValidBoolean(String id)
    {
        id = id.replace(User,"");
        return idValidBoolean(id);
    }
    public static void IsUserIdValidBooleanThrowException(String id)
    {
        id = id.replace(User,"");
        isIdValidThrowException(id);
    }
    public static boolean IsBookIdValidBoolean(String id)
    {
        id = id.replace(Book,"");
        return idValidBoolean(id);
    }
    public static void IsBookIdValidBooleanThrowException(String id)
    {
        id = id.replace(Book,"");
        isIdValidThrowException(id);
    }

    public static boolean IsAuthorIdValidBoolean(String id)
    {
        id = id.replace(Author,"");
        return idValidBoolean(id);
    }
    public static void IsAuthorIdValidBooleanThrowException(String id)
    {
        id = id.replace(Book,"");
        isIdValidThrowException(id);
    }
}
