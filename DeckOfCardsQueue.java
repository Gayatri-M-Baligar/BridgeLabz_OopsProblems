package com.bridgeLabz.Oops_Problems;

import java.util.Random;

// Stores one card
class Card {
    String suit;
    String rank;

    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    int getRankValue() {
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        for(int i=0;i<ranks.length;i++){
            if(rank.equals(ranks[i])){
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}

// Node for linked list queue
class Node {
    Card card;
    Node next;

    Node(Card card) {
        this.card = card;
    }
}

// Queue implemented using linked list
class CardQueue {

    Node front;
    Node rear;

    void enqueue(Card card) {
        Node newNode = new Node(card);

        if(front == null){
            front = rear = newNode;
        } else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    void display() {
        Node temp = front;

        while(temp != null){
            System.out.println(temp.card);
            temp = temp.next;
        }
    }
}

// Player object
class Player {

    String name;
    Card[] cards = new Card[9];
    CardQueue queue = new CardQueue();

    Player(String name){
        this.name = name;
    }

    // Sort cards according to rank
    void sortCards(){

        for(int i=0;i<cards.length-1;i++){

            for(int j=i+1;j<cards.length;j++){

                if(cards[i].getRankValue() > cards[j].getRankValue()){

                    Card temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    // Put sorted cards into queue
    void addCardsToQueue(){

        for(int i=0;i<cards.length;i++){
            queue.enqueue(cards[i]);
        }
    }

    void displayCards(){

        System.out.println("\n" + name + " Cards");
        System.out.println("----------------------");
        queue.display();
    }
}

// Queue for players
class PlayerNode{

    Player player;
    PlayerNode next;

    PlayerNode(Player player){
        this.player = player;
    }
}

class PlayerQueue{

    PlayerNode front;
    PlayerNode rear;

    void enqueue(Player player){

        PlayerNode newNode = new PlayerNode(player);

        if(front == null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    void displayPlayers(){

        PlayerNode temp = front;

        while(temp != null){

            temp.player.displayCards();
            temp = temp.next;
        }
    }
}

public class DeckOfCardsQueue {

    public static void main(String[] args) {

        String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        Card[] deck = new Card[52];

        int index = 0;

        // Create deck
        for(int i=0;i<suits.length;i++){

            for(int j=0;j<ranks.length;j++){

                deck[index] = new Card(suits[i],ranks[j]);
                index++;
            }
        }

        // Shuffle deck
        Random random = new Random();

        for(int i=0;i<deck.length;i++){

            int randomIndex = random.nextInt(52);

            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        Player[] players = new Player[4];

        for(int i=0;i<4;i++){
            players[i] = new Player("Player " + (i+1));
        }

        index = 0;

        // Distribute cards
        for(int i=0;i<4;i++){

            for(int j=0;j<9;j++){

                players[i].cards[j] = deck[index];
                index++;
            }

            players[i].sortCards();
            players[i].addCardsToQueue();
        }

        PlayerQueue playerQueue = new PlayerQueue();

        for(int i=0;i<4;i++){
            playerQueue.enqueue(players[i]);
        }

        System.out.println("===== Players and Their Cards =====");
        playerQueue.displayPlayers();
    }
}
