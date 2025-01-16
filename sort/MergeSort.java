package dataStructuresAndAlgorithms.sort;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class MergeSort {
    //Divides the array into halves, sorts each half, then merges sorted halves to produce final sorted result
    public static int[] mergeSort(int [] array) {
        int middle = array.length / 2;
        int[] arrOne = new int[middle];  //subarray one
        int[] arrTwo = new int[array.length - middle]; //subarray two
        int index1 = 0;
        int index2 = 0;

        //splitting array into two subArrays
        for (var i : array) {
            if (index1 < arrOne.length) {
                arrOne[index1++] = i;
            } else if (index2 < arrTwo.length) {
                arrTwo[index2++] = i;
            }
        }
        //sorting the two subArrays
        sort(arrOne);
        sort(arrTwo);
        //merging the subArrays
        merge(arrOne, arrTwo, array);
        return array;
    }
    private static void merge(int[] arrOne, int[] arrTwo, int[] result){
        int index =0;
        int count =0;
        for(int i=0; i< arrOne.length; i++){
            for(int j=count; j< arrTwo.length; j++){
                if(arrOne[i] < arrTwo[j]) {
                    result[index++] = arrOne[i];
                    break;
                }else if(arrOne[i]  >= arrTwo[j]) {
                    result[index++] = arrTwo[j];
                    count++;  //to start from next index(count) in the next iteration
                }
            }
           if(count == arrTwo.length){
               System.out.println(count + " count");
                System.out.println("index "+index);
                result[index++] = arrOne[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] n = { 20,8,1,5,25,7,17,2,4,5,6,21};

        System.out.println(Arrays.toString(mergeSort(n)));
    }
}
