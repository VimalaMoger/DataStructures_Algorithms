package dataStructuresAndAlgorithms.sort;

import java.util.Arrays;

public class QuickSort {
    //Selects pivot element first, then partition remaining array elements
    //each partition compared whether less or greater than pivot, each sub-partitions recursively sorted
    public static void sort(int[] array){
        quickSort(array,0, array.length-1);
    }

    private static void quickSort(int [] array, int start, int end){
        if(start >= end) //initial check to see if array has single element or an empty array
            return;
        var boundary = partition(array, start, end); //index of pivot positioned
        quickSort(array,start,boundary-1);
        quickSort(array,boundary+1, end);
    }
    //returns the index of pivot after it is moved to right position
    private static int partition(int[] array, int start, int end){
        var pivot = array[end];
        var boundary = start - 1; // -1 is the 0th position
        //left partition is empty and right partition at 0
        //increment the boundary (num < pivot) and swap
        for(var i = start; i <= end; i++){
            if(array[i] <= pivot) {
                boundary++;
                swap(i, boundary, array);
            }
        }
        return boundary;
    }
    private static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        //int[] n = { 2 }; //[2]
        //int[] n = {}; //[]
        int[] n = { 29,8,1,5,25,7,17,2,4,5,6,21 };
        sort(n);
        System.out.println(Arrays.toString(n));
    }
}
