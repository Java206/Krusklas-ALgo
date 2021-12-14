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
		LinkedList<Edge> edges = graph.edgeList;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
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

			} else {
				s.add(e);
				v.add(one);
				v.add(two);            
			}

		}
		
		Iterator<Edge> i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().getData());
		}
		
		return s;

	}

	public static void main(String[] args) {
		SimpleGraph G = new SimpleGraph();
		String s = "";

		try {
			Scanner input = new Scanner(System.in);

			System.out.print("input File Name: ");
			s = input.nextLine();
			File file = new File(s);
			Scanner scan = new Scanner(file);

			while (scan.hasNextLine()) {
				String[] data = scan.nextLine().split(", ");
				G.insertVertex(data[0], "");
				
				System.out.println(Arrays.toString(data));

			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}


		GraphInput.LoadSimpleGraph(G, s);

		System.out.println(Kruskal(G));

	}



}
