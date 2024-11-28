package Aufgaben;

import Aufgaben.extras.Patient;
import Aufgaben.extras.Donor;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class bloodDonorsClinic {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Donor> donors = new ArrayList<>();

//        readPatients("C:\\Users\\przem\\IdeaProjects\\Verzweigungen\\src\\dotText\\patients.txt", patients);
        readDonors("C:\\Users\\przem\\IdeaProjects\\Verzweigungen\\src\\dotText\\donors.txt", donors);

        getPatientsFromUserInput(patients);

        String compatibilityFilePath = "C:\\Users\\przem\\IdeaProjects\\Verzweigungen\\src\\dotText\\compatibility.txt";
        saveCompatibilityToFile(patients, donors, compatibilityFilePath );

        printCompatibilityFile(compatibilityFilePath);

//        for (Patient patient : patients) {
//            for (Donor dnr : donors) {
//                if (patient.getNeedsBlood()){
//                    if (dnr.canDonateBlood(patient)){
//                        System.out.println(dnr + "Can donate blood to " + patient);
//                    } else {
//                        System.out.println(dnr + "Cannot donate blood to " + patient);
//                    }
//
//                }
//                if (patient.getNeedsPlasma()){
//                    if (dnr.canDonatePlasma(patient)){
//                        System.out.println(dnr + "Can donate plasma to " + patient);
//                    } else {
//                        System.out.println(dnr + "Cannot donate plasma to " + patient);
//                    }
//                }
//            }
//        }

    }

    private static void getPatientsFromUserInput(ArrayList<Patient> patients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input patients details : name, bloodGroup, needsPlasma(true/false), needsBlood(true/false), gender(M for Male, F for Female, age). To stop, type 'exit' : ");

        while (true) {
            System.out.print("Patients Inputs (or 'exit' to stop): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] tokens = input.split(",");
            if (tokens.length != 6) {
                System.out.println("Invalid number of values entered.");
                continue;
            }


            try {
                String name = tokens[0].trim();
                String bloodGroup = tokens[1].trim();
                boolean needsPlasma = Boolean.parseBoolean(tokens[2].trim());
                boolean needsBlood = Boolean.parseBoolean(tokens[3].trim());
                String gender = tokens[4].trim();
                int age = Integer.parseInt(tokens[5].trim());

                patients.add(new Patient(name, bloodGroup, needsPlasma, needsBlood, gender, age));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of values entered.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

//    public static void readPatients(String path, ArrayList<Patient> patients){
//        try (BufferedReader br = new BufferedReader(new FileReader(path))){
//            String line;
//            while ((line = br.readLine()) != null){
//                String[] tokens = line.split(",");
//                String name = tokens[0];
//                String bloodGroup = tokens[1];
//                Boolean needsPlasma = Boolean.parseBoolean(tokens[2]);
//                Boolean needsBlood = Boolean.parseBoolean(tokens[3]);
//                String gender = tokens[4];
//                int age = Integer.parseInt(tokens[5]);
//
//                patients.add(new Patient(name, bloodGroup, needsPlasma, needsBlood, gender, age));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private static void saveCompatibilityToFile(ArrayList<Patient> patients, ArrayList<Donor> donors, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Patient patient : patients) {
                for (Donor donor : donors) {
                    if (patient.getNeedsBlood() && donor.canDonateBlood(patient)) {
                        bw.write(donor + "can donate blood to " + patient);
                        bw.newLine();
                    }
                    if (patient.getNeedsPlasma() && donor.canDonatePlasma(patient)) {
                        bw.write(donor + "can donate plasma to " + patient);
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCompatibilityFile(String path) { //just for the console output
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println("\nCompatibility Results:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading compatibility file: " + e.getMessage());
        }
    }

    public static void readDonors(String path, ArrayList<Donor> donors){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(",");
                String name = tokens[0];
                String bloodGroup = tokens[1];
                String gender = tokens[2];
                int age = Integer.parseInt(tokens[3]);

                donors.add(new Donor(name, bloodGroup, gender, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
