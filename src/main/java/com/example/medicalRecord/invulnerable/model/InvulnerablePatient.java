package com.example.medicalRecord.invulnerable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invulnerable_patients")
public class InvulnerablePatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Nom invalide")
    @Length(min = 1, max = 50, message = "le nom depasse la taille maximale autorisee")
    private String name;

    @NotBlank(message = "CIN invalide")
    @Pattern(regexp = "^[A-Z]\\d{6}$", message = "CIN invalide")
    private String cin;
    
    @NotBlank(message = "Medical Record invalide")
    @Length(min = 1, max = 50, message = "Medical Record invalide")
    private String medicalRecord;

}

