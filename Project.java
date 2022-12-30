package project;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Project {

    static int boardTotal;
    static int computersTotalCards;
    static int playersTotalCards;
    static int computerScore;
    static int playerScore;
    static int control;
    static int computerTotal;
    static int playerTotal;
    static int check;
    static String[] deck;
    static String[] shuffledDeck;
    static String[] cutDeck;
    static String[] finalDeck;
    static String[] board;
    static String[] computersHand;
    static String[] playersHand;
    static String[] computersCards;
    static String[] playersCards;

    public static void shuffleArray() {
        Random rShuffle = new Random();
        shuffledDeck = deck.clone();

        for (int i = 0; i < shuffledDeck.length - 1; i++) {
            int index = rShuffle.nextInt(i + 1);
            String a = shuffledDeck[index];
            shuffledDeck[index] = shuffledDeck[i];
            shuffledDeck[i] = a;
        }
    }

    public static void cutDeck() {
        int y = 0;
        Random rCut = new Random();
        int cuttingPoint = rCut.nextInt(shuffledDeck.length - 1);

        for (int i = cuttingPoint + 1; i < 52; i++) {
            cutDeck[y] = shuffledDeck[i];
            y++;
        }

        for (int j = 0; j <= cuttingPoint; j++) {
            cutDeck[y] = shuffledDeck[j];
            y++;
        }

        /*for (String s : cutDeck) {
            System.out.print(s + " "); //checking, delete later
        }*/
    }

    public static void playerPlays() {
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nYour cards:");
        for (int i = 0; i < playersHand.length; i++) {
            System.out.print(" " + playersHand[i]);
        }

        System.out.print("\nEnter the sequence number of the card that you want to play: ");
        String[] tempLength3 = new String[3];
        String[] tempLength2 = new String[2];
        String[] tempLength1 = new String[1];
        String[] tempLength0 = new String[0];

        if (playersHand.length == 4) {
            while (!validInput) {
                String sequence1 = sc.next();

                switch (sequence1) {
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        System.out.print("\nCards on the table: ");
                        for (int i = 0; i < board.length; i++) {
                            System.out.print(board[i] + " ");// board
                        }
                        break;
                }

                switch (sequence1) {
                    case "1":
                        validInput = true;
                        board = Arrays.copyOf(board, board.length + 1);
                        board[board.length - 1] = playersHand[0];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        tempLength3[0] = playersHand[1];
                        tempLength3[1] = playersHand[2];
                        tempLength3[2] = playersHand[3];
                        playersHand = tempLength3;
                        break;
                    case "2":
                        validInput = true;
                        board = Arrays.copyOf(board, board.length + 1);
                        board[board.length - 1] = playersHand[1];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        tempLength3[0] = playersHand[0];
                        tempLength3[1] = playersHand[2];
                        tempLength3[2] = playersHand[3];
                        playersHand = tempLength3;
                        break;
                    case "3":
                        validInput = true;
                        board = Arrays.copyOf(board, board.length + 1);
                        board[board.length - 1] = playersHand[2];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        tempLength3[0] = playersHand[0];
                        tempLength3[1] = playersHand[1];
                        tempLength3[2] = playersHand[3];
                        playersHand = tempLength3;
                        break;
                    case "4":
                        validInput = true;
                        board = Arrays.copyOf(board, board.length + 1);
                        board[board.length - 1] = playersHand[3];
                        for (int j = 0; j < board.length; j++) {
                            System.out.print(board[j] + " "); // board
                        }
                        tempLength3[0] = playersHand[0];
                        tempLength3[1] = playersHand[1];
                        tempLength3[2] = playersHand[2];
                        playersHand = tempLength3;
                        break;
                    default:
                        System.out.print("You entered invalid sequence. Enter a valid sequence: ");
                }
                switch (sequence1) {
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        if (board.length == 2 && (board[board.length - 1].charAt(1)) == (board[board.length - 2].charAt(1))) { //pisti
                            playerScore += 10;
                            playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                            for (int j = 0; j < board.length; j++) {
                                playersCards[playerTotal] = board[j];
                                playerTotal++;
                            }
                            for (int j = 0; j < board.length; j++) {
                                board[j] = ""; //player took all cards, there is no card on the board anymore
                            }
                            check = 1;
                        } else if (board[board.length - 1].charAt(1) == board[board.length - 2].charAt(1) || board[board.length - 1].charAt(1) == 'J') {
                            playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                            for (int j = 0; j < board.length; j++) {
                                playersCards[playerTotal] = board[j];
                                playerTotal++;
                            }
                            for (int j = 0; j < board.length; j++) {
                                board[j] = ""; //player took all cards, there is no card on the board anymore
                            }
                            check = 1;
                        }
                }
            }

            if (playersHand.length == 3) {
                while (!validInput) {
                    String sequence2 = sc.next();

                    switch (sequence2) {
                        case "1":
                        case "2":
                        case "3":
                            System.out.print("\nCards on the table: ");
                            for (int i = 0; i < board.length; i++) {
                                System.out.print(board[i] + " ");// board
                            }
                            break;
                    }

                    switch (sequence2) {
                        case "1":
                            validInput = true;
                            board = Arrays.copyOf(board, board.length + 1);
                            board[board.length - 1] = playersHand[0];

                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            tempLength2[0] = playersHand[1];
                            tempLength2[1] = playersHand[2];
                            playersHand = tempLength2;
                            break;
                        case "2":
                            validInput = true;
                            board = Arrays.copyOf(board, board.length + 1);
                            board[board.length - 1] = playersHand[1];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            tempLength2[0] = playersHand[0];
                            tempLength2[1] = playersHand[2];
                            playersHand = tempLength2;
                            break;
                        case "3":
                            validInput = true;
                            board = Arrays.copyOf(board, board.length + 1);
                            board[board.length - 1] = playersHand[2];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            tempLength2[0] = playersHand[0];
                            tempLength2[1] = playersHand[1];
                            playersHand = tempLength2;
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                    switch (sequence2) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            if (board.length == 2 && (board[board.length - 1].charAt(1)) == (board[board.length - 2].charAt(1))) { //pisti
                                playerScore += 10;
                                playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                                for (int j = 0; j < board.length; j++) {
                                    playersCards[playerTotal] = board[j];
                                    playerTotal++;
                                }
                                for (int j = 0; j < board.length; j++) {
                                    board[j] = ""; //player took all cards, there is no card on the board anymore
                                }
                                check = 1;
                            } else if (board[board.length - 1].charAt(1) == board[board.length - 2].charAt(1) || board[board.length - 1].charAt(1) == 'J') {
                                playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                                for (int j = 0; j < board.length; j++) {
                                    playersCards[playerTotal] = board[j];
                                    playerTotal++;
                                }
                                for (int j = 0; j < board.length; j++) {
                                    board[j] = ""; //player took all cards, there is no card on the board anymore
                                }
                                check = 1;
                            }
                    }
                }
            }

            if (playersHand.length == 2) {
                while (!validInput) {
                    String sequence3 = sc.next();

                    switch (sequence3) {
                        case "1":
                        case "2":
                            System.out.print("\nCards on the table: ");
                            for (int i = 0; i < board.length; i++) {
                                System.out.print(board[i] + " ");// board
                            }
                            break;
                    }

                    switch (sequence3) {
                        case "1":
                            validInput = true;
                            board = Arrays.copyOf(board, board.length + 1);
                            board[board.length - 1] = playersHand[0];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            tempLength1[0] = playersHand[1];
                            playersHand = tempLength1;
                            break;
                        case "2":
                            validInput = true;
                            board = Arrays.copyOf(board, board.length + 1);
                            board[board.length - 1] = playersHand[1];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            tempLength1[0] = playersHand[0];
                            playersHand = tempLength1;
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                    switch (sequence3) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            if (board.length == 2 && (board[board.length - 1].charAt(1)) == (board[board.length - 2].charAt(1))) { //pisti
                                playerScore += 10;
                                playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                                for (int j = 0; j < board.length; j++) {
                                    playersCards[playerTotal] = board[j];
                                    playerTotal++;
                                }
                                for (int j = 0; j < board.length; j++) {
                                    board[j] = ""; //player took all cards, there is no card on the board anymore
                                }
                                check = 1;
                            } else if (board[board.length - 1].charAt(1) == board[board.length - 2].charAt(1) || board[board.length - 1].charAt(1) == 'J') {
                                playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                                for (int j = 0; j < board.length; j++) {
                                    playersCards[playerTotal] = board[j];
                                    playerTotal++;
                                }
                                for (int j = 0; j < board.length; j++) {
                                    board[j] = ""; //player took all cards, there is no card on the board anymore
                                }
                                check = 1;
                            }
                    }
                }
            }

            if (playersHand.length == 1) {
                while (!validInput) {
                    String sequence4 = sc.next();

                    switch (sequence4) {
                        case "1":
                            System.out.print("\nCards on the table: ");
                            for (int i = 0; i < board.length; i++) {
                                System.out.print(board[i] + " ");// board
                            }
                            break;
                    }

                    switch (sequence4) {
                        case "1":
                            validInput = true;
                            board = Arrays.copyOf(board, board.length + 1);
                            board[board.length - 1] = playersHand[0];
                            for (int j = 0; j < board.length; j++) {
                                System.out.print(board[j] + " "); // board
                            }
                            tempLength0 = playersHand;
                            playersHand = tempLength0;
                            break;
                        default:
                            System.out.print("You entered invalid sequence. ");
                    }
                    switch (sequence4) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            if (board.length == 2 && (board[board.length - 1].charAt(1)) == (board[board.length - 2].charAt(1))) { //pisti
                                playerScore += 10;
                                playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                                for (int j = 0; j < board.length; j++) {
                                    playersCards[playerTotal] = board[j];
                                    playerTotal++;
                                }
                                for (int j = 0; j < board.length; j++) {
                                    board[j] = ""; //player took all cards, there is no card on the board anymore
                                }
                                check = 1;
                            } else if (board[board.length - 1].charAt(1) == board[board.length - 2].charAt(1) || board[board.length - 1].charAt(1) == 'J') {
                                playersTotalCards = playersTotalCards + board.length;//taking all the cards number
                                for (int j = 0; j < board.length; j++) {
                                    playersCards[playerTotal] = board[j];
                                    playerTotal++;
                                }
                                for (int j = 0; j < board.length; j++) {
                                    board[j] = ""; //player took all cards, there is no card on the board anymore
                                }
                                check = 1;
                            }
                    }
                }
            }
        }
    }

    public static void computerPlays() {
        boolean played = false;
        if (played == false) {
            for (int i = 0; i < 4; i++) {
                char secondChar = computersHand[i].charAt(1);

                //if it can take cards with pisti or same card;
                if (board[board.length - 1].charAt(1) == secondChar) {
                    System.out.print("\nCards on the table:");
                    board = Arrays.copyOf(board, board.length + 1); //length++
                    board[board.length - 1] = computersHand[i]; //computer played

                    for (int j = 0; j < board.length; j++) {
                        System.out.print(" " + board[j]); //new board
                    }
                    computersTotalCards = computersTotalCards + board.length;//taking all the cards number
                    for (int j = 0; j < board.length; j++) {
                        computersCards[computerTotal] = board[j];
                        computerTotal++;
                    }
                    if (board.length == 2) {
                        computerScore += 10; //pisti points
                    }

                    for (int j = 0; j < board.length; j++) {
                        board[j] = ""; //computer took all cards, there is no card on the board anymore
                    }

                    //no card on the table
                    System.out.print("\nCards on the table: ");
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(board[j] + " "); //empty board
                    }

                    played = true; //other "if" won't run
                    for (int j = i; j < computersHand.length - 1; j++) {
                        computersHand[j] = computersHand[j + 1];
                    }
                    computersHand[computersHand.length - 1] = "-";
                    check = 2;

                    //if it can take all cards with jack
                } else if (secondChar == 'J') {
                    System.out.print("\nCards on the table:");
                    board = Arrays.copyOf(board, board.length + 1); //length++
                    board[board.length - 1] = computersHand[i]; //computer played
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(" " + board[j]); //new board
                    }
                    computersTotalCards = computersTotalCards + board.length;//taking all the cards number
                    for (int j = 0; j < board.length; j++) {
                        computersCards[computerTotal] = board[j];
                        computerTotal++;
                    }
                    for (int j = 0; j < board.length; j++) {
                        board[j] = ""; //computer took all cards, there is no card on the board anymore
                    }
                    System.out.print("\nCards on the table: ");
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(board[j] + " "); //empty board
                    }
                    played = true; //other "if" won't run
                    for (int j = i; j < computersHand.length - 1; j++) {
                        computersHand[j] = computersHand[j + 1];
                    }
                    computersHand[computersHand.length - 1] = "-";
                    check = 2;
                }
                break;
            }
        }

        if (played == false) {
            System.out.print("\nCards on the table:");
            board = Arrays.copyOf(board, board.length + 1); //length++
            board[board.length - 1] = computersHand[0]; //computer played his first card
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[j]); //new board
            }

            for (int j = 0; j < computersHand.length - 1; j++) {
                computersHand[j] = computersHand[j + 1];
            }
            computersHand[computersHand.length - 1] = "-";
        }

        /*System.out.print("\nComputer's cards:");
        for (int i = 0; i < computersHand.length; i++) {
            System.out.print(" " + computersHand[i]);
        } */
    }

    //for ♣2 (2 point) and ♦10 (3 point), others 1 point.
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

        //adding 1 point for every card
        if (computersTotalCards > playersTotalCards) {
            computerScore += computersTotalCards;
            //subtracting the extra scores added for special cards
            for (int i = 0; i < computersCards.length; i++) {
                if ("♣2".equals(computersCards[i])) {
                    computerScore--;
                }
                if ("♦10".equals(computersCards[i])) {
                    computerScore--;
                }
            }
        } //adding 1 point for every card
        else if (playersTotalCards > computersTotalCards) {
            playerScore += playersTotalCards;
            //subtracting the extra scores added for special cards
            for (int j = 0; j < playersCards.length; j++) {
                if ("♣2".equals(playersCards[j])) {
                    playerScore--;
                }
                if ("♦10".equals(playersCards[j])) {
                    playerScore--;
                }
            }
        }
    }

    public static void main(String[] args) {

        String[] suits = {"♠", "♣", "♥", "♦"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        deck = new String[52];
        cutDeck = new String[52];
        shuffledDeck = new String[52];
        boardTotal = 4;
        board = new String[boardTotal];
        computersHand = new String[4];
        playersHand = new String[4];
        computersTotalCards = 0;
        playersTotalCards = 0;
        computerTotal = 0;
        playerTotal = 0;
        computersCards = new String[computersTotalCards];
        playersCards = new String[playersTotalCards];
        computerScore = 0;
        playerScore = 0;
        control = 4;
        check = 0;
        int generalRound = 1;
        int miniRound = 1;

        int x = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[x] = suit + rank; //concatenating two arrays
                x++;
            }
        }

        shuffleArray();
        cutDeck = shuffledDeck.clone();
        cutDeck();
        finalDeck = cutDeck.clone();

        //System.out.print("\n---\n"); //delete later
        System.out.print("Cards on the table:");

        for (int i = 0; i < board.length; i++) {
            board[i] = finalDeck[i];
            System.out.print(" " + board[i]);
        }

        while (generalRound != 7) {
            System.out.print("\nRound " + generalRound + ": ");

            //computers hand
            //System.out.print("\nchecking computers cards:");
            for (int i = 0; i < computersHand.length; i++) {
                computersHand[i] = finalDeck[i + control];
                //System.out.print(" " + computersHand[i]);
            }
            control += 4;

            //players hand
            System.out.print("\nYour cards:");
            for (int i = 0; i < playersHand.length; i++) {
                playersHand[i] = finalDeck[i + control];
                System.out.print(" " + playersHand[i]);
            }
            control += 4;

            while (miniRound != 5) {
                computerPlays();
                playerPlays();
                miniRound++;
            }

            miniRound = 1;
            generalRound++;
        }

        //last cards on the board
        if (check == 1) {
            playersTotalCards = playersTotalCards + board.length;//taking all the cards number
            for (int j = 0; j < board.length; j++) {
                playersCards[playerTotal] = board[j];
                playerTotal++;
            }
            for (int j = 0; j < board.length; j++) {
                board[j] = ""; //player took all cards, there is no card on the board anymore
            }
        } else if (check == 2) {
            computersTotalCards = computersTotalCards + board.length;//taking all the cards number
            for (int j = 0; j < board.length; j++) {
                computersCards[playerTotal] = board[j];
                playerTotal++;
            }
            for (int j = 0; j < board.length; j++) {
                board[j] = ""; //computer took all cards, there is no card on the board anymore
            }
        }

        //final
        if (playersTotalCards > computersTotalCards) {
            playerScore += 3;
        } else if (computersTotalCards > playersTotalCards) {
            computerScore += 3;
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
