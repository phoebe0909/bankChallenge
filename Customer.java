package com.company;

import java.util.ArrayList;

public class Customer {


    private String customerName;
    private ArrayList<Double> transactions;
    private double startingBalance;
    private Branch myBranch;



    public Customer(String customerName,
                    double startingBalance) {
        this.transactions = new ArrayList<Double>();
        this.customerName = customerName;
        this.startingBalance=startingBalance;
        transactions.add(startingBalance);
        //where does the branch name fit into all this?
    }


    public static Customer createCustomer(String name, double startingBalance
           ) {
        ArrayList<Double> transactions = new ArrayList<>();
        transactions.add(startingBalance);
        return new Customer(name, startingBalance);
    }

    public String getCustomerName() {
        return customerName;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double addTransaction(double deposit){
        //already verified indentity in the overloaded version.
//        int index = transactions.size();
        double last = (transactions.get(transactions.size()-1));
        double x = deposit+last;
        transactions.add(x);
        System.out.println("Deposit of " + deposit + " has been made. Your " +
                "new total is  " + x);
        return x;
    }





}
