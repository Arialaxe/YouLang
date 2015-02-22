package parser;

import interpreter.SeqStmt;
import interpreter.Sequence;
import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parser.Reference;
import org.codehaus.jparsec.misc.Mapper;

public class SequenceNode extends Node {
	
	Parser.Reference<SeqStmt> seqStmtRef;
	SemiColonNode semiColonNode;
	Parser.Reference<Stmt> stmtRef;

	public SequenceNode(Grammar newParent, SemiColonNode semiColonNode) {
		super(newParent);
		this.semiColonNode = semiColonNode;
	}

	@Override
	public Parser<Sequence> parser() {
		return Mapper.curry(Sequence.class).sequence(stmtRef.lazy(), semiColonNode.parser(), seqStmtRef.lazy());
	}
	
	public void setSeqStmtRef(Reference<SeqStmt> seqStmtRef) {
		this.seqStmtRef = seqStmtRef;
	}

	public void setStmtRef(Parser.Reference<Stmt> stmtRef) {
		this.stmtRef = stmtRef;
	}
}
