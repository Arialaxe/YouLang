package interpreter;

import java.util.Vector;

public class VarAssignStmt extends Stmt {

	private VarExp var;
	private Exp exp;
	
	public VarAssignStmt (VarExp varRetn, String equalsRetn, Exp expRetn) {
		this.var = varRetn;
		this.exp = expRetn;
	}
	
	@Override
	public void eval(){
		if (!VarList.varInitFlag) {
			VarList.varList = new Vector<VarExp>();
			var.assign(exp.eval());
			VarList.varList.add(var);
			VarList.varInitFlag = true;
		}
		else {
			for (VarExp v : VarList.varList) {
				if (v.getID().equals(var.getID())) {
					v.assign(var.eval());
					return;
				}
			}
			VarList.varList.add(var);
		}
	}

	public VarExp getVar() {
		return var;
	}
}
