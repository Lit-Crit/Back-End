package com.lets_book_it_api.validations;

import com.lets_book_it_api.data_objects.user.CurrentBooks;
import com.lets_book_it_api.data_objects.user.PreviousReadBooks;
import com.lets_book_it_api.data_objects.user.Wishlist;

import java.util.ArrayList;

public class ReadBooksValidator
{
    private static final Integer bookNameLength = 2;
    public static boolean isReadBooksBoolean(PreviousReadBooks previousReadBook)
    {
        return IdValidator.IsBookIdValidBoolean(previousReadBook.getBookId()) && previousReadBook.getBookName().length() > bookNameLength && UrlValidator.isUrlValidBoolean(previousReadBook.getBookUrl());
    }
    public static void isReadBooksThrowException(PreviousReadBooks previousReadBook)
    {
        if(!isReadBooksBoolean(previousReadBook))
        {
            // throw custom exception
        }
    }
    public static boolean isReadBooksBoolean(ArrayList<PreviousReadBooks> readBooks)
    {
        for (PreviousReadBooks readBook : readBooks) {
            if (!isReadBooksBoolean(readBook)) {
                return false;
            }
        }
        return true;
    }
    public static void isReadBooksThrowException(ArrayList<PreviousReadBooks> previousReadBooks)
    {
        if(!isReadBooksBoolean(previousReadBooks))
        {
            // throw custom exception
        }
    }
    public static boolean isCurrentBooksBoolean(CurrentBooks currentReadBook)
    {
        return IdValidator.IsBookIdValidBoolean(currentReadBook.getBookId()) && currentReadBook.getBookName().length() > bookNameLength && UrlValidator.isUrlValidBoolean(currentReadBook.getBookUrl());
    }
    public static void isCurrentBooksThrowException(CurrentBooks currentReadBook)
    {
        if(!isCurrentBooksBoolean(currentReadBook))
        {
            // throw custom exception
        }
    }
    public static boolean isCurrentBooksBoolean(ArrayList<CurrentBooks> readBooks)
    {
        for(CurrentBooks currentBook : readBooks)
        {
            if(!isCurrentBooksBoolean(currentBook))
            {
                return false;
            }
        }
        return true;
    }
    public static void isCurrentBooksThrowException(ArrayList<CurrentBooks> currentReadBooks)
    {
        if(!isCurrentBooksBoolean(currentReadBooks))
        {
            // throw custom exception
        }
    }

    public static boolean isWishListBooksBoolean(Wishlist wishlist)
    {
        return IdValidator.IsBookIdValidBoolean(wishlist.getBookId()) && wishlist.getBookName().length() > bookNameLength && UrlValidator.isUrlValidBoolean(wishlist.getUrl());
    }
    public static void isWishListBooksThrowException(Wishlist wishlist)
    {
        if(!isWishListBooksBoolean(wishlist))
        {
            // throw custom exception
        }
    }
    public static boolean isWishListBooksBoolean(ArrayList<Wishlist> wishlists)
    {
        for(Wishlist wishlist : wishlists)
        {
            if(!isWishListBooksBoolean(wishlist))
            {
                return false;
            }
        }
        return true;
    }
    public static void isWishListBooksThrowException(ArrayList<Wishlist> wishlists)
    {
        if(!isWishListBooksBoolean(wishlists))
        {
            // throw custom exception
        }
    }
}
