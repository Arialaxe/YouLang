package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public abstract class Node {
	
	Grammar parent;
	Parser ignored = Scanners.WHITESPACES.skipMany();

	public Node (Grammar newParent) {
		parent = newParent;
	}
	
	public abstract Parser parser();
	
}
