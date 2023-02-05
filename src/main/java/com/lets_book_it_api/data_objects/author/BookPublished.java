package com.lets_book_it_api.data_objects.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookPublished
{
    private String bookId;
    private String bookName;
    private String url;
}
