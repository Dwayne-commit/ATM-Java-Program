package com.binary.ATM;

import java.util.Scanner;

public class Bank implements Bankin{

    private long crdNum;
    private double balance;
    private int pin;

    public Bank(long crdNum, double balance, int pin){
        this.crdNum = crdNum;
        this.balance = balance;
        this.pin = pin;
    }

    public void setCrdNum(long crdNum){
        this.crdNum = crdNum;
    }

    public long getCrdNum(){
        return this.crdNum;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public int getPin(){
        return this.pin;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "crdNum=" + crdNum +
                ", balance=" + balance +
                ", pin=" + pin +
                '}';
    }

    @Override
    public void checkBalance(){
        System.out.println("Enter card Number: ");
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int i = 0;
        while(i != 1) {
            if (num == getCrdNum()) {
                System.out.println("Your Current Balance is: " + getBalance());
                i++;
            } else if (num != getCrdNum()) {
                System.out.println("Invalid Entry");
                num = sc.nextLong();
            }
        }
    }

    @Override
    public void depositMoney(double amount){
        System.out.println("Enter PIN: ");
        Scanner scan = new Scanner(System.in);
        int c = 0;
        int pi = scan.nextInt();
        while(c != 1){
        if(pi == getPin()){
            double nbal = getBalance() + amount;
            System.out.println("Your new balance is: " + nbal);
            setBalance(nbal);
            c++;
        } else if(pi != getPin()){ System.out.println("Invalid Entry"); pi = scan.nextInt();}
        }
    }

    @Override
    public void withdrawMoney(double amount){
        System.out.println("Enter PIN: ");
        Scanner dc = new Scanner(System.in);
        int c = 0;
        int pi = dc.nextInt();
        while(c != 1){
            if(pi == getPin()){
                double nbal = getBalance() - amount;
                System.out.println("Success" + " " + amount + " " + "Withdrawn");
                setBalance(nbal);
                System.out.println("New Balance: " + getBalance());
                c++;
            } else if(pi != getPin()){ System.out.println("Invalid Entry"); pi = dc.nextInt();}
        }
    }

    @Override
    public void changePIN(int oldPIN, int newPIN){
        if(oldPIN == getPin()) {
            setPin(newPIN);
            System.out.println("New Pin: " + getPin());
        } else if(oldPIN != getPin()) {
            System.out.println("Invalid PIN!");
        }
    }
}

