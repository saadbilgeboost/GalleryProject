package com.saad.monolithicproject.dto.request;

import com.saad.monolithicproject.repository.entity.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserSaveRequestDto {
    String name;
    String surname;
    String email;
    @Temporal(TemporalType.DATE)
    Date birthdate;
    String username;
    String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    Gender gender;
    String address;
    String telephone;
}
