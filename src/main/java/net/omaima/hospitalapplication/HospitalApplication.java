package net.omaima.hospitalapplication;

import net.omaima.hospitalapplication.entities.*;
import net.omaima.hospitalapplication.repositories.ConsultationRepository;
import net.omaima.hospitalapplication.repositories.MedecinRepository;
import net.omaima.hospitalapplication.repositories.PatientRepository;
import net.omaima.hospitalapplication.repositories.RendezVousRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Soumia", "Hassan", "Omaima")
                    .forEach(name -> {
                        Patient patient= new Patient();
                        patient.setNom(name);
                        patient.setMalade(false);
                        patient.setDateNaissance(new Date());
                        patientRepository.save(patient);
                    });

            Stream.of("Aymen", "Zindoug", "Khalid")
                    .forEach(name -> {
                        Medecin medecin= new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio":"Dentiste");
                        medecinRepository.save(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Hassan");

            Medecin medecin = medecinRepository.findByNom("Khalid");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultion .....");
            consultationRepository.save(consultation);

        };
    }


}
