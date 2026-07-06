package com.bridgeLabz.Oops_Problems;
import java.util.ArrayList;
import java.util.Scanner;

// This class represents one stock and stores its basic details.
class Stock {

    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    // Constructor to initialize the stock object.
    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    // Returns the stock name.
    public String getStockName() {
        return stockName;
    }

    // Returns the number of shares.
    public int getNumberOfShares() {
        return numberOfShares;
    }

    // Returns the share price.
    public double getSharePrice() {
        return sharePrice;
    }

    // Calculates the total value of this stock.
    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }
}

// This class maintains the complete stock portfolio.
class StockPortfolio {

    // ArrayList is used because the number of stocks depends on user input.
    private ArrayList<Stock> stocks = new ArrayList<>();

    // Adds a stock object to the portfolio.
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    // Calculates the total value of all the stocks.
    public double calculateTotalPortfolioValue() {

        double total = 0;

        for (Stock stock : stocks) {
            total += stock.calculateStockValue();
        }

        return total;
    }

    // Displays the stock report in a readable format.
    public void displayStockReport() {

        System.out.println("\n============== STOCK REPORT ==========");

        for (Stock stock : stocks) {

            System.out.println("----------------------------------");
            System.out.println("Stock Name      : " + stock.getStockName());
            System.out.println("Number of Shares: " + stock.getNumberOfShares());
            System.out.println("Share Price     : " + stock.getSharePrice());

            System.out.printf("Stock Value     : %.2f%n",
                    stock.calculateStockValue());
        }

        System.out.println("----------------------------------");
        System.out.printf("Total Stock Value : %.2f%n",
                calculateTotalPortfolioValue());

        System.out.println("==================================");
    }
}

// Driver class where the program starts.
public class StockAccountManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockPortfolio portfolio = new StockPortfolio();

        System.out.println("===== Stock Account Management =====");

        // Read how many stocks the user wants to enter.
        System.out.print("Enter the number of stocks: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Read details for each stock one by one.
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for Stock " + i);

            System.out.print("Stock Name: ");
            String name = sc.nextLine();

            System.out.print("Number of Shares: ");
            int shares = sc.nextInt();

            System.out.print("Share Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // Consume newline before reading next stock name.

            // Create a stock object using the entered details.
            Stock stock = new Stock(name, shares, price);

            // Add the stock to the portfolio.
            portfolio.addStock(stock);
        }

        // Finally display the complete stock report.
        portfolio.displayStockReport();

        sc.close();
    }
}