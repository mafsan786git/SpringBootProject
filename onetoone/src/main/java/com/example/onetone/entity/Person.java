package com.example.onetone.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( uniqueConstraints = {@UniqueConstraint(columnNames = "passportId")})
public class Person {
    @Id
    private String personId;
    private String personName;

    @OneToOne
    @JoinColumn(name = "passportId")
    Passport passport;

}
