package parser;

import interpreter.VarAssignStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class VarAssignNode extends Node {
	
	private VarNode varNode;
	private EqualsNode equalsNode;
	private RootExp expNode;

	public VarAssignNode(Grammar newParent, VarNode varNode, EqualsNode equalsNode) {
		super(newParent);
		this.varNode = varNode;
		this.equalsNode = equalsNode;
	}

	@Override
	public Parser<VarAssignStmt> parser() {
		return Mapper.curry(VarAssignStmt.class).sequence(varNode.parser(), equalsNode.parser(), expNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}

}
