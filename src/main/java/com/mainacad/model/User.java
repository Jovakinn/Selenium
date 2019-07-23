package com.mainacad.model;

import lombok.*;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;

}
