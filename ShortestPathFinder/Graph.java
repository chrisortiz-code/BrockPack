import BasicIO.ASCIIDataFile;

public class Graph {
    private final int MAX= 1_000_000;
    int[][] edges;
    int start;
    int end;
    int rows;

    public Graph() {
        initialize();
    }

    private void initialize() {
        ASCIIDataFile f = new ASCIIDataFile();
        rows = f.readInt();
        edges = new int[rows][rows];
        int i =0;
        while(i<rows){
            for(int j=0;j<rows;j++){
                int val = f.readInt();
                if(val==-1){
                    edges[i][j] = MAX;
                }else {
                    edges[i][j] = val;
                }
            }
            i++;
        }
        start = f.readInt();
        end = f.readInt();

        f.close();
    }

    public int getStartIndex() {
        return start; // TODO
    }

    public int getEndIndex() {
        return end; // TODO
    }

    public int getSize() {
        return rows; // TODO
    }

    public int[][] getData() {

        return edges; // TODO
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                if(edges[i][j]==MAX){
                    result.append("\u221E");
                }else{
                    result.append(edges[i][j]);
                }
                result.append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
