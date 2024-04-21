public class Main {
	public static void main(String[] args) {
	//start main graph
		Graph busNetwork = new Graph(true, false);

		Vertex route145 = busNetwork.addVertex("Bus T08");
		Vertex route897 = busNetwork.addVertex("Bus T10");
		Vertex route654 = busNetwork.addVertex("Bus T45");

		busNetwork.addEdge(route145, route897, 123);
		busNetwork.addEdge(route145, route654, 321);
		busNetwork.addEdge(route654, route897, 213);
		busNetwork.print();
	//end main graph
	}
}
