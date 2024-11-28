package Aufgaben.extras;

public class Donor {
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
        return isBloodCompatible(patient.getBloodGroup());
    }

    private boolean isBloodCompatible(String patientBloodGroup) {
        return switch (this.bloodGroup){
            case "0-" -> true;
            case "0+" -> patientBloodGroup.equals("0+") || patientBloodGroup.equals("B+") || patientBloodGroup.equals("A+") || patientBloodGroup.equals("AB+");
            case "AB-" -> patientBloodGroup.equals("AB+") || patientBloodGroup.equals("AB-");
            case "AB+" -> patientBloodGroup.equals("AB+");
            case "B-" -> patientBloodGroup.equals("B+") || patientBloodGroup.equals("B-") || patientBloodGroup.equals("AB+") || patientBloodGroup.equals("AB-");
            case "B+" -> patientBloodGroup.equals("B+") || patientBloodGroup.equals("AB+");
            case "A-" -> patientBloodGroup.equals("A+") || patientBloodGroup.equals("A-") || patientBloodGroup.equals("AB+") || patientBloodGroup.equals("AB-");
            case "A+" -> patientBloodGroup.equals("A+") || patientBloodGroup.equals("AB+");
            default -> false;
        };
    }

    public boolean canDonatePlasma(Patient patient) {return isPlasmaCompatible(patient.getBloodGroup());}

    private boolean isPlasmaCompatible (String patientBloodGroup) {
        return switch (this.bloodGroup){
            case "AB+" -> true;
            case "AB-" -> patientBloodGroup.equals("AB-") || patientBloodGroup.equals("A-") || patientBloodGroup.equals("B-") || patientBloodGroup.equals("0-");
            case "A+" -> patientBloodGroup.equals("A+") || patientBloodGroup.equals("A-") || patientBloodGroup.equals("0-");
            case "A-" -> patientBloodGroup.equals("A-") || patientBloodGroup.equals("0-");
            case "B+" -> patientBloodGroup.equals("B+") || patientBloodGroup.equals("B-") || patientBloodGroup.equals("0+");
            case "B-" -> patientBloodGroup.equals("B-") || patientBloodGroup.equals("0-");
            case "0+" -> patientBloodGroup.equals("0+");
            case "0-" -> patientBloodGroup.equals("0-");
            default -> false;
        };

    }

    @Override
    public String toString() {
        return name + "(" + bloodGroup + ")";
    }
}
