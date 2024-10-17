public class BinaryNode {
    //note of btree, there will always be n+1 nullptrs for n nodes
    //issue?
    //ex, 7 nodes, int 4 bit, pointer is an 8 bit address,
    //7x4 on data, 7*2*8 pointers, (7+1)*8 nullptrs

    BinaryNode left;
    BinaryNode right;
    int info;
    public BinaryNode(int info){
        this.info = info;
    }
}
