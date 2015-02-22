package interpreter;

public class IfStmt extends Stmt {

	private Exp condition;
	private Stmt ifTrue;
	private Stmt ifFalse;
	
	public IfStmt (String ifRetn, Exp expRetn, String thenRetn, 
					Stmt thenStmtRetn, String elseRetn, Stmt elseStmtRetn) {
		this.condition = expRetn;
		this.ifTrue = thenStmtRetn;
		this.ifFalse = elseStmtRetn;
	}
	
	@Override 
	public void eval(){
		if (condition.eval() > 0) {
			ifTrue.eval();
		}
		else ifFalse.eval();
	}
}
