package michael;

import org.codehaus.jparsec.Parser;

public abstract class Node<T> {
	public abstract Parser<T> parser();
}
