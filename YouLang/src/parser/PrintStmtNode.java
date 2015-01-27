package parser;

import interpreter.Exp;
import interpreter.PrintStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class PrintStmtNode extends Node {

	Parser<String> printParser;
	Parser<Exp> expParser;
	
	public PrintStmtNode(Grammar newParent, String printSetting) {
		super(newParent);
		printParser = new PrintNode(parent, printSetting).parser();
		expParser = new RootExp(parent).parser();
	}

	@Override
	public Parser<PrintStmt> parser() {
		return Mapper.curry(PrintStmt.class).sequence(printParser, expParser);
	}

}
