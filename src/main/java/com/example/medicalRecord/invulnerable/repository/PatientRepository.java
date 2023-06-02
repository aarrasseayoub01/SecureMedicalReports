package com.example.medicalRecord.invulnerable.repository;

import com.example.medicalRecord.invulnerable.model.InvulnerablePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<InvulnerablePatient, Long> {
    @Query("SELECT vp FROM InvulnerablePatient vp WHERE vp.cin = :cin")
    List<InvulnerablePatient> findPatientsWithMedicalRecordsByCin(@Param("cin") String cin);
}
