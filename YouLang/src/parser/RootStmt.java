package parser;

import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class RootStmt extends Node {
	
	VarAssignNode varAssignNode;
	SeqStmtNode seqStmtNode;
	IfThenElseNode ifThenElseNode;
	WhileDoNode whileDoNode;
	PrintStmtNode printStmtNode;

	public RootStmt(Grammar newParent, VarAssignNode varAssignNode, SeqStmtNode seqStmtNode, 
			IfThenElseNode ifThenElseNode, WhileDoNode whileDoNode, PrintStmtNode printStmtNode) {
		super(newParent);
		this.varAssignNode = varAssignNode;
		this.seqStmtNode = seqStmtNode;
		this.ifThenElseNode = ifThenElseNode;
		this.whileDoNode = whileDoNode;
		this.printStmtNode = printStmtNode;
	}

	@Override
	public Parser<Stmt> parser() {
		return Parsers.or(
				varAssignNode.parser(),
				seqStmtNode.parser(),
				ifThenElseNode.parser(),
				whileDoNode.parser(),
				printStmtNode.parser());
	}

}
