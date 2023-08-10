package edu.disease.asn1;


import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private boolean infected;

    public Patient(String name) {
        this.name = name;
        this.infected = false;
    }

    public String getName() {
        return name;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }
}

class DiseaseControlManager {
    private List<Patient> patients;

    public DiseaseControlManager() {
        patients = new ArrayList<>();
    }

    public void addPatient(String name) {
        Patient patient = new Patient(name);
        patients.add(patient);
    }

    public void markPatientInfected(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                patient.setInfected(true);
                break;
            }
        }
    }

    public void printInfectedPatients() {
        System.out.println("Infected Patients:");
        for (Patient patient : patients) {
            if (patient.isInfected()) {
                System.out.println(patient.getName());
            }
        }
    }
}

public class Ass1 {
    public static void main(String[] args) {
        DiseaseControlManager manager = new DiseaseControlManager();

        manager.addPatient("lisa");
        manager.addPatient("mark");

        manager.markPatientInfected("steve");
        

        manager.printInfectedPatients();
    }
}