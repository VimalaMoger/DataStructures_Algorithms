package dataStructuresAndAlgorithms.avlTrees;

public class Main {
    public static void main(String[] args) {
        AvlTreeImpl avlTree = new AvlTreeImpl();

        avlTree.insert(12);
        avlTree.insert(8);
        avlTree.insert(7);
        avlTree.insert(13);
        avlTree.insert(9);
        avlTree.insert(10);
        avlTree.insert(6);
        System.out.println("Done");

        avlTree.traversePreOrder();
        System.out.println();

        System.out.println(avlTree.getHeight());

        AvlTreeImpl tree = new AvlTreeImpl();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);

        tree.traversePreOrder();
        System.out.println();

        tree.treeBalanced();
        tree.traversePreOrder();
    }
}
