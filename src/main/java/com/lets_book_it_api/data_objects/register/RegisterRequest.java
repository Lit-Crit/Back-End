package com.lets_book_it_api.data_objects.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserCredentials")
public class RegisterRequest
{
    private String id;
    private String name;
    private String email;
    private String  password;
}
