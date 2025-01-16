package dataStructuresAndAlgorithms.sort;

import java.util.Arrays;

public class SelectionSort {
    //selects smallest element from unsorted region, moves to the end of sorted region
    public static void selectionSort(int [] array){
        for (var i = 0; i < array.length; i++) {
            var minIndex = i;
            swap(i, findMinIndex(array, minIndex), array);
        }

    }
    public static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int findMinIndex(int[] array, int minIndex){
        for (int j = minIndex; j < array.length; j++) {
            if(array[j] < array[minIndex])
                minIndex = j;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] n = { 5, 4, 3, 2 };
        selectionSort(n);
        System.out.println(Arrays.toString(n));
    }
}
