package parser;

import interpreter.Exp;
import interpreter.Op;
import interpreter.OpAppExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class OpAppNode extends Node {

	Parser<String> leftBracketParser;
	Parser<Exp> exp1Parser;
	Parser<Op> opParser;
	Parser<Exp> exp2Parser;
	Parser<String> rightBracketParser;
	
	public OpAppNode(Grammar newParent) {
		super(newParent);
		leftBracketParser = new LeftBracketNode(parent).parser();
		exp1Parser = new RootExp(parent).parser();
		opParser = new RootOp(parent).parser(); //TODO implement global definition of the settings in Grammar, from which we can take this
		exp2Parser = new RootExp(parent).parser();
		rightBracketParser = new RightBracketNode(parent).parser();
	}

	@Override
	public Parser<OpAppExp> parser() {
		return Mapper.curry(OpAppExp.class).sequence(leftBracketParser, exp1Parser, opParser, exp2Parser, rightBracketParser);
	}

}
