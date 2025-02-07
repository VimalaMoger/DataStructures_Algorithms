package dataStructuresAndAlgorithms.binaryHeap;

public class BinaryHeapImpl {

    private class BinaryHeapNode {

        private int val, temp;
        private static int count, k, numOfElements =0, eachLevelElements =1, level;

        private BinaryHeapNode leftChild;
        private BinaryHeapNode rightChild;

        public BinaryHeapNode(int val) {
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

    public BinaryHeapNode root;
    static BinaryHeapNode parent = null;

    //insert operation
    public void insert( int val){
        root = insert(root, val);
    }
    private BinaryHeapNode insert(BinaryHeapNode root, int val) {

        if (root == null) {
            //set new node to root node
            root = new BinaryHeapNode(val);
            root.numOfElements++;
            return root;
        }
        if (val <= root.val) {
            root.temp = val;

            if (root.leftChild == null) {
                root.leftChild = insert(root.leftChild, val);

            } else if (root.rightChild == null) {
                root.rightChild = insert(root.rightChild, val);

            }else if ( root.count < 2 ) {
                if(parent == root.rightChild)
                    insert(parent.leftChild, val);              //right portion of tree-  right-left
                else
                    insert(root.leftChild, val);

                if (root.temp == val && val != root.k) {    //check if a new value added to root.k
                    root.k = root.temp;
                    root.count++;                           //increments only for unique value in root.k
                    parent = root;
                }
            } else if( root.count >= 2 && root.count < 4 ) {

                if (parent.leftChild == null || parent.rightChild == null) {
                    insert(parent, val);
                }else
                    insert(parent.rightChild, val);

                if (root.temp == val && val != root.k) {     //check if a new value added to root.k
                    root.k = root.temp;
                    root.count++;                           //increments only for unique value
                }
            }
        } else
            balanceTree(root, val);

        if(root.level == isHeight()){                           //height of tree is checked
            int midLevel =  root.eachLevelElements - (int) Math.pow(2,isHeight())/2;
            if(root.numOfElements == midLevel) {                //total elements in the tree
                parent = root.rightChild;                       //parent is used to route to right half of root
                root.count = 2;
            }
        }else {
            root.eachLevelElements += (int) Math.pow(2,isHeight());
            root.level = isHeight();
        }

        if(root.eachLevelElements == root.numOfElements || root.count == 4)
            root.count = 0;

        return root;
    }

    public void balanceTree(BinaryHeapNode root, int val) {
        int temp = root.val;
        root.val = val;
        insert(root, temp);
    }

    public void extractElement(int val){
        root = extractElement(root, val);
    }
    private BinaryHeapNode extractElement(BinaryHeapNode root, int val) {
        if (root == null) {
            return root;
        }
        if(root.val == val){
           if(root.leftChild == null && root.rightChild == null){   //if node is a leaf
              root = null;
              return root;   //delete
           }else {
               if (root.leftChild.val > root.rightChild.val)
                   swap(root, root.leftChild);
               else
                   swap(root, root.rightChild);
           }
        }
        if (root.leftChild != null)
            root.leftChild = extractElement(root.leftChild, val);

        if (root.rightChild != null)
            root.rightChild = extractElement(root.rightChild, val);

        return root;
    }

    //swap child with parent
    private void swap(BinaryHeapNode parent, BinaryHeapNode child) {
        int temp = parent.val;
        if(parent.leftChild == child) {
            parent.val = child.val;
            parent.leftChild.val = temp;
        }else{
            parent.val = child.val;
            parent.rightChild.val = temp;
        }
    }

    //Breadth-first search
    //Level Order
    public void traverseLevelOrder() {
        traverseLevelOrder(root, 0);
    }

    private void traverseLevelOrder(BinaryHeapNode root, int distance) {

        if (root == null)
            return;

        for (int i = 0; i <= isHeight(); i++) {
            printNodeAtDistance(i);
        }
    }

    public void printNodeAtDistance(int distance){
        printNodeAtDistance(root, distance);
    }
    private void printNodeAtDistance(BinaryHeapNode root, int distance){
        if(root == null)
            return;
        if(distance == 0) {
            System.out.print(root.val + " ");
            return;
        }
        printNodeAtDistance(root.leftChild, distance - 1);
        printNodeAtDistance(root.rightChild, distance - 1);
    }

    //Tree height calculation
    public int isHeight(){
        if(root == null || root.numOfElements <= 1) return 0;
        else
            return isHeight(root.numOfElements);
    }

    public  int isHeight(int height){
        int i = 2;
        for(int j=1; j< height;j++) {
            double d = Math.pow(i, j);                                  //2,4,8,16 - 2 pow j
            if(d == height || height < (d+Math.pow(2,j)))
                return j;
        }
        return 0;
    }
}
