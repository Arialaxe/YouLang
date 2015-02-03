package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class LeftBracketNode extends Node {

	public LeftBracketNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<String> parser() {
		return Scanners.string(parent.getLeftBracketSetting()).retn("(");
	}

}
