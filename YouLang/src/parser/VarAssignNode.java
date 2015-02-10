package parser;

import interpreter.VarAssignStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class VarAssignNode extends Node {
	
	VarNode varNode;
	EqualsNode equalsNode;
	RootExp expNode;

	public VarAssignNode(Grammar newParent, VarNode varNode, EqualsNode equalsNode, RootExp expNode) {
		super(newParent);
		this.varNode = varNode;
		this.equalsNode = equalsNode;
		this.expNode = expNode;
	}

	@Override
	public Parser<VarAssignStmt> parser() {
		return Mapper.curry(VarAssignStmt.class).sequence(varNode.parser(), equalsNode.parser(), expNode.parser());
	}

}
