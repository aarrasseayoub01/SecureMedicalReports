package com.example.medicalRecord.invulnerable.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SendMedicalRecordRequest {

    @Pattern(regexp = "^[A-Z]\\d{6}$", message = "CIN invalide")
    private String cin;
}
