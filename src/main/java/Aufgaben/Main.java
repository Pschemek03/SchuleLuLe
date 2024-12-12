package Aufgaben;

import java.util.Scanner;

public class        Main {
    public static void main(String[] args) {
        System.out.println("welcher Programm soll jtz ran? \n1. iKauf \n2. blutSpende \n3. PokedexGUI");
        Scanner sc = new Scanner(System.in);
        var wert = sc.nextInt();

        switch (wert) {
            case 1 -> iKaufEinkauf.einkauf();
            case 2 -> bloodDonorsClinic.main(args);
            case 3 -> PokedexGUI.main(args);
            default -> System.out.println("Die Aufgabe gibt es ja nicht mal, tschill");
        }
    }
}