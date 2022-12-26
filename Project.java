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
    
    public static void playingCards(String[] arr) {
        Scanner sc = new Scanner(System.in);
        
        if (arr.length == 4) {
            String sequence1 = sc.next();
            switch (sequence1) {
                case "1":
                    System.out.print(arr[0]);
                    break;
                case "2":
                    System.out.print(arr[1]);
                    break;
                case "3":
                    System.out.print(arr[2]);
                    break;
                case "4":
                    System.out.print(arr[3]);
                    break;
                default:
                    System.out.print("You entered invalid sequence. ");
            }
            
            if (arr.length == 3) {
                String sequence2 = sc.next();
                switch (sequence2) {
                    case "1":
                        System.out.print(arr[0]);
                        break;
                    case "2":
                        System.out.print(arr[1]);
                        break;
                    case "3":
                        System.out.print(arr[2]);
                        break;
                    default:
                        System.out.print("You entered invalid sequence. ");
                }
            }
            
            if (arr.length == 2) {
                String sequence3 = sc.next();
                switch (sequence3) {
                    case "1":
                        System.out.print(arr[0]);
                        break;
                    case "2":
                        System.out.print(arr[1]);
                        break;
                    default:
                        System.out.print("You entered invalid sequence. ");
                }
            }
            
            if (arr.length == 1) {
                String sequence4 = sc.next();
                switch (sequence4) {
                    case "1":
                        System.out.print(arr[0]);
                        break;
                    default:
                        System.out.print("You entered invalid sequence. ");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        String[] cutDeck = new String[52];
        String[] tableCards = new String[4];
        String[] computersHand = new String[4];
        String[] playersHand = new String[4];
        int computersTotalCards = 0;
        int playersTotalCards = 0;
        String[] computersCards = new String[computersTotalCards];
        String[] playersCards = new String[playersTotalCards];
        String[] remainingDeck = new String[40];
        int computerScore = 0;
        int playerScore = 0;
        int x = 0;
        int y = 0;
        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[x] = suit + rank; //concatenating two arrays
                x++;
            }
        }
        
        String[] shuffledDeck = deck.clone();
        
        shuffleArray(shuffledDeck);

        //cutting the deck
        Random r2 = new Random();
        int cuttingPoint = r2.nextInt(shuffledDeck.length - 1);
        
        for (int i = cuttingPoint + 1; i < 52; i++) {
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
        for (int i = 0; i < computersHand.length; i++) {
            computersHand[i] = cutDeck[i + tableCards.length];
            System.out.print(computersHand[i] + " "); //checking, delete later
        }
        
        System.out.print("\nYour cards: ");

        //players hand
        for (int i = 0; i < playersHand.length; i++) {
            playersHand[i] = cutDeck[i + tableCards.length + computersHand.length];
            System.out.print(playersHand[i] + " ");
        }

        //remaining cards
        for (int i = 0; i < remainingDeck.length; i++) {
            remainingDeck[i] = cutDeck[i + tableCards.length + computersHand.length + playersHand.length];
        }
        
        System.out.print("\nEnter the sequence number of the card that you want to play: ");
        playingCards(playersHand);
        
        if (playersTotalCards > computersTotalCards) {
            playerScore += 3;
        } else if (computersTotalCards > playersTotalCards) {
            computerScore += 3;
        } else {
            playerScore += 0;
            computerScore += 0;
        }
        
        System.out.print("\nYour score: " + playerScore);
        System.out.print("\nComputers score: " + computerScore);
        
        if (computerScore > playerScore) {
            System.out.print("\nComputer wins!");
        } else if (playerScore > computerScore) {
            System.out.print("\nYou win!");
        } else {
            System.out.print("\nNobody won! Your score and computers score are equal.");
        }
    }
}
