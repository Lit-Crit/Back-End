package com.lets_book_it_api.validations;

import com.lets_book_it_api.data_objects.user.InterestedAuthors;

import java.util.ArrayList;

public class InterestedAuthorValidator
{
    private static final Integer authorNameLength = 2;
    public static boolean isInterestedAuthorValidBoolean(ArrayList<InterestedAuthors> interestedAuthors)
    {
        for(InterestedAuthors interestedAuthor : interestedAuthors)
        {
            if(!isInterestedAuthorValidBoolean(interestedAuthor))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isInterestedAuthorValidBoolean(InterestedAuthors interestedAuthors)
    {
        return IdValidator.IsAuthorIdValidBoolean(interestedAuthors.getAuthorId()) && interestedAuthors.getAuthorName().length() > authorNameLength;
    }
    public static void isInterestedAuthorValidThrowException(ArrayList<InterestedAuthors> interestedAuthors)
    {
        if(!isInterestedAuthorValidBoolean(interestedAuthors))
        {
            // throw custom exception
        }
    }
    public static void isInterestedAuthorValidThrowException(InterestedAuthors interestedAuthors)
    {
        if(!isInterestedAuthorValidBoolean(interestedAuthors))
        {
            // throw custom exception
        }
    }
}
