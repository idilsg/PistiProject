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
        
        shuffleArray(deck);
    }

    public static void shuffleArray(String[] arr) {
        Random r = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }
}
