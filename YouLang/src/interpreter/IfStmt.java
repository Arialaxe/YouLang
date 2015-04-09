package interpreter;

import java.util.LinkedList;

public class IfStmt extends Stmt {

	private Exp condition;
	private Stmt ifTrue;
	private Stmt ifFalse;
	
	public IfStmt (String ifRetn, Exp expRetn, String thenRetn, String leftBracketRetn, Stmt thenStmtRetn, 
			String rightBracketRetn, String elseRetn, String leftBracketRetn2, Stmt elseStmtRetn,
			String rightBracketRetn2) {
		this.condition = expRetn;
		this.ifTrue = thenStmtRetn;
		this.ifFalse = elseStmtRetn;
	}
	
	@Override 
	public LinkedList<String> eval(LinkedList<String> output){
		if (condition.eval() > 0) {
			ifTrue.eval(output);
		}
		else ifFalse.eval(output);
		return output;
	}
}
