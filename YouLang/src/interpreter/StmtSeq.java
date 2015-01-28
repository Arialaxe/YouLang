package interpreter;

public class StmtSeq extends Stmt {

	private Stmt stmt1;
	private Stmt stmt2;
	
	public StmtSeq (Stmt stmt1Retn, String semiColonRetn, Stmt stmt2Retn){
		this.stmt1 = stmt1Retn;
		this.stmt2 = stmt2Retn;
	}
	
	public StmtSeq (Stmt stmt1, Stmt stmt2) {
		this.stmt1 = stmt1;
		this.stmt2 = stmt2;
	}
	@Override
	public void eval(){
		stmt1.eval();
		stmt2.eval();
	}
}
