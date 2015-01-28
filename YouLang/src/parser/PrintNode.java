package parser;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Scanners;

public class PrintNode extends Node {

	public PrintNode(Grammar newParent) {
		super(newParent);
	}

	@Override
	public Parser<String> parser() {
		return Scanners.string(parent.printSetting).retn("print");
	}

}
