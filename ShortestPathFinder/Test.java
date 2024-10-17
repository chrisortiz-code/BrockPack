public class Test {
    public Test() {
        Graph g = new Graph();
        ShortestPathFinder path = new ShortestPathFinder(g);

        System.out.println(g);
        System.out.println("Starting from vertex: " + g.getStartIndex());
        System.out.println("Ending at vertex    : " + g.getEndIndex());
        int optimalDistance = path.getShortestDistance();
        System.out.println("Optimal minimum distance: " + optimalDistance);
    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}