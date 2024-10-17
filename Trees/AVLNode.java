public class AVLNode {
    //info
    int value;
    AVLNode left;
    AVLNode right;
    int height;
    //value will be updated constantly
    int height(AVLNode n) {
        return n ==null? -1:n.height;
    }
}
