package parser;

import org.codehaus.jparsec.Parser;
import interpreter.*;

public class RootStmt extends Node {

	public RootStmt(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<Stmt> parser() {
		// TODO Auto-generated method stub
		return null;
	}

}
