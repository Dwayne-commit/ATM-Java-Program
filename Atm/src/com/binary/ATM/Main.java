package com.binary.ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to make transactions.");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int cho = sc.nextInt();
        if(cho == 1){
            System.out.println("Enter a card number");
            long crd = sc.nextLong();
            System.out.println("Enter a pin number");
            int in = sc.nextInt();
            System.out.println("Enter your balance");
            double b = sc.nextDouble();
            Bank ba = new Bank(crd,b,in);

            System.out.println("Enter a number to perform a transaction");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");

            int ch;
            do{
                ch = sc.nextInt();
                switch(ch){
                    case 1:
                        ba.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter the amount: ");
                        double bal = sc.nextDouble();
                        ba.depositMoney(bal);
                        break;
                    case 3:
                        System.out.println("Enter the amount: ");
                        double ball = sc.nextDouble();
                        ba.withdrawMoney(ball);
                        break;
                    case 4:
                        System.out.println("Enter PIN number: ");
                        int h = sc.nextInt();
                        if(h == ba.getPin()){
                            System.out.println("Enter new PIN: ");
                            int uh = sc.nextInt();
                            ba.changePIN(h,uh);
                        } else if(h != ba.getPin()){
                            System.out.println("Invalid Entry");
                    }
                        break;
                }

            }while(ch != 5);
            System.out.println("Thank you!");
        } else if(cho == 2){
            System.out.println("Thanks");
        }
    }
}
