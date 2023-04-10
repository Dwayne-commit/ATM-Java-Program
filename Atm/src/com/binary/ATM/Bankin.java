package com.binary.ATM;

public interface Bankin {

    void checkBalance();

    void depositMoney(double amount);

    void withdrawMoney(double amount);

    void changePIN(int oldPIN, int newPIN);
}
