import Aufgaben.*;
import Aufgaben.Klausuren.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcher Programm soll jtz ran? \n1. iKauf \n2. blutSpende \n3. PokedexGUI \n4. ZwischenSummevonZahlen, \n5. 3DartWurf" +
                "\n6. KlausurAufgabe \n7. MethodenKopfAufgaben");

        var sc = new Scanner(System.in);
        var wert = sc.nextInt();

        switch (wert) {
            case 1 -> iKaufEinkauf.einkauf();
            case 2 -> bloodDonorsClinic.main(args);
            case 3 -> new PokedexGUI();
            case 4 -> KlausurVorbereitung00.main(args);
            case 5 -> KlausurVorbereitung01.main(args);
            case 6 -> Klausur00.main(args);
            case 7 -> Aufgaben.MethodHeads.main(args);
            default -> System.out.println("Die Aufgabe gibt es ja nicht mal, tschill");
        }
    }
}