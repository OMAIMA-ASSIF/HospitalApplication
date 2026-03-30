package net.omaima.hospitalapplication.repositories;

import net.omaima.hospitalapplication.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
