package parser;

import org.codehaus.jparsec.Parser;
import interpreter.*;

public abstract class Node<T> {
	
	Grammar parent;
	String stringToParse;
	
	public abstract Parser<T> parser();
	
	public void getStringToParse() {
		this.stringToParse = parent.getStringToParse();
	}
	
}
