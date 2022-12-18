package project;

import java.util.Random;

public class Project {

    public static void main(String[] args) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] shuffledDeck = new String[52];
        String[] cutDeck = new String[52];
        int x = 0;
        int y = 0;

        for (String suit : suits) {
            for (String card : cards) {
                shuffledDeck[x] = suit + card; //concatenating two arrays
                x++;
            }
        }

        shuffleArray(shuffledDeck);

        Random r2 = new Random();
        int cuttingPoint = r2.nextInt(shuffledDeck.length - 2) + 1;

        for (int i = cuttingPoint + 1; i <= 51; i++) {
            cutDeck[y] = shuffledDeck[i];
            y++;
        }

        for (int i = 0; i <= cuttingPoint; i++) {
            cutDeck[y] = shuffledDeck[i];
            y++;
        }

        for (String element : cutDeck) {
            System.out.print(element + " "); //checking
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
}
