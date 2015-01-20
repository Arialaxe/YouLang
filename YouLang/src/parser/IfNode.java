package parser;

import interpreter.IfStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class IfNode extends Node {

	public IfNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		return Scanners.string("if").retn("if");
	}

}
