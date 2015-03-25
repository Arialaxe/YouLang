package parser;

import interpreter.IfStmt;
import interpreter.SeqStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parser.Reference;
import org.codehaus.jparsec.misc.Mapper;

public class IfThenElseNode extends Node {

	IfNode ifNode;
	RootExp expNode;
	ThenNode thenNode;
	LeftBracketNode leftBracketNode;
	RightBracketNode rightBracketNode;
	Parser.Reference<SeqStmt> seqStmtRef;
	ElseNode elseNode;
	
	public IfThenElseNode(Grammar newParent, IfNode ifNode, ThenNode thenNode, LeftBracketNode leftBracketNode, 
			RightBracketNode rightBracketNode, ElseNode elseNode) {
		super(newParent);
		this.ifNode = ifNode;
		this.thenNode = thenNode;
		this.leftBracketNode = leftBracketNode;
		this.rightBracketNode = rightBracketNode;
		this.elseNode = elseNode;
	}

	@Override
	public Parser<IfStmt> parser() {
		return Mapper.curry(IfStmt.class).
				sequence(ifNode.parser(), expNode.parser(), thenNode.parser(), leftBracketNode.parser(), 
						seqStmtRef.lazy(), rightBracketNode.parser(), elseNode.parser(), leftBracketNode.parser(),
						seqStmtRef.lazy(), rightBracketNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}

	public void setSeqStmtRef(Reference<SeqStmt> seqStmtRef) {
		this.seqStmtRef = seqStmtRef;
		
	}

}
