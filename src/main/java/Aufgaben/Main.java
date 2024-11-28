package Aufgaben;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcher Programm soll jtz ran? \ncase 1 iKauf \ncase 2 blutSpende \ncase 3 PokedexGUI");
        Scanner sc = new Scanner(System.in);
        var wert = sc.nextInt();

        switch (wert) {
            case 1 -> iKaufEinkauf.einkauf();
            case 2 -> bloodDonorsClinic.main(args);
            case 3 -> PokedexGUI.main(args);
            default -> System.out.println("Die Aufgabe gibt es ja nicht man, tschill");
        }
    }
}