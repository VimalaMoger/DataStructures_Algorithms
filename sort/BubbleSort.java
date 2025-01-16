package dataStructuresAndAlgorithms.sort;

import java.util.Arrays;

public class BubbleSort {
    //comparison between adjacent elements, takes multiple passes, swaps them if they are in the wrong order
    public static void bubbleSort(int [] array){
        if(array.length == 0)
            System.out.println("Array is empty");
        else {
            for (var i = 0; i < array.length; i++) {
                for (int j = 1; j < array.length - i; j++) {
                    if (array[j] < array[j-1]) {//after each pass, next largest item moves to the next position
                        swap(j, j - 1, array);
                    }
                }
            }
        }
    }

    public static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        //edge cases checked with empty array, 1, 2 and n elements
        int[] n = { 2,4,1,5,3,7,6,9,5 };
        bubbleSort(n);
        System.out.println(Arrays.toString(n));
    }
}
