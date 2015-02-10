package parser;

import interpreter.PrintStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class PrintStmtNode extends Node {

	PrintNode printNode;
	RootExp expNode;
	
	public PrintStmtNode(Grammar newParent, PrintNode printNode, RootExp expNode) {
		super(newParent);
		this.printNode = printNode;
		this.expNode = expNode;
	}

	@Override
	public Parser<PrintStmt> parser() {
		return Mapper.curry(PrintStmt.class).sequence(printNode.parser(), expNode.parser());
	}

}
