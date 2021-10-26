package com.company.lp;

import java.util.Arrays;
import java.util.Collections;

public class Ex03 {

    public static int solution(int n, int[] bankbook) {
        Arrays.sort(bankbook);

        int tempSum = 0;
        int count = 0;
        for(int i=0;i<bankbook.length-1;i++) {
            if(bankbook[i] == -1) continue;
            tempSum = bankbook[i];
            bankbook[i] = -1;

            for(int j=i+1;j<bankbook.length;j++) {
                if(bankbook[j] == -1) continue;
                if(tempSum + bankbook[j] <= n) {
                    tempSum += bankbook[j];
                    bankbook[j] = -1;
                }
            }
            count ++;

            if(allSelected(bankbook)) break ;
        }
        return count;
    }

    private static boolean allSelected(int[] bankbook) {
        for(int i=0;i<bankbook.length;i++) {
            if(bankbook[i] != -1) {
                return false ;
            }
        }
        return true;
    }

    public static void main(String ... v) {
        System.out.println();
        System.out.println("res =>" + solution(10, new int[] {1,2,3,3,3,8}));
        ;
    }

}
