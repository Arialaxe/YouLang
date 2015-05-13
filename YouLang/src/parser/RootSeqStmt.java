package parser;

import interpreter.SeqStmt;
import interpreter.Stmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;

public class RootSeqStmt extends Node {
	
	SequenceNode sequenceNode;
	//Parser.Reference<Stmt> stmtRef;
	RootStmt stmtNode;

	public RootSeqStmt(Grammar newParent, SequenceNode sequenceNode) {
		super(newParent);
		this.sequenceNode = sequenceNode;
	}

	@Override
	public Parser<SeqStmt> parser() {
		Parser.Reference<SeqStmt> seqStmtRef = new Parser.Reference<SeqStmt>();
		sequenceNode.setSeqStmtRef(seqStmtRef);
		sequenceNode.setStmtNode(stmtNode);
		stmtNode.setSeqStmtRef(seqStmtRef);
		Parser<SeqStmt> result = Parsers.or(sequenceNode.parser(), Parsers.always().retn(new interpreter.Epsilon()).cast()).cast();
		//didn't use "many()" - easier to map to interpreter class this way
		seqStmtRef.set(result);
		return result;
	}

	public void setStmtNode(RootStmt stmtNode) {
		this.stmtNode = stmtNode;
	}
	
	
	/*public void setStmtRef(Parser.Reference<Stmt> stmtRef) {
		this.stmtRef = stmtRef;
	}
	*/

}
