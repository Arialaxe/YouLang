package interpreter;

import java.util.LinkedList;

public class Sequence extends Stmt {

	private Stmt stmt1;
	private SeqStmt stmt2;
	
	public Sequence (Stmt stmt1Retn, String semiColonRetn, SeqStmt stmt2Retn){
		this.stmt1 = stmt1Retn;
		this.stmt2 = stmt2Retn;
	}
	
	@Override
	public LinkedList<String> eval(LinkedList<String> output){
		return stmt2.eval(stmt1.eval(output));
	}
}
