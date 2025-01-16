package dataStructuresAndAlgorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    //Creating  buckets, sorting the bucket elements using Collections.sort() method, putting sorted elements back to the array
    public static void bucketSort(int[] array, int numOfBuckets){
        var buckets = createBuckets(array, numOfBuckets);
        var i = 0;
        for(var bucket : buckets){
            Collections.sort(bucket);
            for(var item: bucket)
                array[i++]= item;
        }

    }
    private static List<List<Integer>> createBuckets(int[] array, int numOfBuckets){
        List<List<Integer>> buckets = new ArrayList<>();
        for(var i =0; i < numOfBuckets; i++){
            buckets.add(new ArrayList<>());
        }
        for(var item: array)
            buckets.get(item/numOfBuckets).add(item);
        return buckets;
    }

    public static void main(String[] args) {
        int[] n = { 29,8,1,5,25,7,17,2,4,5,6,21 };
        bucketSort(n,6);
        System.out.println(Arrays.toString(n));
    }
}
