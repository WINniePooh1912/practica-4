public class Edge<T>{
	int end = 0;
	int weight = 0;

	public Edge(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
}
