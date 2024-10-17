public class ThreadedNode{
    //info
    int data;
    public ThreadedNode left;
    public ThreadedNode right;
    boolean lThread;
    boolean rThread;
    //Thread points to the parent itself or its parent, l or r
    public ThreadedNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

}
