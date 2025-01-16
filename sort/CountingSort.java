package dataStructuresAndAlgorithms.sort;

import java.util.Arrays;

public class CountingSort {
    //Instead of comparisons, sorting by counting occurrences of elements, counts[] holds the size of largest number,
    //count the occurrence of each element, iterate over the count to fill the array back with sorted items
    public static void countingSort(int[] array, int max){
        int[]  counts = new int[max + 1]; //elements 0 to end
        for(int i: array) {
            counts[i]++;
        }
        int k = 0;
        for(int i =0; i< counts.length; i++){
            for(int j=0; j < counts[i]; j++){ //loops through number of count
                array[k++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] n = { 29,8,2,5,25,7,17,2,4,5,6,21 };
        countingSort(n, 29); //max is 29
        System.out.println(Arrays.toString(n));
    }
}
