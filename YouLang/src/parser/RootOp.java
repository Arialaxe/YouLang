package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import interpreter.*;

public class RootOp extends Node {

	/*static Parser<Op> ops() {
		return Parsers.or(
				Scanners.isChar('+').retn(new PlusOp()),
				Scanners.isChar('-').retn(new SubOp()),
				Scanners.isChar('*').retn(new MulOp()),
				Scanners.isChar('/').retn(new DivOp()),
				Scanners.isChar('>').retn(new GreaterOp()));
	}*/
	
	public RootOp(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		// TODO Auto-generated method stub
		return null;
	}

}
