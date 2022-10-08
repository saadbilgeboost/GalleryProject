package com.saad.monolithicproject.dto.response;

import com.saad.monolithicproject.repository.entity.Gender;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserFindByIdResponseDto {
    String name;
    String surname;
    String address;
    String telephone;
    String email;
    int birthYear;
    String username;
    @NotNull
    @Enumerated(EnumType.STRING)
    Gender gender;
}
