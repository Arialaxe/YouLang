package interpreter;

public class PrintStmt extends Stmt {

	private Exp exp;
	
	public PrintStmt (Exp exp) {
		this.exp = exp;
	}
	
	@Override
	public void eval() {
		//decoupled - sent to method in interface package - we don't do it here!
		//TODO: call the method for printing exp.eval()
	}
}
