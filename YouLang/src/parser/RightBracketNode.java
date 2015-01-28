package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class RightBracketNode extends Node {

	public RightBracketNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<String> parser() {
		return Scanners.string(parent.rightBracketSetting).retn(")");
	}

}
