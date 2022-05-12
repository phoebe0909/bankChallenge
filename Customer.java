package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Customer {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private String name;
    private ArrayList<Double> transactions;
    private Branch myBranch;



    public Customer(String customerName,
                    double startingBalance) {
        this.transactions = new ArrayList<Double>();
        this.name = customerName;
        transactions.add(startingBalance);
    }

    public String getName() {
        return name;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double deposit){
        //already verified identity in the overloaded version.
        int index = (transactions.size()-1);
        double last = (transactions.get(index));
        double x = deposit+last;
        transactions.add(x);
        System.out.println("Deposit of " + df.format(deposit) + " has been " +
                "made. Your " +
                "new total is " + df.format(x) + ".");
    }





}
