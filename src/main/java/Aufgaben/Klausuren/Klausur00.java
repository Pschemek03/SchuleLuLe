package Aufgaben.Klausuren;

import java.util.Scanner;

public class Klausur00 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        var number = sc.nextInt();

        var summ = 1;

        for (int i = 2; i <= number; i++) {
            summ *= i;

            System.out.println(summ + "\n");
        }System.out.println("\nThe sum is: " + summ);

    }
}
