package project;

import java.util.Random;
import java.util.Scanner;

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

    public static void main(String[] args) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        String[] cutDeck = new String[52];
        String[] tableCards = new String[4];
        String[] computerCards = new String[4];
        String[] playerCards = new String[4];
        String[] remainingDeck = new String[40];       
        int computerPoint = 0;
        int playerPoint = 0;
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
        System.out.print("Cards on the table: ");

        for (int i = 0; i < tableCards.length; i++) {
            tableCards[i] = cutDeck[i];
            System.out.print(tableCards[i] + " ");
        }

        System.out.print("\nComputer's cards: "); //checking, delete later

        //computers hand
        for (int i = 0; i < computerCards.length; i++) {
            computerCards[i] = cutDeck[i + tableCards.length];
            System.out.print(computerCards[i] + " "); //checking, delete later
        }

        System.out.print("\nYour cards: ");

        //players hand
        for (int i = 0; i < playerCards.length; i++) {
            playerCards[i] = cutDeck[i + tableCards.length + computerCards.length];
            System.out.print(playerCards[i] + " ");
        }

        //remaining cards
        for (int i = 0; i < remainingDeck.length; i++) {
            remainingDeck[i] = cutDeck[i + tableCards.length + computerCards.length + playerCards.length];
        }
        
        System.out.print("\nEnter the sequence number of the card that you want to play: ");
        Scanner sc = new Scanner(System.in);
        String sequence = sc.next();
        
        switch(sequence) {
            case "1":
                System.out.print(playerCards[0]);
                break;
            case "2":
                System.out.print(playerCards[1]);
                break;
            case "3":
                System.out.print(playerCards[2]);
                break;
            case "4":
                System.out.print(playerCards[3]);
                break;
            default:
                System.out.print("You entered invalid sequence.");
        }    
    }
}
