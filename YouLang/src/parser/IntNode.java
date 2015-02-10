package parser;

import interpreter.IntExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.misc.Mapper;

public class IntNode extends Node {
	
	public IntNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<IntExp> parser() {
		return Parsers.sequence(ignored, Mapper.curry(IntExp.class).sequence(Scanners.INTEGER));
	}
}
