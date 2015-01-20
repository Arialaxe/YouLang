package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;
import interpreter.IntExp;

public class IntNode extends Node {
	
	public IntNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser parser() {
		Parser<Integer> intScan = Scanners.INTEGER.cast();
		return intScan.map(new IntExp());
	}
}
