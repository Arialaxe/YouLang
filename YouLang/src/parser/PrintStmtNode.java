package parser;

import interpreter.PrintStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class PrintStmtNode extends Node {

	PrintNode printNode;
	RootExp expNode;
	
	public PrintStmtNode(Grammar newParent, PrintNode printNode) {
		super(newParent);
		this.printNode = printNode;
	}

	@Override
	public Parser<PrintStmt> parser() {
		return Mapper.curry(PrintStmt.class).sequence(printNode.parser(), expNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}
}
