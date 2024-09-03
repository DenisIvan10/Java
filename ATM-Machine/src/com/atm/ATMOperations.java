package com.atm;

public interface ATMOperations {
    public void viewBalance();
    public void withdrawAmount(double withdraw);
    public void depositAmount(double deposit);
    public void viewStatement();
}
