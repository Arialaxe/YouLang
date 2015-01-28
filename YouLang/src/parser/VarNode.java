package parser;

import interpreter.VarExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.misc.Mapper;

public class VarNode extends Node {

	public VarNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<VarExp> parser() {
		return Mapper.curry(VarExp.class).sequence(Scanners.IDENTIFIER); //TODO this isn't actually going to work at all, obviously
	}

}
