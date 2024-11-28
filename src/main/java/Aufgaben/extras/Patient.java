package Aufgaben.extras;

public class Patient {
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
