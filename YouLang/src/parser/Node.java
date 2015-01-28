package parser;

import org.codehaus.jparsec.Parser;

public abstract class Node {
	
	Grammar parent;
	
	public Node (Grammar newParent) {
		parent = newParent;
	}
	
	public abstract Parser parser();
	
}
