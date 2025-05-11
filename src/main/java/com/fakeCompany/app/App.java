package com.fakeCompany.app;

import java.util.*;

/**
 * Hello world!
 */
public class App {

    private int[] nums;

    public App(int[] nums) {
        this.nums = nums;
    }

    // Note: Omitted main method since we don't care whether this class is runnable on its own via terminal line or not

    public static void main(String[] args) {
        App app = new App(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(app.getArrayAsString());
        System.out.println(app.containsDuplicates());
    }
    // Given method from starter code
    // Key Idea: Using the Array.toString() method doesn't work.
    // Reason: This method returns a string representation of THE ARRAY OBJECT itself
    public String getArrayAsString() {
        StringBuilder arrayPrintout = new StringBuilder("["); // Note: Since we are mutating a string, using StringBuilder is more efficient
        for (int i = 0; i < nums.length; i++){
            int currentNum = nums[i];
            String numAsString = String.valueOf(currentNum);
            arrayPrintout.append(numAsString);
            if (i < nums.length - 1){
                arrayPrintout.append(",");
            }
        }
        arrayPrintout.append("]");
        return arrayPrintout.toString();

    }

    // Java solution to the problem: Contains Duplicates
    // Note: We are using the class insance's defined variable <nums>, so no need to pass the variable inside the method in line 29
    public boolean containsDuplicates(){
        int numsListLength = this.nums.length;
        if (numsListLength == 0 || numsListLength == 1){
            return false;
        }
        else {
            Set <Integer> encounteredNumbers = new HashSet<Integer>();
            for (int i = 0 ; i < numsListLength; i++){
                int currentNumber = this.nums[i];
                if (encounteredNumbers.contains(currentNumber)){
                    return true;
                }
                encounteredNumbers.add(currentNumber);
            }
            return false;
        }
    }
}
