package parser;

import interpreter.PlusOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;

public class PlusOpNode extends Node {

	public PlusOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<PlusOp> parser() {
		return Parsers.sequence(ignored, Scanners.string(parent.getPlusOpSetting()).retn(new PlusOp()));
	}

}
