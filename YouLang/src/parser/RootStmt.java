package parser;

import interpreter.SeqStmt;
import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class RootStmt extends Node {
	
	VarAssignNode varAssignNode;
	IfThenElseNode ifThenElseNode;
	WhileDoNode whileDoNode;
	PrintStmtNode printStmtNode;
	Parser.Reference<SeqStmt> seqStmtRef;

	public RootStmt(Grammar newParent, VarAssignNode varAssignNode, IfThenElseNode ifThenElseNode, 
			WhileDoNode whileDoNode, PrintStmtNode printStmtNode) {
		super(newParent);
		this.varAssignNode = varAssignNode;
		this.ifThenElseNode = ifThenElseNode;
		this.whileDoNode = whileDoNode;
		this.printStmtNode = printStmtNode;
	}

	@Override
	public Parser<Stmt> parser() {
		ifThenElseNode.setSeqStmtRef(seqStmtRef);
		whileDoNode.setSeqStmtRef(seqStmtRef);
		Parser<Stmt> result = Parsers.or(varAssignNode.parser(), 
				ifThenElseNode.parser(), whileDoNode.parser(), printStmtNode.parser()).cast();
		return result;
	}

	public void setSeqStmtRef(Parser.Reference<SeqStmt> seqStmtRef) {
		this.seqStmtRef = seqStmtRef;
	}
}
