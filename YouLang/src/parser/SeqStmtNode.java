package parser;

import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class SeqStmtNode extends Node {
	
	SequenceNode sequenceNode;
	Parser.Reference<Stmt> stmtRef;

	public SeqStmtNode(Grammar newParent, SequenceNode sequenceNode) {
		super(newParent);
		this.sequenceNode = sequenceNode;
	}

	@Override
	public Parser<Stmt> parser() {
		Parser.Reference<Stmt> seqStmtRef = new Parser.Reference<Stmt>();
		sequenceNode.setSeqStmtRef(seqStmtRef);
		sequenceNode.setStmtRef(stmtRef);
		Parser<Stmt> result = Parsers.or(sequenceNode.parser(), stmtRef.lazy());
		seqStmtRef.set(result);
		return result;
	}

	public void setStmtRef(Parser.Reference<Stmt> stmtRef) {
		this.stmtRef = stmtRef;
	}

}
