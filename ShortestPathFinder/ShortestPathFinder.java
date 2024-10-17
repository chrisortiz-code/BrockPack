import Collections.LnkQueue;

public class ShortestPathFinder {
    private final int MAX= 1_000_000;
    LnkQueue<Integer> queue;
    int start;
    int end;
    int[][] edges;


    public ShortestPathFinder(Graph g) {
        start = g.getStartIndex();
        end = g.getEndIndex();
        edges=g.getData();

    }

    public int getShortestDistance(){
        queue = new LnkQueue<>();
        int[] min= new int[edges.length];//minimum distance

        for(int i=0;i<edges.length;i++){
            min[i]=MAX;//at start, min dist is infinite, as search, lower dists are found
        }
        min[start]=0;
        queue.enter(start);

        while(!queue.empty()){
            int v = queue.leave();//start or its neighbors,, min[v]!=inf
            for(int i=0;i<edges.length;i++){
                int distance = min[v] + edges[v][i];
                if(distance<min[i]){//removes all where edges_vi = MAX
                    min[i]=distance;//save new distance
                    queue.enter(i);//search this one eventually
                }
            }
        }
        return min[end];
    }


}
