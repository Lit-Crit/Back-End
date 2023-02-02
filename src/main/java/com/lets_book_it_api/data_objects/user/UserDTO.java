package com.lets_book_it_api.data_objects.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
    private String id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String address;
    private String state;
    private String country;
    private Integer noOfBooksReviewed;
    private Integer noOfBooksRated;
    private ArrayList<InterestedBookCategory> interestedBookCategory;
    private ArrayList<InterestedAuthors> interestedAuthors;
    private ArrayList<PreviousReadBooks> previousReadBooks;
    private ArrayList<CurrentBooks> currentBooks;
    private ArrayList<RatedBooks> ratedBooks;
    private ArrayList<ReviewedBooks> reviewedBooks;
    private ArrayList<Wishlist> wishlists;
}
