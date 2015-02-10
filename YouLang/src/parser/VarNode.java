package parser;

import interpreter.VarExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.misc.Mapper;

public class VarNode extends Node {

	public VarNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<VarExp> parser() {
		return Parsers.sequence(ignored, Mapper.curry(VarExp.class).sequence(Scanners.IDENTIFIER));
	}

}
