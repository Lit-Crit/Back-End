package com.lets_book_it_api.validations;

import java.util.regex.Pattern;

public class UrlValidator
{
    private static final String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    public static boolean isUrlValidBoolean(String url)
    {
        if(url.isBlank())
        {
            return false;
        }
        return Pattern.compile(urlRegex)
                .matcher(url)
                .matches();
    }
    public static void isUrlValidThrowException(String name)
    {
        if(!isUrlValidBoolean(name))
        {
            // throw custom exception
        }
    }
}
