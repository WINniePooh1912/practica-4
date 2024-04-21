import java.util.ArrayList;

public class Graph {
	private ArrayList<Vertex> vertices;

	private boolean isWeighted;
	private boolean isDirected;

	public Graph(boolean isWeighted, boolean isDirected) {
		this.vertices = new ArrayList<Vertex>();
		this.isWeighted = isWeighted;
		this.isDirected = isDirected;
	}

	public ArrayList<Vertex> getVertices() {
		return this.vertices;
	}

	public boolean isWeighted() {
		return this.isWeighted;
	}

	public boolean isDirected() {
		return this.isDirected;
	}

	public Vertex addVertex(String value) {
		Vertex newVertex = new Vertex(value);

		this.vertices.add(newVertex);
		return newVertex;
	}

	public void addEdge(Vertex start, Vertex end, int weight) {
		if(!this.isWeighted)
			weight = -1;

		start.addEdge(end, weight);
		if(!this.isDirected)
			end.addEdge(start, weight);
	}

	public void removeEdge(Vertex start, Vertex end) {
		start.removeEdge(end);
		if(!this.isDirected)
			end.removeEdge(start);
	}

	public void removeVertex(Vertex vertex) {
		this.vertices.remove(vertex);
	}

	public Vertex getVertexByValue(String value) {
		for(Vertex vertex: this.vertices) {
			if (vertex.getValue().equals(value)) {
				return vertex;
			}
		}

		return null;
	}

	public void print() {
		for(Vertex vertex: this.vertices) {
			vertex.print(isWeighted);
		}
	}
}
