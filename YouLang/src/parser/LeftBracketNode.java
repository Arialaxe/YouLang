package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class LeftBracketNode extends Node {

	public LeftBracketNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		return Scanners.isChar('(').retn('(');
	}

}
