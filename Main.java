package com.company;

public class Main {

    public static void main(String[] args) {

        //Test Code

        //Open a new bank and add branches.
        Bank bank = new Bank("National Australia Bank");
        bank.addBranch("Adelaide");
        bank.addBranch("Sydney");
        bank.findBranch("Adelaide");
        //Add customer accounts with initial transactions.
        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);
        bank.addCustomer("Sydney", "Joe", 50.05);
        bank.addCustomer("Sydney", "Dave", 175.34);
        //Add more transactions to existing accounts (all transactions are
        // deposits).
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
        bank.addCustomerTransaction("Adelaide", "Tim", 1.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 65);
        //List customers with transactions.
        bank.listCustomers("Adelaide", true);
        //List branch customers without transactions.
        bank.listCustomers("Sydney", false);


    }
}

