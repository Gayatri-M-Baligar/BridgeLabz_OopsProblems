package com.bridgeLabz.Oops_Problems;
import java.util.Scanner;

class Account {
    // This class stores the account details and performs account operations.
    private String accountHolderName;
    private double balance;
    // Constructor to initialize account details.
    public Account(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    // Displays the current account details.
    public void displayAccountDetails() {
        System.out.println("\nAccount Holder : " + accountHolderName);
        System.out.println("Current Balance : " + balance);
    }
    // Adds money to the account.
    public void credit(double amount) {
        balance = balance + amount;
        System.out.println("Amount Credited Successfully.");
    }

    // Withdraws money only if enough balance is available.
    public void debit(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount Debited Successfully.");
        } else {
            System.out.println("Debit amount exceeded account balance.");
        }
    }
    // Returns the current balance.
    public double getBalance() {
        return balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Account Management =====");
        // Read account details from the user.
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        // Create the account object.
        Account account = new Account(name, balance);
        // Show initial account details.
        account.displayAccountDetails();
        // Deposit money.
        System.out.print("\nEnter amount to credit: ");
        double creditAmount = sc.nextDouble();
        account.credit(creditAmount);
        System.out.println("Balance after credit: " + account.getBalance());
        // Withdraw money.
        System.out.print("\nEnter amount to debit: ");
        double debitAmount = sc.nextDouble();
        account.debit(debitAmount);
        // Display final balance.
        System.out.println("Final Balance: " + account.getBalance());
    }
}