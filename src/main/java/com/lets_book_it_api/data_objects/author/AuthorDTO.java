package com.lets_book_it_api.data_objects.author;

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
@Document(collection = "Authors")
public class AuthorDTO
{
    private String id;
    private String email;
    private String name;
    private String dateOfBirth;
    private String bio;
    private String publishOrganisation;
    private Integer publishedBooks;
    private ArrayList<WriteBookCategory> writeBookCategory;
    private ArrayList<BookPublished> bookPublished;
}
