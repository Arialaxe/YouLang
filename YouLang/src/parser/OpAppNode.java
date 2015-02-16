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
	
	public OpAppNode(Grammar newParent, LeftBracketNode leftBracketNode, RightBracketNode rightBracketNode) {
		super(newParent);
		this.leftBracketNode = leftBracketNode;
		this.rightBracketNode = rightBracketNode;
	}

	@Override
	public Parser<OpAppExp> parser() {
		return Mapper.curry(OpAppExp.class).
				sequence(leftBracketNode.parser(), expNode.parser(), opNode.parser(), expNode.parser(), rightBracketNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}

	public void setOpNode(RootOp opNode) {
		this.opNode = opNode;
	}
}
