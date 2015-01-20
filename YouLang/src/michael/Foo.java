package michael;

import java.util.List;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Tokens.Tag;
import org.codehaus.jparsec.misc.Mapper;

public class Foo {
	enum Operators {
		Plus,
		Minus,
		Mult,
		Div
	}
	
	static Parser<Operators> ops() {
		return Parsers.or(
				Scanners.isChar('+').retn(Operators.Plus),
				Scanners.isChar('-').retn(Operators.Minus));
	}
	
	
	
	static Parser<List<Operators>> bar() {
		return ops().many();
	}
	
	static final Parser<List<Operators>> FOO = bar();
}
