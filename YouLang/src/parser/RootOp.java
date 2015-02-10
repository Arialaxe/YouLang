package parser;

import interpreter.Op;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class RootOp extends Node {
	
	PlusOpNode plusOpNode;
	SubOpNode subOpNode;
	MulOpNode mulOpNode;
	DivOpNode divOpNode;
	GreaterOpNode greaterOpNode;
	
	public RootOp(Grammar newParent, PlusOpNode plusOpNode, SubOpNode subOpNode, MulOpNode mulOpNode, 
			DivOpNode divOpNode, GreaterOpNode greaterOpNode) {
		super(newParent);
		this.plusOpNode = plusOpNode;
		this.subOpNode = subOpNode;
		this.mulOpNode = mulOpNode;
		this.divOpNode = divOpNode;
		this.greaterOpNode = greaterOpNode;
	}

	@Override
	public Parser<Op> parser() {
		return Parsers.or(plusOpNode.parser(), subOpNode.parser(), mulOpNode.parser(), 
				divOpNode.parser(), greaterOpNode.parser());
	}

}
