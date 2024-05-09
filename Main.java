import java.util.ArrayList;

public class Main {

	public char intToChart(int num) {
		num += 65;
		char ch = (char) num;
		return ch;
	}

	public static void main(String[] args) {
	//start main graph
		Graph<Integer> grafo = new Graph<>(8);
		/*VERTICES
			* A = 0
			* B = 1
			* C = 2
			* D = 3
			* E = 4
			* F = 5
			* G = 6
			* H = 7
		*/

		grafo.addEdge(0, 1, 2); // A - B 2
		grafo.addEdge(0, 5, 1); // A - F 1

		grafo.addEdge(1, 2, 2); // B - C 2
		grafo.addEdge(1, 3, 2); // B - D 2
		grafo.addEdge(1, 4, 4); // B - E 4

		grafo.addEdge(2, 4, 3); // C - E 3
		grafo.addEdge(2, 7, 1); // C - H 1

		grafo.addEdge(3, 4, 4); // D - E 4
		grafo.addEdge(3, 5, 3); // D - F 3

		grafo.addEdge(4, 6, 7); // E - G 7

		grafo.addEdge(5, 6, 5); // F - G 5

		grafo.addEdge(6, 7, 3); // G - H 3

		grafo.printAdj();
		int start = 0, end = 6; // De A a G
		ArrayList<Integer> path = grafo.dijkstra(start, end);
		ArrayList<Character> graphPath = grafo.path(path);

		System.out.println("La ruta de menor peso desde el vértice " + grafo.intToChart(start) + " hasta el vértice " + grafo.intToChart(end) + " es: " + graphPath + " con peso mínimo de " + grafo.getFinalWeight());
	//end main graph
	}
}
