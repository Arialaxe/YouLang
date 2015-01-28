package parser;

import interpreter.Exp;
import interpreter.VarAssignStmt;
import interpreter.VarExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class VarAssignNode extends Node {
	
	Parser<VarExp> varParser;
	Parser<String> equalsParser;
	Parser<Exp> expParser;

	public VarAssignNode(Grammar newParent) {
		super(newParent);
		varParser = new VarNode(parent).parser();
		equalsParser = new EqualsNode(parent).parser();
		expParser = new RootExp(parent).parser();
	}

	@Override
	public Parser<VarAssignStmt> parser() {
		return Mapper.curry(VarAssignStmt.class).sequence(varParser, equalsParser, expParser);
	}

}
