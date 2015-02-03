package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.misc.Mapper;

import interpreter.IntExp;
import interpreter.VarExp;

public class IntNode extends Node {
	
	public IntNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<IntExp> parser() {
		//return Mapper.curry(VarExp.class).sequence(Scanners.IDENTIFIER); //TODO this defs needs testing...
		return Mapper.curry(IntExp.class).sequence(Scanners.INTEGER);
	}
}
