package michael;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;

public class StringNode extends Node<String> {
	private String stringToParse = "if";
	
	public Parser<String> parser() {
		return Scanners.stringCaseInsensitive(this.stringToParse).retn(this.stringToParse);
	}
}
