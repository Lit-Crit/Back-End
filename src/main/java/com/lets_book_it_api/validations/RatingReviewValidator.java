package com.lets_book_it_api.validations;

import com.lets_book_it_api.data_objects.user.RatedBooks;
import com.lets_book_it_api.data_objects.user.ReviewedBooks;

import java.util.ArrayList;

public class RatingReviewValidator
{
    private static final Integer bookNameLength = 2;
    public static boolean isRatingBooksBoolean(RatedBooks ratedBook)
    {
        return IdValidator.IsBookIdValidBoolean(ratedBook.getBookId()) && ratedBook.getBookName().length() > bookNameLength && ratedBook.getRating() > 0 && ratedBook.getRating() <= 10;
    }
    public static void isRatingBooksThrowException(RatedBooks ratedBook)
    {
        if(!isRatingBooksBoolean(ratedBook))
        {
            // throw custom exception
        }
    }
    public static boolean isRatingBooksBoolean(ArrayList<RatedBooks> ratedBooks)
    {
        for(RatedBooks ratedBook : ratedBooks)
        {
            if(!isRatingBooksBoolean(ratedBook))
            {
                return false;
            }
        }
        return true;
    }
    public static void isRatingBooksThrowException(ArrayList<RatedBooks> ratedBooks)
    {
        if(!isRatingBooksBoolean(ratedBooks))
        {
            // throw custom exception
        }
    }

    public static boolean isReviewBooksBoolean(ReviewedBooks reviewedBook)
    {
        return IdValidator.IsBookIdValidBoolean(reviewedBook.getBookId()) && reviewedBook.getBookName().length() > bookNameLength;
    }
    public static void isReviewBooksThrowException(ReviewedBooks reviewedBook)
    {
        if(!isReviewBooksBoolean(reviewedBook))
        {
            // throw custom exception
        }
    }
    public static boolean isReviewBooksBoolean(ArrayList<ReviewedBooks> reviewedBooks)
    {
        for(ReviewedBooks reviewedBook : reviewedBooks)
        {
            if(!isReviewBooksBoolean(reviewedBook))
            {
                return false;
            }
        }
        return true;
    }
    public static void isReviewBooksThrowException(ArrayList<ReviewedBooks> reviewedBooks)
    {
        if(!isReviewBooksBoolean(reviewedBooks))
        {
            // throw custom exception
        }
    }
}
