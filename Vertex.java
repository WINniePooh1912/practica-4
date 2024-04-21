import java.util.ArrayList;

public class Vertex {
	private String value;
	private ArrayList<Edge> edges;

	public Vertex(String value) {
		this.value = value;
		this.edges = new ArrayList<Edge>();
	}

	public String getValue() {
		return value;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void addEdge(Vertex end, int weight) {
		this.edges.add(new Edge(this, end, weight));
	}

	public void removeEdge(Vertex end) {
		this.edges.removeIf(edge -> edge.getEnd().equals(end));
	}

	public void print(boolean showWeight) {
		String message = "";

		if(this.edges.size() == 0) {
			System.out.println(this.value + " -->");
			return;
		}

		for(int i = 0; i < this.edges.size(); i++) {
			if(i == 0)
				message += this.edges.get(i).getStart().value + " --> ";

			message += this.edges.get(i).getEnd().value;

			if(showWeight)
				message += " (" + this.edges.get(i).getWeight() + ")";

			if(i != this.edges.size() - 1)
				message += ", ";
		}
		System.out.println(message);
	}
}

