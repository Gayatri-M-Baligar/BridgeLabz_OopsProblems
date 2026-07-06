package com.bridgeLabz.Oops_Problems;
import java.util.Random;
// This program creates a deck of 52 cards, shuffles them
// and distributes 9 cards to 4 players.
public class DeckOfCards {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King", "Ace"};
        // Array to store all 52 cards.
        String[] deck = new String[52];
        int index = 0;
        // Create the deck by combining rank and suit.
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        // Shuffle the deck using Random class.
        Random random = new Random();

        for (int i = 0; i < deck.length; i++) {

            int randomIndex = random.nextInt(52);

            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        // 2D array to store cards for 4 players.
        String[][] players = new String[4][9];

        int cardIndex = 0;

        // Distribute 9 cards to each player.
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 9; j++) {

                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        // Display cards received by each player.
        System.out.println("\n========== Cards Distributed ==========\n");

        for (int i = 0; i < 4; i++) {

            System.out.println("Player " + (i + 1) + " Cards");

            System.out.println("---------------------------");

            for (int j = 0; j < 9; j++) {

                System.out.println(players[i][j]);
            }

            System.out.println();
        }
    }
}
