package com.atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATMOperationsImpl operation = new ATMOperationsImpl();
        int atmnumber = 12345;
        int atmpin = 123;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To ATM Machine!");
        System.out.println("Enter ATM Number: ");
        int atmNumber = scanner.nextInt();
        System.out.println("Enter ATM Pin: ");
        int pin = scanner.nextInt();
        if((atmnumber == atmNumber) && (atmpin == pin)) {
            while(true){
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Statement\n5.Exit");
                System.out.println("Enter Choise: ");
                int choice = scanner.nextInt();
                if(choice == 1) {
                    operation.viewBalance();
                }
                else if(choice == 2) {
                    System.out.println("Enter Amount To Withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    operation.withdrawAmount(withdrawAmount);
                }
                else if(choice == 3) {
                    System.out.println("Enter Amount To Deposit: ");
                    double depositAmount = scanner.nextDouble();
                    operation.depositAmount(depositAmount);
                }
                else if(choice == 4) {
                    operation.viewStatement();
                }
                else if(choice == 5) {
                    System.out.println("Thank You For Using ATM Machine!");
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid Choice");
                }
            }
        }
        else {
            System.out.println("Incorrect ATM Number Or ATM Pin");
            System.exit(0);
        }

    }
}