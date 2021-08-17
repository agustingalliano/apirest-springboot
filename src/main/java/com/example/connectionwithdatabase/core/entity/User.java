package com.example.connectionwithdatabase.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity//Al decirle que es de tipo Entity lo registra como una tabla
@Table (name="users")
public class User{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)//Le indicamos que este campo es clave principal
    private Long id;

    @Column (length = 50)
    private String name;

    private String surname;


    @Column (name = "email", nullable = false, length = 50, unique = true)
    private String email;

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
