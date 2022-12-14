package payment;

import java.util.Scanner;


public class QRpay implements Payment {

    @Override
    public boolean pay(double payableAmount) {
        System.out.println("Paying With QR Selected.");
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1 Proceed\n2 Cancel\nPlease Enter the corresponding number to proceed:");
            String selectedOption = scan.next();

            if (selectedOption.trim().equals("1")) {
                System.out.println("Enter QR Transaction Token:");
                String QRNum = scan.nextLine();

                if (!authQRpay(QRNum)) {
                    System.out.println("Authentication Error Payment Failed");
                } else {
                    System.out.println("Payment Successful With QR Pay");
                    return true;
                }
            } else if (selectedOption.trim().equals("2")) {
                return false;
            } else {
                System.out.println("Invalid Value Entered.");
            }
        }
    }

    public boolean authQRpay(String transactionToken) {
        return true;
    }
}



