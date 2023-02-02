package com.lets_book_it_api.data_objects.authentication;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserCredentials")
public class AuthenticateRequest
{
    private String email;
    private String  password;
}
