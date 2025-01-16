package dataStructuresAndAlgorithms.search;

public class JumpSearch {
    //array sorted first, array divided into block size using Math.sqrt(array length) and searched recursively
    public static int jumpSearchIteration(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;
        return jumpSearchIteration(array, target, start, next, blockSize);
    }

    private static int jumpSearchIteration(int[] array, int target, int start, int next, int blockSize) {

        while (array[next - 1] < target) {  //index of the last item in the current block
            start = next;  //if the last item in the first block < target, advance the pointer to next block
            if (start >= array.length)
                break;
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }
        for (int i = start; i < next; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 8, 9, 13, 60};
        System.out.println(jumpSearchIteration(array, 8));
    }
}