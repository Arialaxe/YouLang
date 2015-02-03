package interpreter;

public class VarAssignStmt extends Stmt {

	private VarExp var;
	private Exp exp;
	
	public VarAssignStmt (VarExp varRetn, String equalsRetn, Exp expRetn) {
		this.var = varRetn;
		this.exp = expRetn;
	}
	
	@Override
	public void eval(){
		var.assign(exp.eval());
	}

	public VarExp getVar() {
		return var;
	}
}
