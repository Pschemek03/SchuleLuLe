package Aufgaben;

class Patient {
    String name;
    String bloodGroup;
    boolean needsPlasma;
    boolean needsBlood;
    String gender;
    int age;

    public Patient(String name, String bloodGroup, boolean needsPlasma, boolean needsBlood, String gender, int age) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.needsPlasma = needsPlasma;
        this.needsBlood = needsBlood;
        this.gender = gender;
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public boolean getNeedsPlasma() {
        return needsPlasma;
    }

    public boolean getNeedsBlood() {
        return needsBlood;
    }

    @Override //testin Override in Java for code readability flow
    public String toString() {
        return name + " (" + bloodGroup + ")";
    }
}

class Donor {
    String name;
    String bloodGroup;
    String gender;
    int age;

    public Donor(String name, String bloodGroup, String gender, int age) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public boolean canDonateBlood(Patient patient) {
        return switch (this.bloodGroup){
            case "0-" -> true;
            case "0+" -> patient.getBloodGroup().equals("0+") || patient.getBloodGroup().equals("B+") || patient.getBloodGroup().equals("A+") || patient.getBloodGroup().equals("AB+");
            case "AB-" -> patient.getBloodGroup().equals("AB+") || patient.getBloodGroup().equals("AB-");
            case "AB+" -> patient.getBloodGroup().equals("AB+");
            case "B-" -> patient.getBloodGroup().equals("B+") || patient.getBloodGroup().equals("B-") || patient.getBloodGroup().equals("AB+") || patient.getBloodGroup().equals("AB-");
            case "B+" -> patient.getBloodGroup().equals("B+") || patient.getBloodGroup().equals("AB+");
            case "A-" -> patient.getBloodGroup().equals("A+") || patient.getBloodGroup().equals("A-") || patient.getBloodGroup().equals("AB+") || patient.getBloodGroup().equals("AB-");
            case "A+" -> patient.getBloodGroup().equals("A+") || patient.getBloodGroup().equals("AB+");
            default -> false;
        };
    }

    public boolean canDonatePlasma(Patient patient) {
        return switch (this.bloodGroup){
          case "AB+" -> true;
          case "AB-" -> patient.getBloodGroup().equals("AB-") || patient.getBloodGroup().equals("A-") || patient.getBloodGroup().equals("B-") || patient.getBloodGroup().equals("0-");

          default -> false;
        };

    }

}

public class blutSpendeKlinik {

}
