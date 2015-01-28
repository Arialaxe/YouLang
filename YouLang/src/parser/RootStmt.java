package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

import interpreter.*;

public class RootStmt extends Node {
	
	Parser<VarAssignStmt> varAssignStmtParser;
	Parser<StmtSeq> stmtSeqParser;
	Parser<IfStmt> ifStmtParser;
	Parser<WhileStmt> whileStmtParser;
	Parser<PrintStmt> printStmtParser;

	public RootStmt(Grammar newParent) {
		super(newParent);
		varAssignStmtParser = new VarAssignNode(parent).parser();
		stmtSeqParser = new StmtSeqNode(parent).parser();
		ifStmtParser = new IfThenElseNode(parent).parser();
		whileStmtParser = new WhileDoNode(parent).parser();
		printStmtParser = new PrintStmtNode(parent).parser();
	}

	@Override
	public Parser<Stmt> parser() {
		return Parsers.or(
				varAssignStmtParser,
				stmtSeqParser,
				ifStmtParser,
				whileStmtParser,
				printStmtParser);
	}

}
