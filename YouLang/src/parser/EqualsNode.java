package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class EqualsNode extends Node {

	public EqualsNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<String> parser() {
		return Scanners.string(parent.getEqualsSetting()).retn("=");
	}

}
