package dataStructuresAndAlgorithms.binaryTrees;

public class BinaryTreeImpl {
    private class Node {
        private int val;
        private Node leftChild;
        private Node rightChild;

        public Node(int val) {
            this.val = val;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    public Node root;

    //Inserting a value to the root node if root is null, else creating a new node with value, if root is not null then
    //check to see if left or right node is null, for a new child node. otherwise, current node becomes child node
    public void insert(int val) {
        if (root == null) {
            //set new node to root node
            root = new Node(val);
        } else {
            Node current = root;
            while (current != null) {
                if (val < current.val) {
                    if (current.leftChild == null) {
                        current.leftChild = new Node(val);
                        break;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = new Node(val);
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    //finding an element in the tree
    public boolean isElementFound(int val) {
        var current = root;
        while (current != null) {
            if (val == current.val)
                return true;
            if (val < current.val)
                current = current.leftChild;
            current = current.rightChild;
        }
        return false;
    }

    //traversing a tree

    //Depth-first search
    //pre-order traversal- root-> left -> right
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + ", ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }


    //In-order traversal  -left->root->right
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        System.out.println();
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.print(root.val + ", ");
        traverseInOrder(root.rightChild);
    }

    //Post-order traversal- left->right->root
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        System.out.println();
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.val + ", ");
    }

    //Breadth-first search
    //Level Order
    public void traverseLevelOrder() {
        traverseLevelOrder(root, 0);
    }

    private void traverseLevelOrder(Node root, int distance) {

        if (root == null)
            return;

        for(int i = 0;i <= getHeight(); i++) {
            printNodeAtDistance(i);
        }
   }

    //find the height of the tree
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        int left = getHeight(root.leftChild);
        int right = getHeight(root.rightChild);
        if (left > right)
            return left+1;
        else
            return right+1;
       // return 1 + Math.max(left,right);
    }

    //find the minimum value in the binary tree
    public int findMinValue() {
        return findMinValue(root, root.val);
    }
    public int findMinValue(Node root, int min ) {
        if (root == null)
            return min;
        else {
            if (root.val < min)
                min = root.val;
            int left = findMinValue(root.leftChild, min);
            int right = findMinValue(root.rightChild, min);

            if (left < min)
                min = left;
            if (right < min)
                min = right;
           // return Math.min(left,right);
        }

        return min;
    }

    //find the max value in the binary tree
    public int findMaxValue() {
        return findMaxValue(root, root.val);
    }
    public int findMaxValue(Node root, int max ) {
        if (root == null)
            return max;
        else {
            if (root.val > max)
                max = root.val;
            int left = findMaxValue(root.leftChild, max);
            int right = findMaxValue(root.rightChild, max);

            if (left > max)
                max = left;
            if (right > max)
                max = right;
            // return Math.min(left,right);
        }
        return max;
    }

    //Given two trees, check to see if they are equal
    public boolean twoTreesAreEqual(Node tree1, Node tree2, boolean bool){
        if (tree1 == null || tree2 == null)
            return bool;
        else {
            if (tree1.val != tree2.val) {
                bool = false;
                //return bool;
            }
            boolean left = twoTreesAreEqual(tree1.leftChild, tree2.leftChild, bool);
            boolean right = twoTreesAreEqual(tree1.rightChild, tree2.rightChild, bool);

            if(left == right == bool)
                bool = true;
            else
                bool = false;
        }
        return bool;
    }

    //BinarySearchTree - all the left side of root lesser than right side of tree
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, root.val, true);
    }

    public boolean isBinarySearchTree(Node root, int val, boolean bool){
        if (root == null)
            return bool;
        else {
            if (root.val > val)
               bool = false;
            boolean left = isBinarySearchTree(root.leftChild, val, bool );
            boolean right = isBinarySearchTree(root.rightChild, val, bool);

            if(left == right == bool)
                bool = true;
            else
                bool = false;
        }
        return bool;
    }

    public void printNodeAtDistance(int distance){
        printNodeAtDistance(root, distance);
    }
    private void printNodeAtDistance(Node root, int distance){
        if(root == null)
            return;
        if(distance == 0) {
            System.out.print(root.val + " ");
            return;
        }
        printNodeAtDistance(root.leftChild, distance - 1);
        printNodeAtDistance(root.rightChild, distance - 1);
    }

    public int size(){
        int j=0;
        for(int i=0; i<= getHeight();i++) {
            j += size(root, i, 0);
        }
        return j;
    }
    private int size(Node root, int distance, int count) {

        if (root == null)
            return count;
        if (distance == 0) {
            count++;
            return count;
        }
        int size1 = size(root.leftChild, distance - 1, count);
        int size2 = size(root.rightChild, distance - 1, count);
        int num = size2 + size1;
        return num;
    }

    public int countLeaves(){
        return countLeaves(root);
    }
    private int countLeaves (Node root) {
        return size()-1;
    }

    public boolean containsVal(int num){
        return containsVal(root, num);
    }

    private boolean containsVal(Node root, int num){
        if (root == null)
            return false;
        else {
            if (root.val == num)
                return true;
            else if(root.val > num)
                return containsVal(root.leftChild, num);
            else
                return containsVal(root.rightChild, num);
            }
    }

}

