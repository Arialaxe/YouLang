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
		Parser.Reference<Stmt> stmtRef = new Parser.Reference<Stmt>();
		seqStmtNode.setStmtRef(stmtRef);
		ifThenElseNode.setStmtRef(stmtRef);
		whileDoNode.setStmtRef(stmtRef);
		Parser<Stmt> result = Parsers.or(varAssignNode.parser(), seqStmtNode.parser(), 
											ifThenElseNode.parser(), whileDoNode.parser(),
												printStmtNode.parser()).cast();
		//Parser<Stmt> result = varAssignNode.parser().cast();
		stmtRef.set(result);
		return result;
	}

}
