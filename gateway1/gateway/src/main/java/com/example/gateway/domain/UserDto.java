package com.example.gateway.domain;

import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto  implements Serializable  {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;


}
