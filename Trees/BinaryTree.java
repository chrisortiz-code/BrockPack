import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    //left info < n info < right info : TRUE
    //no repeat values
    //everything in subtree of left is < n.info < right subtree
    //On for insert and search with LL or Arr, search is log with arr
    //
    //complete tree with N nodes has H O(logN) H = log(N+1)-1
    //complete tree with height H has 2^(H+1)-1 nodes tree of height H can hold O(2^h) nodes
    //these type of things quantify time complexity
    // in a regular tree, operations O(NlogN) rather than logN due to infinite nodes per layer


    //degen binary tree (not balanced, turns to a LL with nullptrs) O(N) insert
    //complete logN
    //degen can happen when inserted in order already, n<n+1<n+2...

    public BinaryNode root;

    public BinaryTree() {
        root = null;
    }

    public void insertIterative(int value) {
        BinaryNode result = new BinaryNode(value);
        if (root == null) {
            root = result;//initializer
        }
        BinaryNode current = root;
        while (true) {
            BinaryNode parent = current;//space strains
            if (value < current.info) {
                current = current.left;
                if (current == null) {parent.left = result;return;}//inserted
            } else {
                current = current.right;
                if (current == null) {parent.right = result;return;}//inserted
            }
        }

    }

    public BinaryNode insertRec(BinaryNode current, int value) {
        if (current == null) {
            return new BinaryNode(value);
        }

        if (value < current.info) {
            current.left = insertRec(current.left, value);
        } else if (value > current.info) {
            current.right = insertRec(current.right, value);
        }

        return current;
    }

    public void preOrder(BinaryNode root) {
        if (root != null) {
            System.out.print(root.info);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void iterativePreOrder(BinaryNode root) {
        //need a stack
        while (root != null) {
            //print

            if (root.right != null) {//this is the definitive condition that would differ for different search methods
                //push to stack
            }
            if (root.left != null) {
                root = root.left;
            } else {
                //if stack not empty, root = pop
            }
            //will run preorder going leftmost down printing along the way,
        }
    }

    public void postOrder(BinaryNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.info);
        }
    }

    public void inOrder(BinaryNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.info);
            inOrder(root.right);
        }

    }

    public int height(BinaryNode root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public void BFS(BinaryNode root) {
//        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
//        q.add(left);
//        while(!q.isEmpty()){
//            BFS(q.poll());
//            System.out.print(q.poll().info);
//        }
        return;
    }

    public int depth(BinaryNode root, int value) {//do this
        //probably be easier with iteration
        if (root == null) {
            return -1;
        }
        if (root.info == value) {
            return 1 + Math.max(depth(root.left, value), depth(root.right, value));
        }
        return 0;
    }

    BinaryNode findIterative(BinaryNode root, int value) {
        while (root.info != value) {
            if (root.info > value) {
                root = root.left;
            } else {
                root = root.right;
                if (root == null) {
                    return root;
                }
            }
        }
        return root;
    }

    BinaryNode findRecursive(BinaryNode root, int value) {
        if (root == null || root.info == value) {
            return root;
        }
        if (root.info > value) {
            return findRecursive(root.left, value);
        }
        return findRecursive(root.right, value);
    }

    BinaryNode findMin(BinaryNode root) {
        //effectively keep going left till no left
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    BinaryNode findMax(BinaryNode root) {
        //Recursively
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }
    BinaryNode delete(int value){
        BinaryNode p = findIterative(root,value);
        if(p.left == null && p.right == null){//leaf node,
            //delete
        }
        if(p.right == null){
             //replace w left subtree
        }
        else{
            //replace left w right subtree
        }
        if(p.right != null&&p.left != null){
            //replace w inorder successor?
        }
        return p;
        }

}
