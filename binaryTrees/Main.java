package dataStructuresAndAlgorithms.binaryTrees;

public class Main {
    public static void main(String[] args) {

        BinaryTreeImpl impl = new BinaryTreeImpl();
        impl.insert(12);
        impl.insert(8);
        impl.insert(7);
        impl.insert(13);
        impl.insert(9);
        impl.insert(10);
        System.out.println("Done");

        //find element using Depth-first search
        System.out.println(impl.isElementFound(90));
        System.out.println("Pre Order");
        impl.traversePreOrder();
        System.out.println("In Order");
        impl.traverseInOrder();
        System.out.println("Post Order");
        impl.traversePostOrder();
        System.out.println();

        //get the height of the tree
        System.out.println("Height of the tree "+impl.getHeight());

        System.out.println(impl.findMinValue());
        System.out.println(impl.findMaxValue());

        //check if two trees are equal
        BinaryTreeImpl impl2 = new BinaryTreeImpl();
        impl2.insert(12);
        impl2.insert(8);
        impl2.insert(13);
        impl2.insert(9);
        impl2.insert(10);
        System.out.println("Done");

        System.out.println(impl.twoTreesAreEqual(impl.root, impl2.root, true));

        System.out.println(impl.isBinarySearchTree());

        //print Nodes at given distance
        impl.printNodeAtDistance(1);

        //Breadth-first search
        System.out.println("\nBreadth - first level order ");
        impl.traverseLevelOrder();

        System.out.println("size "+impl.size());

        System.out.println("countLeaves "+impl.countLeaves());

        System.out.println("value present "+impl.containsVal(133));
    }
}
