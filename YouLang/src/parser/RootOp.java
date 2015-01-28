package parser;

import interpreter.DivOp;
import interpreter.GreaterOp;
import interpreter.MulOp;
import interpreter.Op;
import interpreter.PlusOp;
import interpreter.SubOp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class RootOp extends Node {
	
	Parser<PlusOp> plusParser;
	Parser<SubOp> subParser;
	Parser<MulOp> mulParser;
	Parser<DivOp> divParser;
	Parser<GreaterOp> greaterParser;
	
	public RootOp(Grammar newParent) {
		super(newParent);
		plusParser = new PlusOpNode(parent).parser();
		subParser = new SubOpNode(parent).parser();
		mulParser = new MulOpNode(parent).parser();
		divParser = new DivOpNode(parent).parser();
		greaterParser = new GreaterOpNode(parent).parser();
	}

	@Override
	public Parser<Op> parser() {
		return Parsers.or(plusParser, subParser, mulParser, divParser, greaterParser);
	}

}
