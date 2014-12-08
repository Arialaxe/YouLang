package interpreter;

public class SeqStmt extends Stmt {

	private Stmt stmt1;
	private Stmt stmt2;
	
	public SeqStmt (Stmt stmt1, Stmt stmt2) {
		this.stmt1 = stmt1;
		this.stmt2 = stmt2;
	}
	@Override
	public void eval(){
		stmt1.eval();
		stmt2.eval();
	}
}
