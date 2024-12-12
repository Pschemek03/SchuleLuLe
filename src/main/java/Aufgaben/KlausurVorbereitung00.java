package Aufgaben;

import java.util.Scanner;

public class KlausurVorbereitung00 {
    public static void main(String[] args) {
        System.out.println("Geben Sie nach einander 2 Zahlen ein und es wird die Summe von allen zwischen zahlen zusammen gerechnet");
        Scanner sc = new Scanner(System.in);
        var wert1 = sc.nextInt();
        var wert2 = sc.nextInt();
        var summ = 0;

        for (int i = wert1; i <= wert2; i++) {
            summ = summ + i;

            System.out.println("Die zwischensumme ist: " + summ);
        }
        System.out.println("\nDie Summe ist: " + summ + "\n\n");

    }
}
