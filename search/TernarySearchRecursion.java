package dataStructuresAndAlgorithms.search;

public class TernarySearchRecursion {
    //array sorted first, array divided into three partitions(like BinarySearch) and searched recursively
    public static int ternarySearchRecursion(int[] array, int target) {
        return ternarySearchRecursion(array, target, 0, array.length - 1);
    }

    private static int ternarySearchRecursion(int[] array, int target, int left, int right) {

        int partitionSize = (right - left)/3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if(left > right)
            return -1;

        if (target == array[mid1])
            return mid1;

        if (target == array[mid2])
            return mid2;

        if(target < array[mid1])
            return ternarySearchRecursion(array, target, left, mid1-1); //partition one


        if(target > array[mid2])
            return ternarySearchRecursion(array, target, mid2+1, right); //partition three

        return ternarySearchRecursion(array, target,mid1+1, mid2-1);//partition two
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 7, 13, 16, 18, 19};
        System.out.println(ternarySearchRecursion(array, 190));
    }
}

