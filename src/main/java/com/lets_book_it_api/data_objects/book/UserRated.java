package com.lets_book_it_api.data_objects.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRated
{
    private String userId;
    private String userName;
    private Integer rating;
}
