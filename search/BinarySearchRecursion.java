package dataStructuresAndAlgorithms.search;


//using recursion
public class BinarySearchRecursion {
    //array sorted first, array divided into two partitions and searched recursively
    public static int binarySearchRecursion(int[] array, int target){
        return binarySearchRecursion(array, target, 0, array.length-1);
    }

    private static int binarySearchRecursion(int[] array, int target, int left, int right){
        //base condition
        if(left > right)
            return -1;

        int middle = ( left + right )/2;

        if (target == array[middle])
            return middle;

        if(target < array[middle])
            return binarySearchRecursion(array, target, left, middle-1);

        return binarySearchRecursion(array, target,middle+1, right);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 7, 13, 16};
        System.out.println(binarySearchRecursion(array, 4));
    }
}
