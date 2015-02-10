package parser;

import interpreter.IfStmt;
import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class IfThenElseNode extends Node {

	IfNode ifNode;
	RootExp expNode;
	ThenNode thenNode;
	RootStmt stmtNode;
	ElseNode elseNode;
	
	public IfThenElseNode(Grammar newParent, IfNode ifNode, RootExp expNode, ThenNode thenNode,
			RootStmt stmtNode, ElseNode elseNode) {
		super(newParent);
		this.ifNode = ifNode;
		this.expNode = expNode;
		this.thenNode = thenNode;
		this.stmtNode = stmtNode;
		this.elseNode = elseNode;
	}

	@Override
	public Parser<IfStmt> parser() {
		Parser<Stmt> stmtParser = stmtNode.parser();
		return Mapper.curry(IfStmt.class).
				sequence(ifNode.parser(), expNode.parser(), thenNode.parser(), stmtParser, elseNode.parser(), stmtParser);
	}

}
