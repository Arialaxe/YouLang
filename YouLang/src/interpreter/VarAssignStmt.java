package interpreter;

public class VarAssignStmt extends Stmt {

	private VarExp var;
	private Exp exp;
	
	public VarAssignStmt (VarExp varRetn, String equalsRetn, Exp expRetn) {
		this.var = varRetn;
		this.exp = expRetn;
	}
	
	public VarAssignStmt (VarExp var, Exp exp){
		this.var = var;
		this.exp = exp;
	}
	@Override
	public void eval(){
		var.assign(exp.eval());
	}
}
