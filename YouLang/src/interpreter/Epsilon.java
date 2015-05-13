package interpreter;

import java.util.LinkedList;

public class Epsilon extends SeqStmt {

	@Override
	public LinkedList<String> eval(LinkedList<String> output) {
		// does nothing
		return output;
	}
	
}
