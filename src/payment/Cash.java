package payment;

import java.util.Scanner;


public class Cash implements Payment {

    @Override
    public boolean pay(double payableAmount) {
        System.out.println("Paying With Cash Selected.");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1 Proceed\n2 Cancel\nPlease Enter the corresponding number to proceed:");
            String selectedOption = scan.next();

            if (selectedOption.trim().equals("1")) {
                System.out.println("Enter the amount of cash received:");
                double amountReceived = scan.nextDouble();

                if (amountReceived < payableAmount) {
                    System.out.println("Insufficient Amount Enter Again.");
                } else {
                    System.out.println("Customer's Balance(RM):" + (amountReceived - payableAmount));
                    return true;
                }
            } else if (selectedOption.trim().equals("2")) {
                return false;
            } else {
                System.out.println("Invalid Value Entered.");
            }
        }
    }
}


