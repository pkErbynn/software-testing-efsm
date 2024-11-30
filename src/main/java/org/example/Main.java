package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

// GasPump Test Driver

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int returnValue;

        GasPump gp = new GasPump();

        display();

        try {
            // Keep the program running until user inputs "q" to quit
            while (true) {
                System.out.print("Enter an Operation to perform: ");

                userInput = scanner.nextLine();

                // Exit the loop and end the program
                if (userInput.equals("qq")) {
                    System.out.println("Entire program shutdown!...");
                    break;
                }


                switch (userInput) {

                    // Activate
                    case "1": {
                        System.out.println("Activate(float a, float d) Method");

                        System.out.print("Enter value a: ");
                        float a = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter value d: ");
                        float d = Float.parseFloat(scanner.nextLine());

                        returnValue = gp.Activate(a, d);

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");
//                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + ", L: " + gp.showL() + ", W: " + gp.showW() + ", state: " + gp.showState() + ", ");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Credit
                    case "2": {
                        System.out.println("Credit() Method");
                        returnValue = gp.Credit();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Reject
                    case "3": {
                        System.out.println("Reject() Method");
                        returnValue = gp.Reject();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() +", K: " + gp.showK() + " ]");
                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Cancel
                    case "4": {
                        System.out.println("Cancel() Method");
                        returnValue = gp.Cancel();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Approved
                    case "5": {
                        System.out.println("Approved() Method");
                        returnValue = gp.Approved();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Cash
                    case "6": {
                        System.out.println("Cash(float c) Method");

                        System.out.print("Enter value c: ");
                        float c = Float.parseFloat(scanner.nextLine());
                        returnValue = gp.Cash(c);

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Regular
                    case "7": {
                        System.out.println("Regular() Method");
                        returnValue = gp.Regular();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Diesel
                    case "8": {
                        System.out.println("Diesel() Method");
                        returnValue = gp.Diesel();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");
                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Start
                    case "9": {
                        System.out.println("Start() Method");
                        returnValue = gp.Start();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Pump
                    case "a": {
                        System.out.println("Pump() Method");
                        returnValue = gp.Pump();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Stop
                    case "b": {
                        System.out.println("Stop() Method");
                        returnValue = gp.Stop();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // NoReceipt
                    case "c": {
                        System.out.println("NoReceipt() Method");
                        returnValue = gp.NoReceipt();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // Receipt
                    case "d": {
                        System.out.println("Receipt() Method");
                        returnValue = gp.Receipt();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // TurnOff
                    case "e": {
                        System.out.println("TurnOff() Method");
                        returnValue = gp.TurnOff();

                        System.out.print("[ Price: " + gp.showPrice() + ", Total: " + gp.showTotal() + ", Cash: " + gp.showCash() + ", Rprice: " + gp.showRprice() + ", Dprice: " + gp.showDprice() + ", K: " + gp.showK() + " ]");

                        System.out.println("The value returned by the method: " + returnValue + "\n");
                        break;
                    }

                    // ===== showing internal data

                    // show price
                    case "x1": {
                        System.out.println("GasPump.showPrice() testing-oriented method");
                        System.out.println("Price = " + gp.showPrice());
                        break;
                    }

                    // show total
                    case "x2": {
                        System.out.println("GasPump.showTotal() testing-oriented method");
                        System.out.println("total = " + gp.showTotal());
                        break;
                    }

                    // show cash
                    case "x3": {
                        System.out.println("GasPump.showCash() testing-oriented method");
                        System.out.println("cash = " + gp.showCash());
                        break;
                    }

                    // show Rprice
                    case "x4": {
                        System.out.println("GasPump.showRprice() testing-oriented method");
                        System.out.println("Rprice = " + gp.showRprice());
                        break;
                    }

                    // show Dprice
                    case "x5": {
                        System.out.println("GasPump.showDprice() testing-oriented method");
                        System.out.println("Dprice = " + gp.showDprice());
                        break;
                    }

                    // show k
                    case "x6": {
                        System.out.println("GasPump.showK() testing-oriented method");
                        System.out.println("K = " + gp.showK());
                        break;
                    }

                    // show L
                    case "x7": {
                        System.out.println("GasPump.showL() testing-oriented method");
                        System.out.println("L = " + gp.showL());
                        break;
                    }

                    // show W
                    case "x8": {
                        System.out.println("GasPump.showW() testing-oriented method");
                        System.out.println("W = " + gp.showW());
                        break;
                    }

                    // quite
                    case "q": {
                        System.out.println("Program Instance quited...\n");
                        gp = new GasPump();
                        break;
                    }

                    // default
                    default: {
                        System.out.println("Error: Invalid input");
                        break;
                    }
                }
            }

            scanner.close();

        }
        catch (Exception ex)
        {
            System.out.println("Error occurred. Ending program...");
            scanner.close();
            System.exit(1);
        }

    }

    private static void display() {
        System.out.println(

                "  DRIVER for the GassPump Class\n" +
                        "\n" +
                        "         1. Activate\n" +
                        "         2. Credit\n" +
                        "         3. Reject\n" +
                        "         4. Cancel\n" +
                        "         5. Approved\n" +
                        "         6. Cash\n" +
                        "         7. Regular\n" +
                        "         8. Diesel\n" +
                        "         9. Start\n" +
                        "         a. Pump\n" +
                        "         b. Stop\n" +
                        "         c. NoReceipt\n" +
                        "         d. Receipt\n" +
                        "         e. TurnOff\n" +
                        "\n" +
                        "         Testing-related methods\n" +
                        "         x1. show price\n" +
                        "         x2. show total\n" +
                        "         x3. show cash\n" +
                        "         x4. show Rprice\n" +
                        "         x5. show Dprice\n" +
                        "         x6. show k\n" +
                        "         x7. show L\n" +
                        "         x8. show W\n" +
                        "\n" +
                        "         q. Quit GasPump driver\n" +
                        "         qq. Shutdown Program\n"
        );
    }

}