package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class DoNode extends Node {

	public DoNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<String> parser() {
		return Scanners.string(parent.getDoSetting()).retn("do");
	}

}
