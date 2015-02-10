package parser;

import interpreter.Sequence;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class SequenceNode extends Node {
	
	SeqStmtNode seqStmtNode;
	SemiColonNode semiColonNode;
	RootStmt stmtNode;

	public SequenceNode(Grammar newParent, SeqStmtNode seqStmtNode, SemiColonNode semiColonNode, RootStmt stmtNode) {
		super(newParent);
		this.seqStmtNode = seqStmtNode;
		this.semiColonNode = semiColonNode;
		this.stmtNode = stmtNode;
	}

	@Override
	public Parser<Sequence> parser() {
		return Mapper.curry(Sequence.class).sequence(seqStmtNode.parser(), semiColonNode.parser(), stmtNode.parser());
	}

}
