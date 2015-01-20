package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class VarNode extends Node {

	public VarNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		return Scanners.IDENTIFIER; //TODO: revisit this
	}

}
