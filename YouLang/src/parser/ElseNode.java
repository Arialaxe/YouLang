package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class ElseNode extends Node {

	public ElseNode(Grammar newParent) {
		super(newParent);
	}	

	@Override
	public Parser<String> parser() {
		return Scanners.string(parent.getElseSetting()).retn("else");
	}

}
