package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Branch {

    private String branchName;
    private ArrayList<Customer> myCustomers;

    public Branch(String branchName, ArrayList<Customer> myCustomers) {
        this.myCustomers = myCustomers;
        this.branchName = branchName;
    }

    public static Branch createBranch(String branchName) {
        ArrayList<Customer> myCustomers = new ArrayList<>();
        return new Branch(branchName, myCustomers);
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getMyCustomers() {
        return myCustomers;
    }


    public int findCustomer(String customerName){
        for (int i=0; i<this.myCustomers.size(); i++) {
            Customer customer = this.myCustomers.get(i);
            if (customer.getCustomerName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }


    public boolean addCustomer(String customerName, double startingBalance) {
        if (findCustomer(customerName)>=0){
            System.out.println("Customer is already in system.");
            return false;
        }
        else {
            this.myCustomers.add(Customer.createCustomer(customerName,
                    startingBalance));
            System.out.println("Customer " + customerName + " added.");
            return true;
        }
    }



    public void printTransactions(String name){
        int index =  findCustomer(name);
        System.out.println("Printing transactions:");
        if (index <0){
            System.out.println("Customer name invalid");
        }
        else{ //This will have to be printed in a different format.
        Customer customer = myCustomers.get(index);
        System.out.println(customer.getTransactions());
        }
    }

    public void addTransaction(double deposit, String name){
        //overloading method in customer. This is called first, then passed
        // to the customer version.
        int index = findCustomer(name);
        if (index>=0){
            Customer customer = (myCustomers.get(index));
            customer.addTransaction(deposit);
        }
        else{
            System.out.println("Customer name invalid.");
        }

    }

    public void printCustomers() {
        System.out.println("List of customers:");
        for (int i = 0; i< myCustomers.size(); i++) {
            Customer customer = myCustomers.get(i);
            customer.getCustomerName();
            System.out.println((i+1) + ". " + customer.getCustomerName());
        }
    }

    public void printCustomersAndTransactions(){
        System.out.println("List of customers:");
        for (int i = 0; i< myCustomers.size(); i++) {
            Customer customer = myCustomers.get(i);

            System.out.println((i+1) + ". " + customer.getCustomerName());
            printTransactions(customer.getCustomerName());
        }
    }


}
