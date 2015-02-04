package parser;

import interpreter.DivOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class DivOpNode extends Node {

	public DivOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<DivOp> parser() {
		return Scanners.string(parent.getDivOpSetting()).retn(new DivOp());
	}

}
