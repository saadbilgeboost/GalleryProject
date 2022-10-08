package com.saad.monolithicproject.repository.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tbl_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class User extends Default{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(length = 64)
    String name;
    @Column(length = 64)
    String surname;
    String address;
    @Column(length = 15)
    String telephone;
    String email;
    @Temporal(TemporalType.DATE)
    Date birthdate;
    @Column(length = 32)
    String username;
    @Column(length = 32)
    String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    Gender gender;
}
