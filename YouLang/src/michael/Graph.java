package michael;

public class Graph {
	private Node<String> root;
	
	public String parse(String input) {
		return this.root.parser().parse(input);
	}
}
