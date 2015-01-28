package parser;

import interpreter.StmtSeq;
import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class StmtSeqNode extends Node {
	
	Parser<Stmt> stmt1Parser;
	Parser<String> semiColonParser;
	Parser<Stmt> stmt2Parser;

	public StmtSeqNode(Grammar newParent) {
		super(newParent);
		stmt1Parser = new RootStmt(parent).parser();
		semiColonParser = new SemiColonNode(parent).parser();
		stmt2Parser = new RootStmt(parent).parser();
	}

	@Override
	public Parser<StmtSeq> parser() {
		return Mapper.curry(StmtSeq.class).sequence(stmt1Parser, semiColonParser, stmt2Parser);
	}

}
