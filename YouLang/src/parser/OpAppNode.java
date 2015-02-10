package parser;

import interpreter.Exp;
import interpreter.OpAppExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class OpAppNode extends Node {

	LeftBracketNode leftBracketNode;
	RootExp expNode;
	RootOp opNode;
	RightBracketNode rightBracketNode;
	
	public OpAppNode(Grammar newParent, LeftBracketNode leftBracketNode, RootExp expNode, 
			RootOp opNode, RightBracketNode rightBracketNode) {
		super(newParent);
		this.leftBracketNode = leftBracketNode;
		this.expNode = expNode;
		this.opNode = opNode;
		this.rightBracketNode = rightBracketNode;
	}

	@Override
	public Parser<OpAppExp> parser() {
		Parser<Exp> expParser = expNode.parser();
		return Mapper.curry(OpAppExp.class).
				sequence(leftBracketNode.parser(), expParser, opNode.parser(), expParser, rightBracketNode.parser());
	}

}
