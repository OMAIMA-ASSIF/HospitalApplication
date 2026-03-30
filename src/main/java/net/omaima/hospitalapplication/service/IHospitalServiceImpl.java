package net.omaima.hospitalapplication.service;

import jakarta.transaction.Transactional;
import net.omaima.hospitalapplication.entities.Consultation;
import net.omaima.hospitalapplication.entities.Medecin;
import net.omaima.hospitalapplication.entities.Patient;
import net.omaima.hospitalapplication.entities.RendezVous;
import net.omaima.hospitalapplication.repositories.ConsultationRepository;
import net.omaima.hospitalapplication.repositories.MedecinRepository;
import net.omaima.hospitalapplication.repositories.PatientRepository;
import net.omaima.hospitalapplication.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        //normalement ici on doit avoir un traitement (verifications,...)
        //cad des regles metiers quand on doit ajouter
        return consultationRepository.save(consultation);
    }
}
