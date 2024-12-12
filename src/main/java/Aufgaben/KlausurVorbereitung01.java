package Aufgaben;

import java.util.Random;

public class KlausurVorbereitung01 {
    public static void main(String[] args) {
        Random rand = new Random();
        var wuoerfe = 0;
        var pkt = 0;

        for (int i = 1; i <= 3; i++) {
            wuoerfe = i;
            pkt = pkt + rand.nextInt(101);
            System.out.println("Zwischen pkt: " + pkt);
        }
        var durschnitt = pkt / wuoerfe;
        System.out.println("\npkt durschnitt ist: " + durschnitt);

        if (durschnitt < 35) {
            System.out.println("Immerhis das Brett getroffen");
        } else if (durschnitt >= 35 && durschnitt < 50) {
            System.out.println("Schwacher Freizeitspieler");
        } else if (durschnitt >= 50 && durschnitt < 60) {
            System.out.println("Durschnittlicher Freizeitspieler");
        } else if (durschnitt >= 60 && durschnitt < 70) {
            System.out.println("Starker Freizeitspieler");
        } else if (durschnitt >= 70 && durschnitt < 80) {
            System.out.println("Sehr starker Freizeitspieler");
        }else {
            System.out.println("Profi-Spieler");
        }
    }
}
