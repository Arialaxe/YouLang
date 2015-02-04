package parser;

import interpreter.SubOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class SubOpNode extends Node {

	public SubOpNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<SubOp> parser() {
		return Scanners.string(parent.getSubOpSetting()).retn(new SubOp());
	}

}
