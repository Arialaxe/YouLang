package interpreter;


public class WhileStmt extends Stmt {

	private Exp exp;
	private Stmt stmt;
	
	//return Mapper.curry(WhileStmt.class).sequence(whileParser, expParser, doParser, stmtParser);
	
	public WhileStmt (String whileRetn, Exp expRetn, String doRetn, Stmt stmtRetn) { //for Mapper function
		this.exp = expRetn;
		this.stmt = stmtRetn;
	}
	
	@Override
	public void eval(){ //TODO: make sure this actually works once you implement the printer
		while (exp.eval() > 0) { //remember - C-style logic
			stmt.eval();
		}
	}
	
	
}
