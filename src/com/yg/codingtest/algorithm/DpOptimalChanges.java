package com.yg.codingtest.algorithm;
import java.util.*;

public class DpOptimalChanges {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
        int n = 3;
        int k = 12;


        int coin[] = {1,5,10};
//        for (int i = 0; i < n; i++) {
//            coin[i] = scanner.nextInt();
//        }

        int d[] = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            d[i] = -1;
            for (int j = 0; j < n; j++) {
                if (coin[j] <= i) { // 잔돈단위 동전 < 조사 금액
                    if (d[i - coin[j]] < 0) continue;
                    // d[10] = d[10-10] + 1 = 0
                    // x = d[50] = 0 + 1 = 1

                    // when 10: case 50->0 : d[50-10] + 1 , d[40] =0
                    // when 10: d[51-10] = d[51-10] + 1 = 0, d[41] =0
                    if (d[i] < 0) d[i] = d[i - coin[j]] + 1;

                    // when 50: d[50 - ]
                    else if (d[i - coin[j]] + 1 < d[i]) d[i] = d[i - coin[j]] + 1;

                    System.out.print(i+ ":" + coin[j] + "   ");
                    for(int x=1;x<k+1;x++) {
                        System.out.print(d[x] + " ");
                    }
                    System.out.println();
                }
            }
        }

//        for(int i=1;i<k+1;i++) {
//            System.out.print(d[i] + " ");
//        }
        System.out.println();

        System.out.println(d[k]);
    }
}
