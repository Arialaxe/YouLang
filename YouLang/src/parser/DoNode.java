package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class DoNode extends Node {

	public DoNode(Grammar newParent) {
		super(newParent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Parser parser() {
		return Scanners.string("do").retn("do");
	}

}
