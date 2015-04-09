package interpreter;

import java.util.LinkedList;

public class WhileStmt extends Stmt {

	private Exp exp;
	private SeqStmt stmt;
	
	//return Mapper.curry(WhileStmt.class).sequence(whileParser, expParser, doParser, stmtParser);
	
	public WhileStmt (String whileRetn, Exp expRetn, String doRetn, 
			String leftBracketRetn, SeqStmt stmtRetn, String rightBracketRetn) { //for Mapper function
		this.exp = expRetn;
		this.stmt = stmtRetn;
	}
	
	@Override
	public LinkedList<String> eval(LinkedList<String> output) { 
		while (exp.eval() > 0) { 
			stmt.eval(output);
			
		}
		return output;
	}
	
	
}
