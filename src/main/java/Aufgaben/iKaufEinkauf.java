package Aufgaben;

import java.util.Random;
import java.util.Scanner;

public class iKaufEinkauf {
    public static void einkauf() {
        Scanner sc = new Scanner(System.in);
        Random rndm = new Random();

        double iKauf = rndm.nextDouble(301);
        iKauf = Math.round(iKauf);

        System.out.println("zu bezahlen: " + iKauf + "€");

        if (iKauf > 200) {
            iKauf = (iKauf - 2*(iKauf/100));
            System.out.println("Da dein einkauf fuer mehr als 200€ ist, kriegst du von uns 2% Rabatt und muss du die liefer gebuehren nicht bezahlen, das heisst dein einkauf kostet dich: " + iKauf  + "€");
        } else if (iKauf < 100) {
            iKauf = (iKauf + 3.50);
            System.out.println("du hast weniger als 100€ bei uns ausgegeben und daswegen fallen auf dich extra 3.50€ liefer gebuehren und muss du insgesatm " + iKauf + "€ bezahlen");
        }   else {
            System.out.println("da du mehr als 100€ bei uns ausgibts, kannst du dir die liefer gebuehren sparren und bezahlst: " + iKauf + "€");
        }

    }
}
