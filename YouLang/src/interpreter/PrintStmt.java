package interpreter;

import java.util.LinkedList;

public class PrintStmt extends Stmt {

	private Exp exp;
	
	public PrintStmt (String printRetn, Exp expRetn) {
		this.exp = expRetn;
	}
	
	@Override
	public LinkedList<String> eval(LinkedList<String> output) {
		output.add(Integer.toString(exp.eval()));
		return output;
	}
}
