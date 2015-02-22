package interpreter;

public class PrintStmt extends Stmt {

	private Exp exp;
	
	public PrintStmt (String printRetn, Exp expRetn) {
		this.exp = expRetn;
	}
	
	@Override
	public void eval() {
		//decoupled - sent to method in interface package - we don't do it here!
		frontEnd.Printer.printOutput(Integer.toString(exp.eval()));
	}
}
