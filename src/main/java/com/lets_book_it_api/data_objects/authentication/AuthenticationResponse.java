package com.lets_book_it_api.data_objects.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse
{
    private String token;
    private String id;
    private String email;
    private String password;
}
