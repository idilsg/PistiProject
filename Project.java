package project;

import java.util.Random;

public class Project {

    public static void shuffleArray(String[] arr) {
        Random r1 = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = r1.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    /* public static void dealCards(String[] arr) {
        String computersCards[] = new String[4];
        String playersCards[] = new String[4];
        
        for (int i=0; i<4; i++) {
            arr[i] = computersCards[i];
        }
        
        for (int j=0; j<4; j++) {
            arr[j+4] = playersCards[j];
        }
    } */
    public static void main(String[] args) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        String[] cutDeck = new String[52];
        int x = 0;
        int y = 0;

        for (String suit : suits) {
            for (String card : cards) {
                deck[x] = suit + card; //concatenating two arrays
                x++;
            }
        }

        String[] shuffledDeck = deck.clone();

        shuffleArray(shuffledDeck);

        //cutting the deck
        Random r2 = new Random();
        int cuttingPoint = r2.nextInt(shuffledDeck.length - 1);

        for (int i = cuttingPoint + 1; i <= 51; i++) {
            cutDeck[y] = shuffledDeck[i];
            y++;
        }

        for (int j = 0; j <= cuttingPoint; j++) {
            cutDeck[y] = shuffledDeck[j];
            y++;
        }

        for (String s : cutDeck) {
            System.out.print(s + " "); //checking, delete later
        }

        System.out.print("\n---\n"); //delete later

        String table[] = new String[4];
        String remainingCards[] = new String[48];

        System.out.println("Cards on the table: ");

        for (int i = 0; i < 4; i++) {
            table[i] = cutDeck[i];
            System.out.print(table[i] + " ");
        }

        for (int j = 0; j < cutDeck.length - 4; j++) {
            remainingCards[j] = cutDeck[j + 4];
        }

        System.out.print("\n---\n"); //delete later

        for (String l : remainingCards) {
            System.out.print(l + " "); //checking, delete later  
        }

    }
}
