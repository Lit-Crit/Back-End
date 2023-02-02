package com.lets_book_it_api.data_objects.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterestedBookCategory
{
    private String bookCategoryId;
    private String bookCategoryName;
}
