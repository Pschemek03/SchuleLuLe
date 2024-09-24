package Aufgaben;

import Aufgaben.extras.Patient;
import Aufgaben.extras.Donor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class bloodDonorsClinic {
    public static void main() {
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Donor> donors = new ArrayList<>();

        readPatients("C:\\Users\\przem\\IdeaProjects\\Verzweigungen\\src\\dotText\\patients.txt", patients);
        readDonors("C:\\Users\\przem\\IdeaProjects\\Verzweigungen\\src\\dotText\\donors.txt", donors);

        for (Patient patient : patients) {
            for (Donor dnr : donors) {
                if (patient.getNeedsBlood()){
                    if (dnr.canDonateBlood(patient)){
                        System.out.println(dnr + "Can donate blood to " + patient);
                    } else {
                        System.out.println(dnr + "Cannot donate blood to " + patient);
                    }

                }
                if (patient.getNeedsPlasma()){
                    if (dnr.canDonatePlasma(patient)){
                        System.out.println(dnr + "Can donate plasma to " + patient);
                    } else {
                        System.out.println(dnr + "Cannot donate plasma to " + patient);
                    }
                }
            }
        }

    }

    public static void readPatients(String path, ArrayList<Patient> patients){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = line.split(",");
                String name = tokens[0];
                String bloodGroup = tokens[1];
                Boolean needsPlasma = Boolean.parseBoolean(tokens[2]);
                Boolean needsBlood = Boolean.parseBoolean(tokens[3]);
                String gender = tokens[4];
                int age = Integer.parseInt(tokens[5]);

                patients.add(new Patient(name, bloodGroup, needsPlasma, needsBlood, gender, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
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
