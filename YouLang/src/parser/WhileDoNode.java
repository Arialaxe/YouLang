package parser;

import interpreter.WhileStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class WhileDoNode extends Node {

	WhileNode whileNode;
	RootExp expNode;
	DoNode doNode;
	RootStmt stmtNode;
	
	public WhileDoNode(Grammar newParent, WhileNode whileNode, DoNode doNode) {
		super(newParent);
		this.whileNode = whileNode;
		this.doNode = doNode;
	}

	@Override
	public Parser<WhileStmt> parser() {
		return Mapper.curry(WhileStmt.class).sequence(whileNode.parser(), expNode.parser(), doNode.parser(), stmtNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}

	public void setStmtNode(RootStmt stmtNode) {
		this.stmtNode = stmtNode;
	}

}
