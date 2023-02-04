package com.lets_book_it_api.validations;

import com.lets_book_it_api.data_objects.user.InterestedBookCategory;

import java.util.ArrayList;

public class InterestedBookCategoryValidator {
    private static final Integer bookNameLength = 2;
    private static final String book = "Book_";
    public static boolean isInterestedBookCategoryValidBoolean(ArrayList<InterestedBookCategory> interestedBookCategories)
    {
        for(InterestedBookCategory interestedBookCategory : interestedBookCategories)
        {
            if(!isInterestedBookCategoryValidBoolean(interestedBookCategory))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isInterestedBookCategoryValidBoolean(InterestedBookCategory interestedBookCategory)
    {
        return IdValidator.IsBookIdValidBoolean(interestedBookCategory.getBookCategoryId()) && interestedBookCategory.getBookCategoryName().length() > bookNameLength;
    }
    public static void isInterestedBookCategoryThrowException(ArrayList<InterestedBookCategory> interestedBookCategory)
    {
        if(!isInterestedBookCategoryValidBoolean(interestedBookCategory))
        {
            // throw custom exception
        }
    }
    public static void isInterestedBookCategoryThrowException(InterestedBookCategory interestedBookCategory)
    {
        if(!isInterestedBookCategoryValidBoolean(interestedBookCategory))
        {
            // throw custom exception
        }
    }
}
