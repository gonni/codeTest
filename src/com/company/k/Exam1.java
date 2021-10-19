package com.company.k;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result01 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY startHeight
     *  2. INTEGER_ARRAY descentRate
     */

    public static int solution(List<Integer> startHeight, List<Integer> descentRate) {
        // Write your code here
        List<Double> remainTimes = new ArrayList<>();

        for(int i = 0; i<startHeight.size(); i++) {
            int heigth = startHeight.get(i);
            int vRate = descentRate.get(i);

            remainTimes.add((double)heigth / (double)vRate);
        }

        remainTimes.sort((x1, x2) -> x1.compareTo(x2));
        System.out.println(remainTimes);

        int cnt = 0;
        for(int i=0;i<remainTimes.size();i++) {
            if(remainTimes.get(i) > i) {
//                System.out.println("in :" + i + " " + remainTimes.get(i));
                cnt ++;
            } else {
//                System.out.println("no :" + i + " " + remainTimes.get(i));
            }
        }

        return cnt;
    }

}
public class Exam1 {

    public static void main(String ... v) {
        int[] sHeight = {1,1,3,5,4,8,9};
        int[] vRate = {1,1,2,2,1,2,1};
//        int[] sHeight = {4, 3};
//        int[] vRate = {2, 2};
//        int[] sHeight = {70,50, 57,91, 156,133,116,70,60,144};
//        int[] vRate = {5, 2,3,7,2,7,4,2,5,6};
        System.out.println(Result01.solution(
                Arrays.stream(sHeight).boxed().collect(Collectors.toList()),
                Arrays.stream(vRate).boxed().collect(Collectors.toList())));
    }

    public static void main0(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp_out.txt"));

        int startHeightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startHeight = IntStream.range(0, startHeightCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int descentRateCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> descentRate = IntStream.range(0, descentRateCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result01.solution(startHeight, descentRate);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}