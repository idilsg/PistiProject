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

    public static void playerPlays(String[] arr1, String[] arr2) {
        //arr1 = board, arr2 = playersHand
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the sequence number of the card that you want to play: ");

        if (arr2.length == 4) {
            while (!validInput) {
                String sequence1 = sc.next();
                System.out.print("\nCards on the table: ");
                for (int i = 0; i < arr1.length; i++) {
                    System.out.print(arr1[i] + " ");// board
                }
                switch (sequence1) {
                    case "1":
                        System.out.print(arr2[0]);
                        validInput = true;
                        break;
                    case "2":
                        System.out.print(arr2[1]);
                        validInput = true;
                        break;
                    case "3":
                        System.out.print(arr2[2]);
                        validInput = true;
                        break;
                    case "4":
                        System.out.print(arr2[3]);
                        validInput = true;
                        break;
                    default:
                        System.out.print("You entered invalid sequence. Enter a valid sequence: ");
                }
            }

            if (arr2.length == 3) {
                while (!validInput) {
                    String sequence2 = sc.next();
                    System.out.print("\nCards on the table: ");
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.print(arr1[i] + " ");// board
                    }
                    switch (sequence2) {
                        case "1":
                            System.out.print(arr2[0]);
                            validInput = true;
                            break;
                        case "2":
                            System.out.print(arr2[1]);
                            validInput = true;
                            break;
                        case "3":
                            System.out.print(arr2[2]);
                            validInput = true;
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                }
            }

            if (arr2.length == 2) {
                while (!validInput) {
                    String sequence3 = sc.next();
                    System.out.print("\nCards on the table: ");
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.print(arr1[i] + " ");// board
                    }
                    switch (sequence3) {
                        case "1":
                            System.out.print(arr2[0]);
                            validInput = true;
                            break;
                        case "2":
                            System.out.print(arr2[1]);
                            validInput = true;
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                }
            }

            if (arr2.length == 1) {
                while (!validInput) {
                    String sequence4 = sc.next();
                    System.out.print("\nCards on the table: ");
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.print(arr1[i] + " ");// board
                    }
                    switch (sequence4) {
                        case "1":
                            System.out.print(arr2[0]);
                            validInput = true;
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                }
            }
        }
    }

    public static void computerPlays(String[] board, String[] ch, String[] cc, int a, int b, int c) {
        //ch = computersHand, cc = computersCards, a = computerScore, b = boardTotal, c = computersTotalCards
        for (int i = 0; i < 4; i++) {
            char secondChar = ch[i].charAt(1);

            if (board[board.length - 1].charAt(1) == secondChar && board.length == 1) { //if it can make pisti;
                System.out.print("\nCards on the table : ");
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[j] + " "); //board
                }
                System.out.print(ch[i]); //card that computer played
                a += 10;
                b++;
                board[board.length] = ch[i];
            } else {
                System.out.print("\nCards on the table: ");
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[j] + " ");//board
                }
                System.out.print(ch[0]); //card that computer played
                b++;
                board[board.length-1] = ch[0];
            }
            break;
        }

        //checking, delete later
        System.out.print("\nComputer's cards: ");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
    }

    public static void main(String[] args) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        String[] cutDeck = new String[52];
        int boardTotal = 4;
        String[] board = new String[boardTotal];
        String[] computersHand = new String[4];
        String[] playersHand = new String[4];
        int computersTotalCards = 0; //bilgisayar, masadaki kartları aldıkça artır.
        int playersTotalCards = 0; //oyuncu, masadaki kartları aldıkça artır.
        int remainingCards = 48;
        String[] computersCards = new String[computersTotalCards];
        String[] playersCards = new String[playersTotalCards];
        String[] remainingDeck = new String[remainingCards];
        int computerScore = 0;
        int playerScore = 0;
        int generalRound = 1;
        int miniRound = 1;
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

        String[] finalDeck = cutDeck.clone();

        System.out.print("\n---\n"); //delete later
        System.out.print("Cards on the table: ");

        for (int i = 0; i < board.length; i++) {
            board[i] = finalDeck[i];
            System.out.print(board[i] + " ");
        }

        while (generalRound != 7) {
            System.out.print("\nComputer's cards: "); //checking, delete later

            //computers hand
            for (int i = 0; i < computersHand.length; i++) {
                computersHand[i] = finalDeck[i + 4];
                System.out.print(computersHand[i] + " "); //checking, delete later
            }

            System.out.print("\nYour cards: ");

            //players hand
            for (int i = 0; i < playersHand.length; i++) {
                playersHand[i] = finalDeck[i + 8];
                System.out.print(playersHand[i] + " ");
            }

            //remaining cards
            System.out.print("\n" + remainingCards); //checking, delete later
            remainingCards = remainingCards - 8;
            System.arraycopy(finalDeck, 12, remainingDeck, 0, 40);
            System.out.print("\n" + remainingCards); //checking, delete later

            while (miniRound != 5) {
                computerPlays(board, computersHand, computersCards, computerScore, boardTotal, computersTotalCards);
                playerPlays(board, playersHand);
                miniRound++;
            }
            miniRound = 1;
            generalRound++;
        }

        //final
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
