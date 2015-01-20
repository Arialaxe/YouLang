package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class WhileDoNode extends Node {

	public WhileDoNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		//TODO: this is a completely placeholdery draft
		
		Parser<String> whileParser = new WhileNode(parent).parser();
		Parser<String> expParser = new RootExp(parent).parser();
		Parser<String> doParser = new DoNode(parent).parser();
		Parser<String> stmtParser = new RootStmt(parent).parser();
		WhileDoMap map = new WhileDoMap();
		
		Parser parser = Parsers.sequence(whileParser, expParser, 
				doParser, stmtParser, map);
		
		
		 //...
		
		return parser;
	}

}
