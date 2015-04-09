package interpreter;

import java.util.LinkedList;
import java.util.Vector;

public class VarAssignStmt extends Stmt {

	private VarExp var;
	private Exp exp;
	
	public VarAssignStmt (VarExp varRetn, String equalsRetn, Exp expRetn) {
		this.var = varRetn;
		this.exp = expRetn;
	}
	
	@Override
	public LinkedList<String> eval(LinkedList<String> output){
		if (!VarList.varInitFlag) {
			VarList.varList = new Vector<VarExp>();
			var.assign(exp.eval());
			VarList.varList.add(var);
			VarList.varInitFlag = true;
		}
		else {
			for (VarExp v : VarList.varList) {
				if (v.getID().equals(var.getID())) {
					v.assign(exp.eval());
					return output;
				}
			}
			VarList.varList.add(var);
		}
		return output;
	}

	public VarExp getVar() {
		return var;
	}
}
