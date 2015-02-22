package parser;

import interpreter.IfStmt;
import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class IfThenElseNode extends Node {

	IfNode ifNode;
	RootExp expNode;
	ThenNode thenNode;
	Parser.Reference<Stmt> stmtRef;
	ElseNode elseNode;
	
	public IfThenElseNode(Grammar newParent, IfNode ifNode, ThenNode thenNode, ElseNode elseNode) {
		super(newParent);
		this.ifNode = ifNode;
		this.thenNode = thenNode;
		this.elseNode = elseNode;
	}

	@Override
	public Parser<IfStmt> parser() {
		return Mapper.curry(IfStmt.class).
				sequence(ifNode.parser(), expNode.parser(), thenNode.parser(), stmtRef.lazy(), elseNode.parser(), stmtRef.lazy());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}

	public void setStmtRef(Parser.Reference<Stmt> stmtRef) {
		this.stmtRef = stmtRef;
	}

}
