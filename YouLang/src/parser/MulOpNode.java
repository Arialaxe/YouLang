package parser;

import interpreter.MulOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;

public class MulOpNode extends Node {

	public MulOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<MulOp> parser() {
		return Parsers.sequence(ignored, Scanners.string(parent.getMulOpSetting()).retn(new MulOp()));
	}

}
