package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Branch {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName, ArrayList<Customer> myCustomers) {
        this.customers = myCustomers;
        this.name = branchName;
    }

    public static Branch createBranch(String branchName) {
        ArrayList<Customer> myCustomers = new ArrayList<>();
        return new Branch(branchName, myCustomers);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    private Customer findCustomer(String customerName){
        for (int i = 0; i<this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }


    public boolean newCustomer(String customerName, double startingBalance) {
        if (findCustomer(customerName)!=null){
            System.out.println("Customer is already in system.");
            return false;
        }
        else {
            Customer customer = new Customer(customerName, startingBalance);
            this.customers.add(customer);
            System.out.println("Customer " + customerName + " added.");
            return true;
        }
    }

    public boolean addCustomerTransaction(double deposit, String name){
        //overloading method in customer. This is called first, then passed
        // to the customer version.
        if (findCustomer(name)==null){
            System.out.println("Customer name invalid.");
            return false;
        }
        else{
            findCustomer(name).addTransaction(deposit);
            return true;
        }
    }


}
