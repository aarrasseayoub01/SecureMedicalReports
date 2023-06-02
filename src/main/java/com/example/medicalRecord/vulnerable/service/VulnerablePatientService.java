package com.example.medicalRecord.vulnerable.service;


import com.example.medicalRecord.vulnerable.dao.PatientsManager;
import com.example.medicalRecord.vulnerable.model.VulnerablePatient;
import com.example.medicalRecord.vulnerable.payload.CinPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VulnerablePatientService {

    private final PatientsManager patientsManager;

    @Autowired
    public VulnerablePatientService(PatientsManager patientsManager) {
        this.patientsManager = patientsManager;
    }


    public String addPatient(VulnerablePatient patient) {
         return patientsManager.addPatient(patient);
    }

    public List<VulnerablePatient> getPatientMedicalRecordByCin(CinPayload Cin) {
        return patientsManager.getPatientMedicalRecordByCin(Cin);
    }
}

