package parser;

import interpreter.Sequence;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class SequenceNode extends Node {
	
	SeqStmtNode seqStmtNode;
	SemiColonNode semiColonNode;
	RootStmt stmtNode;

	public SequenceNode(Grammar newParent, SemiColonNode semiColonNode) {
		super(newParent);
		this.semiColonNode = semiColonNode;
	}

	@Override
	public Parser<Sequence> parser() {
		return Mapper.curry(Sequence.class).sequence(stmtNode.parser(), semiColonNode.parser(), seqStmtNode.parser());
	}
	
	public void setSeqStmtNode(SeqStmtNode seqStmtNode) {
		this.seqStmtNode = seqStmtNode;
	}

	public void setStmtNode(RootStmt stmtNode) {
		this.stmtNode = stmtNode;
	}
}
