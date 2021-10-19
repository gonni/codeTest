package com.yg.codingtest.comb;

import java.util.Arrays;

public class Permutation {
    // 선택하고자 하는 대상 집합.
    static int[] target = new int[] { 0, 1, 2 };
    // 대상 숫자를 선택했는지를 알려주는 집합.
    static boolean[] visited ;

    public static void main(String[] args) {
        visited = new boolean[target.length];
        permutation(0, 2, target.length, "");
    }

    // 순열 메서드(cnt는 선택 횟수, result는 결과)
    private static void permutation(int cnt, int selectCnt, int totalCnt, String result) {
        // 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == selectCnt) {
            System.out.println(result);
            return;
        }
        // 대상 집합을 순회하며 숫자를 하나 선택한다.
        for (int i = 0; i < totalCnt; i++) {
            // 이미 해당 숫자를 선택한 경우에는 스킵.
            if (visited[i]) {
                continue;
            }
            // 선택하지 않은경우, 선택했다는 표시를 해준다.
            visited[i] = true;
            System.out.println("LK:" + i + Arrays.toString(visited));
            // 자신을 재귀 호출한다.
            permutation(cnt + 1, selectCnt, totalCnt, result + target[i]);
            // 선택을 해제한다.
            visited[i] = false;
            System.out.println("UN:" + i + Arrays.toString(visited));
        }
    }
}