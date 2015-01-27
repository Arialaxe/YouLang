package parser;

import interpreter.*;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.functors.*;
import org.codehaus.jparsec.misc.*;

public class IfThenElseNode extends Node {

	Parser<String> ifParser;
	Parser<Exp> expParser;
	Parser<String> thenParser;
	Parser<Stmt> thenStmtParser;
	Parser<String> elseParser;
	Parser<Stmt> elseStmtParser;
	
	public IfThenElseNode(Grammar newParent, String ifSetting, String thenSetting, String elseSetting) {
		super(newParent);
		Parser<String> ifParser = new IfNode(parent, ifSetting).parser();
		Parser<Exp> expParser = new RootExp(parent).parser();
		Parser<String> thenParser = new ThenNode(parent, thenSetting).parser();
		Parser<Stmt> thenStmtParser = new RootStmt(parent).parser();
		Parser<String> elseParser = new ElseNode(parent, elseSetting).parser();
		Parser<Stmt> elseStmtParser = new RootStmt(parent).parser();
	}

	@Override
	public Parser<IfStmt> parser() {
		return Mapper.curry(IfStmt.class).sequence(ifParser, expParser, thenParser, thenStmtParser, elseParser, elseStmtParser);
	}

}
