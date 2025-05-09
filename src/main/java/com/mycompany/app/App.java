package com.mycompany.app;

import java.util.*;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";
    private int[] nums;

    public App(int[] nums) {
        this.nums = nums;
    }

    // Given method from starter code
    public static void main(String[] args) {
        System.out.println(MESSAGE);
    }

    // Given method from starter code
    public String getMessage() {
        return MESSAGE;
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
