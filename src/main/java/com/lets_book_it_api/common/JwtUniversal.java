package com.lets_book_it_api.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class JwtUniversal
{
    private static final String Bearer = "Bearer ";
    public static String getTokenFromHeaders()
    {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader("Authorization");
    }
    public static String getRemovedAuthTypeToken()
    {
        String token = getTokenFromHeaders();
        token = token.replace(Bearer,"");
        return token;
    }
}
