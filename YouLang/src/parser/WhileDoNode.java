package parser;

import org.codehaus.jparsec.Parser;

import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.misc.*;
import interpreter.*;

public class WhileDoNode extends Node {

	Parser<String> whileParser;
	Parser<String> expParser;
	Parser<String> doParser;
	Parser<String> stmtParser;
	
	public WhileDoNode(Grammar newParent, String whileSetting, String doSetting) {
		super(newParent);
		whileParser = new WhileNode(parent, whileSetting).parser();
		expParser = new RootExp(parent).parser();
		doParser = new DoNode(parent, doSetting).parser();
		stmtParser = new RootStmt(parent).parser();
	}

	@Override
	public Parser parser() {
		//TODO: this is a completely placeholdery draft
		

		WhileDoMap map = new WhileDoMap();
		
		Parser<String> parser = Parsers.sequence(whileParser, expParser, 
				doParser, stmtParser, map);
		
		//Mapper.curry(interpreter.WhileStmt.class, whileParser, expParser, doParser, stmtParser)
		
		 //...
		
		return parser;
	}

}
