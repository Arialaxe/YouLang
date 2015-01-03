package lexer;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.Scanners;
import org.codehaus.jparsec.Terminals;

public class Lexer {
	
	static String[] ops = {"+","-","*","/",">="}; //operators in the default syntax
	
	static String[] keywords = {"if", "then", "else", "while", "do", "print", ";", "="}; 
	
	private static final Terminals misc = Terminals.caseSensitive(ops, keywords);
	
	//ignoring whitespace & linebreaks
	static final Parser<Void> ignored = Parsers.or(Scanners.JAVA_LINE_COMMENT, 
			Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany();
	
	static final Parser<?> tokeniser = misc.tokenizer().cast().or(Terminals.IntegerLiteral.TOKENIZER);
			
	public static void tokenise () {
		//TODO: work out how to deal with the replacements...
		
		//this is just a basic test for the default syntax
		
	}
}
