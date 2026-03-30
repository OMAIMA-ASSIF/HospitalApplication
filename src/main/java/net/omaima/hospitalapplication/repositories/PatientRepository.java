package net.omaima.hospitalapplication.repositories;

import net.omaima.hospitalapplication.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom); //comme si on suppose que le nom est unique



}
