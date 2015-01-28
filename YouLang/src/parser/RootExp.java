package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

import interpreter.*;

public class RootExp extends Node {

	Parser<IntExp> intParser;
	Parser<VarExp> varParser;
	Parser<OpAppExp> opAppParser;
	
	public RootExp(Grammar newParent) {
		super(newParent);
		intParser = new IntNode(parent).parser();
		varParser = new VarNode(parent).parser();
		opAppParser = new OpAppNode(parent).parser();
	}

	@Override
	public Parser<Exp> parser() {
		return Parsers.or(intParser, varParser, opAppParser);
	}

}
