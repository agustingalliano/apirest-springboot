package com.example.connectionwithdatabase.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity//Al decirle que es de tipo Entity lo registra como una tabla
@Table (name="users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Le indicamos que este campo es clave principal
    private Long id;

    @Column(length = 50)
    @NotEmpty(message = "Field empty!")
    private String name;

    @NotEmpty
    private String surname;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    @NotEmpty
    @Email
    private String email;

    private boolean enabled;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "fk_userDetail")
    private UserDetail userDetail;
}
