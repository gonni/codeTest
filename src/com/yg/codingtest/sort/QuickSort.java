package com.yg.codingtest.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String ... v) {
        System.out.println("Hella");

        int[] data = {5,9,3,1,4,6,8,7} ;
        System.out.println("Ori Data :" + Arrays.toString(data));

        quickSort(data, 0, data.length -1);

        System.out.println("Sorted Data :" + Arrays.toString(data));
    }

    public static int partition(int arr[], int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while ((arr[left] < pivot) && (left < right))
                left++;
            while ((arr[right] > pivot) && (left < right))
                right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        System.out.println("Mid Sorting Data :" + Arrays.toString(arr));

        return left;
    }

    public static void quickSort(int arr[], int left, int right) {

        if (left < right) {
            int pivotNewIndex = partition(arr, left, right);
            System.out.println("Pivot Index : " + pivotNewIndex);
            quickSort(arr, left, pivotNewIndex - 1);
            quickSort(arr, pivotNewIndex + 1, right);
        }

    }
}
