package dataStructuresAndAlgorithms.search;

public class LinearSearch {
    //returns the index of the target element if found in the array, otherwise -1 for element that never exists
    public static int linearSearch(int [] array, int target){
        for(int i = 0; i < array.length; i++){
            if(target == array[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {6,3,1,9,45,4};
        System.out.println(linearSearch(array, 49));
    }
}
