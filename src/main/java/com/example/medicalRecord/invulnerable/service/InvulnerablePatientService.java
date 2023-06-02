package com.example.medicalRecord.invulnerable.service;

import com.example.medicalRecord.invulnerable.model.InvulnerablePatient;
import com.example.medicalRecord.invulnerable.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvulnerablePatientService {

    private final PatientRepository patientRepository;

    public InvulnerablePatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<InvulnerablePatient> findPatientMedicalRecordByCin(String cin) {
        return patientRepository.findPatientsWithMedicalRecordsByCin(cin);
    }

    public String addPatient(InvulnerablePatient patient) {
        patientRepository.save(patient);

        return "Votre commande a été effectuée avec succès";
    }

}

