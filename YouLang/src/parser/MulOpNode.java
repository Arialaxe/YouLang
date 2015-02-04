package parser;

import interpreter.MulOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class MulOpNode extends Node {

	public MulOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<MulOp> parser() {
		return Scanners.string(parent.getMulOpSetting()).retn(new MulOp());
	}

}
