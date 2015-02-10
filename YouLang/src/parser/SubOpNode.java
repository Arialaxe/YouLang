package parser;

import interpreter.SubOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;

public class SubOpNode extends Node {

	public SubOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<SubOp> parser() {
		return Parsers.sequence(ignored, Scanners.string(parent.getSubOpSetting()).retn(new SubOp()));
	}

}
