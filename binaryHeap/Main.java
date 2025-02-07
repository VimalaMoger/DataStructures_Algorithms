package dataStructuresAndAlgorithms.binaryHeap;

public class Main {
    public static void main(String[] args) {

        BinaryHeapImpl impl = new BinaryHeapImpl();
        impl.insert(42);
        impl.insert(29);
        impl.insert(18);
        impl.insert(19);
        impl.insert(7);
        impl.insert(18);
        impl.insert(12);
        impl.insert(11);
        impl.insert(13);
        impl.insert(17);
        impl.insert(5);
        impl.insert(6);
        impl.insert(1);
        impl.insert(2);
        impl.insert(3);
        impl.insert(4);
        impl.insert(14);


        System.out.println(impl.isHeight());

        //Breadth-first search
        //Level Order
        System.out.println("\nBreadth-first Level order ");
        impl.traverseLevelOrder();

        System.out.println();

        //remove an element from the tree
        impl.extractElement(29);

        impl.traverseLevelOrder();
    }
}
