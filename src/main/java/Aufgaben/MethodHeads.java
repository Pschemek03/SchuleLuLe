package Aufgaben;

import java.util.Scanner;

public class MethodHeads {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var rnd = (int) (Math.random() * 100);
        var rnd0 = (int) (Math.random() * 1000);

        System.out.println(MethodHeads.divideTwoNumbers(rnd, rnd));

        System.out.println("Ziffernanzahl: " + MethodHeads.ziffernAnzahl(rnd0));

        System.out.println("Mittelwert: " + new MethodHeads().mittlewertofTwo(rnd, rnd0));

        System.out.println("Teilbar durch 3: " + new MethodHeads().teilbarDUrchThreeTest(rnd));

        System.out.println("Maximum of three: " + new MethodHeads().maximumOfThree(rnd, rnd, rnd));

        System.out.println("Give me a word to check if it contains the letter E: ");
        System.out.println("Enthält e: " + new MethodHeads().enthaEltETest(sc.nextLine()));

        System.out.println("Would you mind giving me your name?");
        //System.out.println("Welcome" + new MethodHeads().welcomeMessage(sc.nextLine()));


    }




    public static double divideTwoNumbers(double x, double y) {
        return x / y;
    }

    public static int ziffernAnzahl(int zahl) {
        return String.valueOf(zahl).length();
    }

    public double mittlewertofTwo(int x, int y) {
        return (x + y) / 2.0;
    }

    public boolean teilbarDUrchThreeTest(double x) {
        return x % 3 == 0;
    }

    public double maximumOfThree(double x, double y, double z) {
        return Math.max(Math.max(x, y), z);
    }

    public boolean enthaEltETest(String s) {
        s.toLowerCase();
        return s.contains("e");
    }

    public void welcomeMessage(String name) {
        System.out.println("Welcome to the MethodHeads class!");
    }

    public boolean nameCheck(int x, int y, String name) {
        return name.length() > x && name.length() < y;
    }

    public void textUmdrehen(String text) {
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }
    }
}
