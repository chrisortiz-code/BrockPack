public class ThreadedTree{
    ThreadedNode root;

    /*
        Threaded tree to combat nullptrs.
        Use them to store other information, ptrs values etc.
        Will be used for iterative methods
        Often just one thread will be used, because traversal needs just one
         */
    public ThreadedTree(int value){
        root = new ThreadedNode(value);
    }

    ThreadedNode findSuccessor(ThreadedNode x){
        //In order going from h to i in an in order traversal, ref image in slideshow

        if(x.rThread){
            //thread points to predecessor
            ThreadedNode y = x.right;
        }
        else{
            ThreadedNode y = x.right;
            while(!y.lThread){
                y = y.left;
            }
        }
        return x;
    }
    ThreadedNode findPredecessor(ThreadedNode x){
        if(x.lThread){
            ThreadedNode y = x.left;
        }else{
            ThreadedNode y = x.left;
            while(!y.rThread){
                y = y.right;
            }
        }
        return x;
    }
    void inOrder(ThreadedNode x){
        ThreadedNode y = x;
        while(y.lThread){
            y = y.left;
        }
        //This gets us to the proper node,
        //uses our methods

        while(y!=null){
            System.out.println(y.data);
            findSuccessor(y);
        }
    }
    ThreadedNode rightThreadTree(ThreadedNode x){
        /*
        fxn to right thread the tree
         */
        ThreadedNode y;
        if(x.left!=null){
            y = rightThreadTree(x.left);
            //fxn starts at leftmost point, x is the predec,, set pointer
            y.right = x;
        }
        if(x.right!=null){
            y = rightThreadTree(x.right);
        }
        else{
            //end reached
            y = x;
            y.rThread = true;
        }
        return y;
    }
    ThreadedNode leftThreadTree(ThreadedNode x){
        ThreadedNode y;
        if(x.right!=null){
            y = leftThreadTree(x.right);
            y.left = x;
        }
        if(x.left!=null){
            y = leftThreadTree(x.left);
        }
        else{
            y = x;
            y.lThread = true;
        }
        return y;
    }
    ThreadedNode threadedInsert(ThreadedNode root, ThreadedNode x){
        if(root ==null){
            root = x;
        } else if (x.data< root.data) {
            if(root.lThread){
                x.left = root.left;
                x.right = root;
                root.right = x;
                root.rThread = false;
            }else{
                x.left = threadedInsert(root.left, x);
            }
        }else {
            if (root.rThread) {
                x.left = root;
                x.right = root.right;
                root.right = x;
                root.rThread = false;
            } else {
                root.right = threadedInsert(root.right, x);
            }
        }
        return root;
    }

}
