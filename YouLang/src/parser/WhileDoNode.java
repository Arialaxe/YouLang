package parser;

import interpreter.WhileStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class WhileDoNode extends Node {

	WhileNode whileNode;
	RootExp expNode;
	DoNode doNode;
	RootStmt stmtNode;
	
	public WhileDoNode(Grammar newParent, WhileNode whileNode, RootExp expNode, 
							DoNode doNode, RootStmt stmtNode) {
		super(newParent);
		this.whileNode = whileNode;
		this.expNode = expNode;
		this.doNode = doNode;
		this.stmtNode = stmtNode;
	}

	@Override
	public Parser<WhileStmt> parser() {
		return Mapper.curry(WhileStmt.class).sequence(whileNode.parser(), expNode.parser(), doNode.parser(), stmtNode.parser());
	}

}
