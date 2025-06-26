package com.example.candidate_position_poc.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCandidateRequest {

    @Size(max = 50, message = "Name must not exceed 50 characters")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private LocalDate dob;

    private List<Long> positionIds;
}
