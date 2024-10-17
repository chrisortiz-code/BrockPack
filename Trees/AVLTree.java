public class AVLTree extends BinaryTree {
    /*condition of height
               O h =2
               /\
h1 1+(hsub)  O   O h = 0, -1+1
             /
            o    h = 0 <- null = -1 +1
     */


    //different conditions
    //L, R to keep same height, result in not complete trees each time, a(lways add to .lefts left, rights right)
    //for each node, keep this process : only possible if n = 2^k-1, too strenuous (will always
    //AVL property states |L-R|<1
    AVLNode root;
    public void balance() {
        //METHOD Left-left
        // done when you add to the left subtree of a left child, thus increasing height to 2, while right subtree has h 0
        //will make the left subtree .right point to its parent. will make parent . left = this new tree

        //Right-right
        //done when right of right tree is added to,
        //method makes parent.right -> the right subtree, that subtree.left = parents original .right

        //right - left
        // done when h_r side of left tree > h_l,
        // first rotation will still favour the left tree,
        // make the N.left the right subtree , this . right = oririnal n.left
        // perform same operation again with left dominated left tree
        // !Left-Left

        //Left right -
        // done when the left side of right tree is higher than the right side,
        // first rotation will still violate
        // rerun with right dominated tree

    }

    int height(AVLNode n) {
        return n == null ? -1 : n.height;
    }

    AVLNode rotateLeft(AVLNode n) {
        AVLNode x = n.left;
        n.left = x.right;
        x.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    AVLNode rotateRight(AVLNode n) {
        AVLNode x = n.right;
        n.right = x.left;
        x.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public AVLNode insert(AVLNode root, AVLNode n) {
        if (root == null) {//base empty tree
            return n;
        }
        else if (n.value < root.value) {
            root.left = insert(root.left, n);
            if (height(root.left) - height(root.right) == 2) {//violates avl
                if (n.value < root.left.value) {
                    root = rotateLeft(root);
                } else {
                    root.left = rotateRight(root.left);
                    root = rotateLeft(root);
                    //double left method
                }
            }
        }
        else {//greater
            root.right = insert(root.right, n);
            if(height(root.right)-height(root.left)==2) {//violation
                if(n.value > root.right.value) {
                    root = rotateRight(root);
                }else{
                    root.right = rotateLeft(root.right);
                    root = rotateRight(root);
                }
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

}
