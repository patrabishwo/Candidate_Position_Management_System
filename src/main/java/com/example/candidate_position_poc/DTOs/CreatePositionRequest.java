package com.example.candidate_position_poc.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePositionRequest {

    @NotBlank(message = "Position name is  required")
    @Size(max= 50,  message = "Position name must not  exceed 50 characters")
    private String positionName;

}
