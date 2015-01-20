package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class EqualsNode extends Node {

	public EqualsNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		return Scanners.isChar('=').retn('-');
	}

}
