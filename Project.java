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
        cuttingDeck(deck);
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
    
    public static void cuttingDeck (String[] arr) {
        Random r2 = new Random();
        int n = 0; //first loop
        int use1 = r2.nextInt();
        int m = 0; //second loop
        int use2 = r2.nextInt();
        
        if (n + r2 + 1 != arr.length) {
            arr[use1] = n;
            n++;
            use1++;
        }
        
        if (m != r2) {
            arr[m] = use2;
            m++;
            use2++;
        }
    }
}
