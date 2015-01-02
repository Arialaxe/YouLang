package interpreter;

public class WhileStmt extends Stmt {

	private Exp exp;
	private Stmt stmt;
	
	public WhileStmt (Exp exp, Stmt stmt) {
		this.exp = exp;
		this.stmt = stmt;
	}
	@Override
	public void eval(){ //TODO: make sure this actually works once you implement the printer
		while (exp.eval() > 0) { //remember - C-style logic
			stmt.eval();
		}
	}
}
