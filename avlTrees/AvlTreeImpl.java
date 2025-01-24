package dataStructuresAndAlgorithms.avlTrees;

public class AvlTreeImpl {

    private class AvlNode {
        public int height;
        private int val;
        private AvlNode leftChild;
        private AvlNode rightChild;

        public AvlNode(int val) {
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

    public AvlNode root;

    public void insert(int val){
         root = insert(root, val);
    }

    public AvlNode insert(AvlNode root, int val) {
        if (root == null) {
            //set new node to root node
            root = new AvlNode(val);
            return root;
        }
        if (val < root.val) {
            root.leftChild = insert(root.leftChild, val);
        } else {
            root.rightChild = insert(root.rightChild, val);
        }

        /*
        setHeight(root);
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) +1;
        return balance(root);
         */
        return root;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(AvlNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(AvlNode root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        int left = getHeight(root.leftChild);
        int right = getHeight(root.rightChild);

        // return 1 + Math.max(left,right);
        //var balanceFactor = balanceFactor(root);
       //treeBalanced(root);

        if (left > right)
            return left+1;
        else
            return right+1;
    }

    public AvlNode treeBalanced(){
        if (root == null)
            return root;

        if(isLeftHeavy(root)) {
            //left heavy
            System.out.println(root.val + " is left heavy");
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else {
            //right heavy
            System.out.println(root.val + " is right heavy");
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            root = rotateLeft(root);
            return root;
        }
    }

    private AvlNode rotateLeft(AvlNode root) {
        var newNode = root.rightChild;
        root.rightChild = newNode.leftChild;
        newNode.leftChild = root;
        setHeight(root);
        setHeight(newNode);
        return newNode;
    }

    private AvlNode rotateRight(AvlNode root){
        var newNode = root.leftChild;
        root.leftChild = newNode.rightChild;
        newNode.rightChild = root;
        setHeight(root);
        setHeight(newNode);
        return newNode;
    }

    private int setHeight(AvlNode root){
       // return getHeight();
        root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) +1;
        return root.height;
    }

    private boolean isLeftHeavy(AvlNode root){
        return  balanceFactor(root) >= 1;
    }

    private boolean isRightHeavy(AvlNode root){
        return  balanceFactor(root) <= -1;
    }

    private int balanceFactor(AvlNode root){
        if(root == null) return 0;
        return (root == null) ? 0: getHeight(root.leftChild)- getHeight(root.rightChild);
    }
}
