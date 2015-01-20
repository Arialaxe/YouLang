package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class ElseNode extends Node {

	public ElseNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		return Scanners.string("else").retn("else");
	}

}
