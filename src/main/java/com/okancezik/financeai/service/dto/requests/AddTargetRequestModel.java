package com.okancezik.financeai.service.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTargetRequestModel {

    @NotNull
    @NotBlank
    private double amount;

    @NotNull
    @NotBlank
    private int userId;

    private LocalDateTime loadDate = LocalDateTime.now();
}
