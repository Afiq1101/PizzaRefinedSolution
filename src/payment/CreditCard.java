package payment;

import java.util.Scanner;


public class CreditCard implements Payment {

    @Override
    public boolean pay(double payableAmount) {
        System.out.println("Paying With Credit Card Selected.");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1 Proceed\n2 Cancel\nPlease Enter the corresponding number to proceed:");
            String selectedOption = scan.next();

            if (selectedOption.trim().equals("1")) {
                System.out.println("Enter Credit Card Number(213XXXXX):");
                int creditCardNum = scan.nextInt();
                System.out.println("Enter 6-digit pin:");
                int creditCardPin = scan.nextInt();

                if (!authCreditCard(creditCardNum, creditCardPin)) {
                    System.out.println("Authentication Error Payment Failed");
                } else {
                    System.out.println("Payment Successful With Credit Card");
                    return true;
                }
            } else if (selectedOption.trim().equals("2")) {
                return false;
            } else {
                System.out.println("Invalid Value Entered.");
            }
        }
    }

    public boolean authCreditCard(int cardNumber, int pin) {
        return true;
    }
}
