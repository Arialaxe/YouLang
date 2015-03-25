package parser;

import interpreter.PrintStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class PrintStmtNode extends Node {

	PrintNode printNode;
	RootExp expNode;
	//IntNode intNode;
	
	public PrintStmtNode(Grammar newParent, PrintNode printNode, IntNode intNode) {
		super(newParent);
		this.printNode = printNode;
		//this.intNode = intNode;
	}

	@Override
	public Parser<PrintStmt> parser() {
		return Mapper.curry(PrintStmt.class).sequence(printNode.parser(), expNode.parser());
		//return Mapper.curry(PrintStmt.class).sequence(printNode.parser(), intNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}
}
