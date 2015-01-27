package parser;

import org.codehaus.jparsec.Parser;
import interpreter.*;

public class RootExp extends Node {

	public RootExp(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<Exp> parser() {
		// TODO Auto-generated method stub
		return null;
	}

}
