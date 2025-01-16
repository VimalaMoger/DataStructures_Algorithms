package dataStructuresAndAlgorithms.search;

public class ExponentialSearch {
    //Within the sorted array, bound is first set to some index, if the index element < target, then bound size is doubled, prev stores
    //the upper bound, iteration takes place over the range of elements
    private static int exponentialSearchIteration(int[] array, int target) {
        int bound = 1;
        int prev = 0;

        while (array[bound] < target) { //while - sets the prev and bound index, after comparing against target element
            prev =  bound; //1
            bound *= 2;  //2
            if (bound > array.length)
                bound = array.length-1;  //
        }

        for (int i = prev; i <= bound; i++) { //iteration using prev and upper bound, over the range of elements
            if (array[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 8, 9, 13, 60};
        System.out.println(exponentialSearchIteration(array, 13));
    }
}
