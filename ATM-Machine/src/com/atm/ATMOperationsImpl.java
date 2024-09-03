package com.atm;

import java.util.HashMap;
import java.util.Map;

public class ATMOperationsImpl implements ATMOperations {
    ATM atm = new ATM();
    Map<Double, String> statement = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount % 5 == 0){
            if(withdrawAmount <= atm.getBalance()) {
                statement.put(withdrawAmount, "Amount Withdrawn");
                System.out.println("Withdraw Amount: " + withdrawAmount);
                atm.setBalance(atm.getBalance()-withdrawAmount);
                viewBalance();
            }
            else {
                System.out.println("Insufficient Balance");
            }
        }
        else {
            System.out.println("The Amount Must Be A Multiple Of 5");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        statement.put(depositAmount, "Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully To ATM");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewStatement() {
        for (Map.Entry<Double, String> map : statement.entrySet()) {
            System.out.println(map.getKey() + " -> " + map.getValue());
        }
    }
}
