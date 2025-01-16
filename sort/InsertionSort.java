package dataStructuresAndAlgorithms.sort;

import java.util.Arrays;

public class InsertionSort {
    //Uses temp variable that holds each ith element, then moved to right array position based on the temp value
    //if temp is less than jth element, jth element moved to next position, otherwise temp value moved to next position
    public static void insertionSort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            int temp =  array[i];
            int j = i-1;
            while(j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] n = { 16,2,4,1,5,3,7,6,9,5 };
        insertionSort(n);
        System.out.println(Arrays.toString(n));
    }
}
