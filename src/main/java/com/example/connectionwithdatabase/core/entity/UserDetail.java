package com.example.connectionwithdatabase.core.entity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "userDetails")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "web")
    private String web;

    @Column (name = "phone")
    private String phone;

    @Column (name = "comments")
    private String comments;
}
