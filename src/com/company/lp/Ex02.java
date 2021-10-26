package com.company.lp;

import java.io.*;

public class Ex02 {

    public static void main (String[] args) throws java.lang.Exception
    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        System.out.println(input);

        String input = "1 2 3 100 100 1 2";
        input = "10 16 13 12 15 14 12";
        input = "10 12";
        displayResult(input);

    }

    public static void displayResult(String input) {
        String[] tokens = input.split(" ");
        int[] nums = new int[tokens.length];

        for(int i=0;i<tokens.length;i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }

        int sum = 0;
        int count =0;
        for(int i=0;i<nums.length;i++) {
            if(!isNotValidTemp(nums, i)) {
                sum += nums[i];
                count ++;
            }
        }
        if(count != 0)
            System.out.println(sum / count);
        else
            System.out.println("ERROR");

    }

    public static boolean isNotValidTemp(int nums[], int i) {

        if(nums[i] > 200 || nums[i] < -200) return  true ;

        int cnt = 0;
        int totalCond = 0;
        if(i-2>= 0) {
            if(Math.abs(nums[i] - nums[i-2]) >= 3) {
               cnt++;
            }
            totalCond++;
        }

        if(i-1>= 0) {
            if(Math.abs(nums[i] - nums[i-1]) >= 3) {
                cnt++;
            }
            totalCond++;
        }

        if(i+1 < nums.length) {
            if(Math.abs(nums[i] - nums[i+1]) >= 3) {
                cnt++;
            }
            totalCond++;
        }

        if(i+2 < nums.length) {
            if(Math.abs(nums[i] - nums[i+2]) >= 3) {
                cnt++;
            }
            totalCond++;
        }

        if(cnt == totalCond) return true;
        return false;
    }

}
