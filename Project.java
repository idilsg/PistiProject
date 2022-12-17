package project;

import java.util.Random;

public class Project {

    public static void main(String args[]) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        int x = 0;

        for (String suit : suits) {
            for (String card : cards) {
                deck[x] = suit + card; //concatenating two arrays
                x++;
            }
        }

        int k = 0; //checking

        shuffleArray(deck);
        for (String decks : deck) {
            System.out.print(deck[k] + " ");
            k++;
        }
        System.out.println("\n---\n");
        
        cuttingDeck(deck);
        for (String decks : deck) {
            System.out.print(deck[k] + " ");
            k++;
        }
    }

    public static void shuffleArray(String[] arr) {
        Random r1 = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = r1.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    public static void cuttingDeck(String[] arr) {
        Random r2 = new Random();
        int randomNum = r2.nextInt(arr.length);
        System.out.println(randomNum); //checking
        int n = 0; //first loop
        int usage = randomNum;
        int m = 0; //second loop

        if (n + randomNum - 1 != arr.length) {
            arr[usage] = arr[n];
            n++;
            usage++;
        }

        else if (m != randomNum) {
            arr[m] = arr[n+m+1];
            m++;
        }
    }
}
