package parser;

import interpreter.Exp;
import interpreter.Stmt;
import interpreter.WhileStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class WhileDoNode extends Node {

	Parser<String> whileParser;
	Parser<Exp> expParser;
	Parser<String> doParser;
	Parser<Stmt> stmtParser;
	
	public WhileDoNode(Grammar newParent) {
		super(newParent);
		whileParser = new WhileNode(parent).parser();
		expParser = new RootExp(parent).parser();
		doParser = new DoNode(parent).parser();
		stmtParser = new RootStmt(parent).parser();
	}

	@Override
	public Parser<WhileStmt> parser() {
		return Mapper.curry(WhileStmt.class).sequence(whileParser, expParser, doParser, stmtParser);
	}

}
