package com.example.medicalRecord.controller;

import com.example.medicalRecord.invulnerable.model.InvulnerablePatient;
import com.example.medicalRecord.vulnerable.model.VulnerablePatient;
import com.example.medicalRecord.vulnerable.payload.CinPayload;
import com.example.medicalRecord.vulnerable.service.VulnerablePatientService;
import com.example.medicalRecord.invulnerable.service.InvulnerablePatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final VulnerablePatientService vulnerablePatientService;

    private final InvulnerablePatientService invulnerablePatientService;

    @PostMapping("/vulnerable/addPatient")
    public ResponseEntity<String> addPatientVulnerable(@RequestBody VulnerablePatient patient) {
        System.out.println(patient.getMedicalRecord());
        return new ResponseEntity<>(vulnerablePatientService.addPatient(patient), HttpStatus.OK);
    }

    @PostMapping("/vulnerable/medicalRecords")
    public List<VulnerablePatient> getPatientMedicalRecordByCinVulnerable(@RequestBody CinPayload cin) {

        return vulnerablePatientService.getPatientMedicalRecordByCin(cin);
    }

    @PostMapping("/invulnerable/addPatient")
    public ResponseEntity<String> addInvulnerablePatient(@Valid @RequestBody InvulnerablePatient patient) {
        return new ResponseEntity<>(invulnerablePatientService.addPatient(patient), HttpStatus.OK);
    }

    @PostMapping("/invulnerable/medicalRecords")
    public List<InvulnerablePatient> findPatientMedicalRecordByCinVulnerable(@RequestBody InvulnerablePatient invulnerablePatient) {
        return invulnerablePatientService.findPatientMedicalRecordByCin(invulnerablePatient.getCin());
    }
}

