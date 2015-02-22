package parser;

import interpreter.Exp;
import interpreter.OpAppExp;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class OpAppNode extends Node {

	LeftBracketNode leftBracketNode;
	Parser.Reference<Exp> expRef;
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
				sequence(leftBracketNode.parser(), expRef.lazy(), opNode.parser(), expRef.lazy(), rightBracketNode.parser());
	}

	public void setExpRef(Parser.Reference<Exp> expRef) {
		this.expRef = expRef;
	}

	public void setOpNode(RootOp opNode) {
		this.opNode = opNode;
	}
}
