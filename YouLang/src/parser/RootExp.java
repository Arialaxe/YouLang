package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

import interpreter.*;

public class RootExp extends Node {

	IntNode intNode;
	VarNode varNode;
	OpAppNode opAppNode;
	
	public RootExp(Grammar newParent, IntNode intNode, VarNode varNode, OpAppNode opAppNode) {
		super(newParent);
		this.intNode = intNode;
		this.varNode = varNode;
		this.opAppNode = opAppNode;
	}

	@Override
	public Parser<Exp> parser() {
		return Parsers.or(intNode.parser(), varNode.parser(), opAppNode.parser());
	}

}
