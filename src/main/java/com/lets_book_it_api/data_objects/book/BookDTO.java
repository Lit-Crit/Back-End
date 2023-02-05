package com.lets_book_it_api.data_objects.book;

import com.lets_book_it_api.data_objects.user.InterestedBookCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Book")
public class BookDTO
{
    private String id;
    private String name;
    private String title;
    private String description;
    private String coverImage;
    private String publishedDate;
    private String authorName;
    private String authorId;
    private String url;
    private String publishOrganisation;
    private Integer noOfBooksReview;
    private Integer noOfBooksRated;
    private ArrayList<InterestedBookCategory> interestedBookCategory;
    private ArrayList<UserRated> ratedBooksUser;
    private ArrayList<UserReview> reviewedBooksUser;
}
