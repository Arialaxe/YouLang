package parser;

import interpreter.GreaterOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;

public class GreaterOpNode extends Node {

	public GreaterOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<GreaterOp> parser() {
		return Parsers.sequence(ignored, Scanners.string(parent.getGreaterOpSetting()).retn(new GreaterOp()));
	}

}
