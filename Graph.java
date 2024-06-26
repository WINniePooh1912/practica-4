import java.util.*;

public class Graph<T> {
	private ArrayList<ArrayList<Edge<T>>> adj = new ArrayList<>();
	int finalWeight;

	public Graph(int vertexes) {
		for(int i = 0; i < vertexes; i++)
			adj.add(new ArrayList<>());
	}

	public int getFinalWeight() {
		return finalWeight;
	}

	public void addEdge(int start, int end, int weight) {
		// al vertice de inicio se le agrega un final con peso
		adj.get(start).add(new Edge<>(end, weight));
		adj.get(end).add(new Edge<>(start, weight));
	}

	public void printAdj() {
		for(int i = 0; i < adj.size(); i++) {
			System.out.print("El vértice '" + intToChart(i) + "' está conectado con los vértices --> ");
			for (int j = 0; j < adj.get(i).size(); j++) {
                Edge<T> edge = adj.get(i).get(j);
                System.out.print("'" + intToChart(edge.end) + "' (peso: " + edge.weight + ") ");
            }
            System.out.println();
		}
	}

	public char intToChart(int num) {
		num += 65;
		char ch = (char) num;
		return ch;
	}

	private int minDistance(int[] distances, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for(int vertex = 0; vertex < distances.length; vertex++) {
			if(!visited[vertex] && distances[vertex] <= min) {
				min = distances[vertex];
				minIndex = vertex;
			}
		}

		return minIndex;
	}

	public ArrayList<Integer> dijkstra(int start, int end) {
		int vertex = adj.size();
		int[] distances = new int[vertex];
		int[] route = new int[vertex];
		boolean[] visited = new boolean[vertex];

		// vertices cuestan infinito, routa -1 e inicio cuesta 0
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(route, -1);
		distances[start] = 0;

		for(int counter = 0; counter < (vertex -1); counter++) {
			int estimated = minDistance(distances, visited);
			visited[estimated] = true;

			for(Edge<T> edge: adj.get(estimated)) {
				// si el nodo no está visitado, la estimación no es infinita
				// y la estimación nueva es menor a la ya hecha
				if(!visited[edge.end] && distances[estimated] != Integer.MAX_VALUE && distances[estimated] + edge.weight < distances[edge.end]) {
					distances[edge.end] = distances[estimated] + edge.weight;
					route[edge.end] = estimated;
				}
			}
		}
		finalWeight = distances[end];
		return path(route, end);
	}

	private ArrayList<Integer> path(int[] route, int end) {
		ArrayList<Integer> path = new ArrayList<>();
		int current = end;
		while (current != -1) {
            path.add(current);
            current = route[current];
        }
		Collections.reverse(path);

		return path;
	}

	public ArrayList<Character> path(ArrayList<Integer> route) {
		ArrayList<Character> graphPath = new ArrayList<>();

		route.forEach((n) -> graphPath.add(intToChart(n)));

		return graphPath;
	}
}
