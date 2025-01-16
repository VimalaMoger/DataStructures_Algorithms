package dataStructuresAndAlgorithms.search;

//binary search using iteration
public class BinarySearchIteration {
    //array sorted first, array divided into two partitions and searched using while loop
    public static int binarySearchIteration(int[] array, int target){
        return binarySearchIteration(array, target, 0, array.length-1);
    }

    private static int binarySearchIteration(int[] array, int target, int left, int right) {
        while( left <= right){
            var middle = (left + right)/2;

            if(target == array[middle])
                return middle;

            else if(target < array[middle]) {
                right = middle - 1;
            }

            else
                left = middle + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 7, 13, 16};
        System.out.println(binarySearchIteration(array, 3));
    }
}
