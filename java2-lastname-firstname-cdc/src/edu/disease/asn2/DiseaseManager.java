package edu.disease.asn2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Disease {
    private String name;
    private Map<String, Integer> casesByLocation;

    public Disease(String name) {
        this.name = name;
        this.casesByLocation = new HashMap<>();
    }

    public void addCase(String location) {
        casesByLocation.put(location, casesByLocation.getOrDefault(location, 0) + 1);
    }

    public int getCases(String location) {
        return casesByLocation.getOrDefault(location, 0);
    }

    public String getName() {
        return name;
    }
}

class Patient {
    private String name;
    private int age;
    private Disease disease;

    public Patient(String name, int age, Disease disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Disease getDisease() {
        return disease;
    }
}

public class DiseaseManager {
    private List<Disease> diseases;
    private List<Patient> patients;

    public DiseaseManager() {
        this.diseases = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDisease(Disease disease) {
        diseases.add(disease);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.getDisease().addCase("Unknown"); 
    }

    public int getCasesByLocation(String diseaseName, String location) {
        for (Disease disease : diseases) {
            if (disease.getName().equals(diseaseName)) {
                return disease.getCases(location);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        DiseaseManager manager = new DiseaseManager();

        Disease covid19 = new Disease("COVID-19");
        manager.addDisease(covid19);

        Patient patient1 = new Patient("John", 35, covid19);
        Patient patient2 = new Patient("Jane", 28, covid19);
        manager.addPatient(patient1);
        manager.addPatient(patient2);

        System.out.println("COVID-19 cases in Unknown location: " + manager.getCasesByLocation("COVID-19", "Unknown"));



        Scanner scanner = new Scanner(System.in);



        System.out.print("Enter patient name: ");

        String patientName = scanner.nextLine();



        System.out.print("Enter patient age: ");

        int patientAge = scanner.nextInt();

        scanner.nextLine();



        System.out.print("Enter the date and Time: ");

        String DateTime = scanner.nextLine();



        System.out.print("Enter disease name: ");

        String diseaseName = scanner.nextLine();



        scanner.close();



        System.out.println("Patient details: ");

        System.out.println("Name: " + patientName);

        System.out.println("Age: " + patientAge);

        System.out.println("Disease: " + diseaseName);

        System.out.println("Time: " + DateTime);

    }


    }

