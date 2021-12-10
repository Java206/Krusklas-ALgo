import java.io.*;
import java.util.*;

public class PowerGrid {

    Edge edge1;
    Edge edge2;

    public static Set<Edge> Kruskal(SimpleGraph graph) {

        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>((edge1, edge2) -> {

            if ((int) edge1.getData() < (int) edge2.getData()) {
                return -1;
            }
            if ((int) edge1.getData() > (int) edge2.getData()) {
                return 1;
            }
            return 0;

        });
        LinkedList edges = graph.edgeList;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = (Edge) edges.get(i);
            edgeQueue.add(edge);

        }

        ArrayList<Vertex> v = new ArrayList<>();
        int n = graph.vertexList.size();
        Set<Edge> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Edge e = edgeQueue.poll();
            Vertex one = e.getFirstEndpoint();
            Vertex two = e.getSecondEndpoint();
            if (!(v.contains(one) && v.contains(two))) {
                s.add(e);
                v.add(one);
                v.add(two);
            }

        }
        Iterator i = s.iterator();
        while (i.hasNext()) {
            // System.out.println(((Edge) i.next()).getData());
        }
        return s;

    }

    public static void main(String[] args) {
        SimpleGraph G = new SimpleGraph();
        Vertex a = G.insertVertex(5, "a");
        Vertex b = G.insertVertex(6, "b");
        Vertex c = G.insertVertex(7, "c");
        Vertex d = G.insertVertex(8, "d");
        Vertex e = G.insertVertex(9, "e");
        Edge f = G.insertEdge(a, b, 3, "3");
        Edge g = G.insertEdge(b, c, 5, "5");
        Edge h = G.insertEdge(a, e, 1, "1");
        Edge i = G.insertEdge(c, d, 2, "2");
        Edge j = G.insertEdge(e, d, 7, "7");
        Edge k = G.insertEdge(e, c, 6, "6");
        Edge l = G.insertEdge(b, e, 4, "4");

        LinkedList edge = G.edgeList;
        int len = edge.size();
        for (int s = 0; s < len; s++) {
            Edge ed = (Edge) edge.get(s);
            System.out.println(ed.getData());
        }

        System.out.println(Kruskal(G));

        // // accept keyboard input of filename
        // String s = readFile();

        // // Create a new SimpleGraph object to store the data

    }

    // // prompt the user to input a file
    // // and read the file and return to
    // // main
    // public static String readFile() {
    // String s = "";
    // try {
    // Scanner input = new Scanner(System.in);

    // System.out.print("input File Name: ");
    // s = input.nextLine();
    // File file = new File(s);
    // Scanner scan = new Scanner(file);

    // while (scan.hasNextLine()) {
    // String data = scan.nextLine();
    // System.out.println(data);
    // }
    // input.close();
    // } catch (FileNotFoundException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // return s;
    // }

}
