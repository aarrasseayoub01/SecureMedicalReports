package com.example.medicalRecord.vulnerable.dao;


import com.example.medicalRecord.vulnerable.payload.CinPayload;
import org.springframework.stereotype.Service;
import com.example.medicalRecord.vulnerable.model.VulnerablePatient;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class PatientsManager {

    private final DataSource dataSource;

    public PatientsManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<VulnerablePatient> getPatientMedicalRecordByCin(CinPayload cin) {

        String sql = "SELECT * FROM vulnerable_patients WHERE cin = " + cin.getCin();
        return getPatients(sql);
    }

    private List<VulnerablePatient> getPatients(String sql) {
        Connection c = null;
        ResultSet rs = null;
        try {
            c = dataSource.getConnection();
            rs = c.createStatement().executeQuery(sql);
            List<VulnerablePatient> patients = new ArrayList<>();
            while (rs.next()) {
                VulnerablePatient patient = new VulnerablePatient();
                patient.setId(rs.getLong("id"));
                patient.setName(rs.getString("name"));
                patient.setCin(rs.getString("cin"));
                patient.setMedicalRecord(rs.getString("medical_record"));
                patients.add(patient);
            }
            return patients;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String addPatient(VulnerablePatient patient) {

        Connection c = null;
        try {
            c = dataSource.getConnection();



            String sqlPatient = "INSERT INTO vulnerable_patients (name,cin,medical_record) VALUES ('"
                    + patient.getName() + "', '"
                    + patient.getCin() + "', '"
                    + patient.getMedicalRecord() + "') RETURNING id";

            c.createStatement().executeQuery(sqlPatient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "requete effectuee";
    }

}



