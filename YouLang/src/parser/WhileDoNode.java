package parser;

import interpreter.SeqStmt;
import interpreter.WhileStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.Mapper;

public class WhileDoNode extends Node {

	WhileNode whileNode;
	RootExp expNode;
	DoNode doNode;
	LeftBracketNode leftBracketNode;
	Parser.Reference<SeqStmt> seqStmtRef;
	RightBracketNode rightBracketNode;
	
	public WhileDoNode(Grammar newParent, WhileNode whileNode, DoNode doNode, 
			LeftBracketNode leftBracketNode, RightBracketNode rightBracketNode) {
		super(newParent);
		this.whileNode = whileNode;
		this.doNode = doNode;
		this.leftBracketNode = leftBracketNode;
		this.rightBracketNode = rightBracketNode;
	}

	@Override
	public Parser<WhileStmt> parser() {
		return Mapper.curry(WhileStmt.class).sequence(whileNode.parser(), expNode.parser(), 
				doNode.parser(), leftBracketNode.parser(), seqStmtRef.lazy(), rightBracketNode.parser());
	}

	public void setExpNode(RootExp expNode) {
		this.expNode = expNode;
	}

	public void setSeqStmtRef(Parser.Reference<SeqStmt> seqStmtRef) {
		this.seqStmtRef = seqStmtRef;
	}

}
