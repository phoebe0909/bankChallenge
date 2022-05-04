package com.company;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> myBranchList;
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.myBranchList = new ArrayList<Branch>();
    }

//    public static Bank createBank(String bankName) {
//        return new Bank(bankName);
//    }

//    public int findIndexOfBranch(Branch branch){
//        return this.myBranchList.indexOf(branch);
//    }

    public void addBranch(String branchName) {
        if (findBranch(branchName)>=0){
            System.out.println("Branch already exists.");
        }
        else {
            Branch newBranch = Branch.createBranch(branchName);
            myBranchList.add(newBranch);
            System.out.println("New branch added -- " + branchName);
        }
    }

    public void addBranch(Branch branchName) {
        int x = findBranch(branchName.getBranchName());
        if(x >=0){
            System.out.println("Branch already exists.");
        }
        else{
            myBranchList.add(branchName);
            System.out.println("New branch added -- " + branchName);
        }
    }

    public int findBranch(String branchString) {
        for (int i = 0; i < this.myBranchList.size(); i++) {
            Branch branchName = this.myBranchList.get(i);
            if (branchName.getBranchName().equals(branchString)) {
                return i;
            }
        }
        return -1;
    }


}
