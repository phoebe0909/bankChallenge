package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private ArrayList<Branch> branches;
    private String name;

    public Bank(String name) {//done
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {//done
        if (findBranch(branchName)!=null){
            System.out.println("Branch already exists.");
            return  false;
        }
        else {
            this.branches.add(Branch.createBranch(branchName));
            System.out.println("New branch added -- " + branchName);
            return true;
        }
    }

    public boolean addCustomer(String branchName, String customerName,
                               double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        } else {//I had this method checking for customer validity, but that
            // already happens in newCustomer.
            return branch.newCustomer(customerName, transaction);
        }
    }


    public void addBranch(Branch branchName) {
        if(findBranch(branchName.getName())!=null){
            System.out.println("Branch already exists.");
        }
        else{
            branches.add(branchName);
            System.out.println("New branch added -- " + branchName);
        }
    }

    public Branch findBranch(String branchString) {
        //this now returns a branch rather than an index number;
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branchName = this.branches.get(i);
            if (branchName.getName().equals(branchString)) {
                return branchName;
            }
        }
        return null;
    }

    public boolean  addCustomerTransaction(String branchName,String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        } else {
            return branch.addCustomerTransaction(transaction,
                    customerName);
        }
    }

    public boolean listCustomers(String branchName, boolean alsoPrintTransactions){
        Branch branch = (findBranch(branchName));
        if(branch==null){
           return false;
       }
       else {
           System.out.println("Customer details for branch " + branchName);
           int scope = (branch.getCustomers().size());
           if (alsoPrintTransactions){//Names and Transactions
                for (int i = 0; i< scope ; i++) {
                    Customer customer = branch.getCustomers().get(i);
System.out.println("Customer: " + customer.getName() + "["+ (i+1) + "]");
                    System.out.println("Transactions:");
                    int scope2 = (customer.getTransactions().size());
                       for (int x = 0 ; x< scope2; x++){
                           System.out.println(" " + " " + "      [" + (x + 1) + "]. "  + df.format(customer.getTransactions().get(x)));
                          }
                }

           }
           else{//Names only
                System.out.println("List of customers:");
                for (int i = 0; i< scope ; i++) {
                    Customer customer = branch.getCustomers().get(i);
                    System.out.println((i+1) + ". " + customer.getName());
                }
           }
       }
       return true;
    }


}
