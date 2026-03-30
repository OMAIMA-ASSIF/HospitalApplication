package net.omaima.hospitalapplication.service;

import net.omaima.hospitalapplication.entities.Consultation;
import net.omaima.hospitalapplication.entities.Medecin;
import net.omaima.hospitalapplication.entities.Patient;
import net.omaima.hospitalapplication.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
