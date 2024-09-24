import Aufgaben.iKaufEinkauf;
import Aufgaben.bloodDonorsClinic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcher Programm soll jtz ran? \ncase 1 iKauf \ncase 2 blutSpende" );
        Scanner sc = new Scanner(System.in);
        var wert = sc.nextInt();

        switch (wert){
            case 1:
                iKaufEinkauf.einkauf();
                break;
            case 2: bloodDonorsClinic.main();
                break;
            default: System.out.println("Die Aufgabe gibt es ja nicht man, tschill");
        }

    }
}