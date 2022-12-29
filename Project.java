package project;

import java.util.Random;
import java.util.Scanner;

public class Project {

    private static String[] board;
    private static String[] computersHand;
    private static String[] playersHand;
    private static String[] computersCards;
    private static String[] playersCards;
    private static String[] remainingDeck;
    private static int boardTotal;
    private static int computersTotalCards;
    private static int playersTotalCards;
    private static int remainingCards;
    private static int computerScore;
    private static int playerScore;

    public static void shuffleArray(String[] arr) {
        Random r1 = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = r1.nextInt(i + 1);
            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    public static void playerPlays() {
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the sequence number of the card that you want to play: ");

        if (playersHand.length == 4) {
            while (!validInput) {
                String sequence1 = sc.next();
                System.out.print("\nCards on the table: ");
                for (int i = 0; i < board.length; i++) {
                    System.out.print(board[i] + " ");// board
                }
                switch (sequence1) {
                    case "1":
                        System.out.print(playersHand[0]);
                        validInput = true;
                        boardTotal++;
                        board[board.length] = playersHand[0];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        break;
                    case "2":
                        System.out.print(playersHand[1]);
                        validInput = true;
                        boardTotal++;
                        board[board.length] = playersHand[1];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        break;
                    case "3":
                        System.out.print(playersHand[2]);
                        validInput = true;
                        boardTotal++;
                        board[board.length] = playersHand[2];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        break;
                    case "4":
                        System.out.print(playersHand[3]);
                        validInput = true;
                        boardTotal++;
                        board[board.length] = playersHand[3];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        break;
                    default:
                        System.out.print("You entered invalid sequence. Enter a valid sequence: ");
                }
            }

            if (playersHand.length == 3) {
                while (!validInput) {
                    String sequence2 = sc.next();
                    System.out.print("\nCards on the table: ");
                    for (int i = 0; i < board.length; i++) {
                        System.out.print(board[i] + " ");// board
                    }
                    switch (sequence2) {
                        case "1":
                            System.out.print(playersHand[0]);
                            validInput = true;
                            boardTotal++;
                            board[board.length] = playersHand[0];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            break;
                        case "2":
                            System.out.print(playersHand[1]);
                            validInput = true;
                            boardTotal++;
                            board[board.length] = playersHand[1];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            break;
                        case "3":
                            System.out.print(playersHand[2]);
                            validInput = true;
                            boardTotal++;
                            board[board.length] = playersHand[2];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                }
            }

            if (playersHand.length == 2) {
                while (!validInput) {
                    String sequence3 = sc.next();
                    System.out.print("\nCards on the table: ");
                    for (int i = 0; i < board.length; i++) {
                        System.out.print(board[i] + " ");// board
                    }
                    switch (sequence3) {
                        case "1":
                            System.out.print(playersHand[0]);
                            validInput = true;
                            boardTotal++;
                            board[board.length] = playersHand[0];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            break;
                        case "2":
                            System.out.print(playersHand[1]);
                            validInput = true;
                            boardTotal++;
                            board[board.length] = playersHand[1];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                }
            }

            if (playersHand.length == 1) {
                while (!validInput) {
                    String sequence4 = sc.next();
                    System.out.print("\nCards on the table: ");
                    for (int i = 0; i < board.length; i++) {
                        System.out.print(board[i] + " ");// board
                    }
                    switch (sequence4) {
                        case "1":
                            System.out.print(playersHand[0]);
                            validInput = true;
                            boardTotal++;
                            board[board.length] = playersHand[0];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                }
            }
        }
    }

    public static void computerPlays() {
        for (int i = 0; i < 4; i++) {
            char secondChar = computersHand[i].charAt(1);

            //if it can make pisti;
            if (board[board.length].charAt(1) == secondChar && board.length == 1) {
                System.out.print("\nCards on the table : ");
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[j] + " "); //board
                }
                System.out.print(computersHand[i]); //card that computer played
                computerScore += 10;
                boardTotal++;
                board[board.length] = computersHand[i]; //new board

            }
        }

        System.out.print("\nCards on the table: ");
        for (int j = 0; j < board.length; j++) {
            System.out.print(board[j] + " "); //board
        }
        System.out.print(computersHand[0]); //card that computer played
        boardTotal++;
        board[board.length] = computersHand[0]; //new board

        //checking, delete later
        System.out.print("\nComputer's cards: ");
        for (int i = 0; i < computersHand.length; i++) {
            System.out.print(computersHand[i] + " ");
        }
    }

    //for ♣2 (2 point) and ♦10 (3 point)
    public static void scoring() {
        for (int i = 0; i < computersCards.length; i++) {
            if ("♣2".equals(computersCards[i])) {
                computerScore += 2;
            }
            if ("♦10".equals(computersCards[i])) {
                computerScore += 3;
            }
        }

        for (int j = 0; j < playersCards.length; j++) {
            if ("♣2".equals(playersCards[j])) {
                playerScore += 2;
            }
            if ("♦10".equals(playersCards[j])) {
                playerScore += 3;
            }
        }
    }

    public static void main(String[] args) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        String[] cutDeck = new String[52];
        board = new String[boardTotal];
        boardTotal = 4;
        computersHand = new String[4];
        playersHand = new String[4];
        computersCards = new String[computersTotalCards];
        playersCards = new String[playersTotalCards];
        remainingDeck = new String[remainingCards];
        computersTotalCards = 0; //bilgisayar, masadaki kartları aldıkça artır.
        playersTotalCards = 0; //oyuncu, masadaki kartları aldıkça artır.
        remainingCards = 48;
        computerScore = 0;
        playerScore = 0;
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
            System.arraycopy(finalDeck, 12, remainingDeck, 0, remainingCards);
            System.out.print("\n" + remainingCards); //checking, delete later

            while (miniRound != 5) {
                computerPlays();
                playerPlays();
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

        //adding 1 point for every card
        if (computersTotalCards > playersTotalCards) {
            computerScore += computersTotalCards;

            //subtracting the extra scores added for special cards
            for (int i = 0; i < computersCards.length; i++) {
                if ("♣2".equals(computersCards[i])) {
                    computerScore--;
                    break;
                }
                if ("♦10".equals(computersCards[i])) {
                    computerScore--;
                    break;
                }
            }
        } //adding 1 point for every card
        else if (playersTotalCards > computersTotalCards) {
            playerScore += playersTotalCards;

            //subtracting the extra scores added for special cards
            for (int j = 0; j < playersCards.length; j++) {
                if ("♣2".equals(playersCards[j])) {
                    playerScore--;
                    break;
                }
                if ("♦10".equals(playersCards[j])) {
                    playerScore--;
                    break;
                }
            }
        }

        scoring();

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
