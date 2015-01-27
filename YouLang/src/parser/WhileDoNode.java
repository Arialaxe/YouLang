package parser;

import interpreter.WhileStmt;

import javax.sound.midi.Sequencer;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Parsers;
import org.codehaus.jparsec.functors.*;
import org.codehaus.jparsec.misc.*;
import interpreter.*;

public class WhileDoNode extends Node {

	Parser<String> whileParser;
	Parser<Exp> expParser;
	Parser<String> doParser;
	Parser<Stmt> stmtParser;
	
	public WhileDoNode(Grammar newParent, String whileSetting, String doSetting) {
		super(newParent);
		whileParser = new WhileNode(parent, whileSetting).parser();
		expParser = new RootExp(parent).parser();
		doParser = new DoNode(parent, doSetting).parser();
		stmtParser = new RootStmt(parent).parser();
	}

	@Override
	public Parser<WhileStmt> parser() {
		//TODO: this is a completely placeholdery draft
		
		/*WhileDoMap map = new WhileDoMap();
		
		Parser<String> parser = Parsers.sequence(whileParser, expParser, doParser, stmtParser, 
				new Map4<Parser<String>, Parser<String>, Parser<String>, Parser<String>, WhileStmt>(){
					public WhileStmt map (Parser<String> w, Parser<String> e, Parser<String> d, Parser<String> s) {
						//TODO: AAAARGHGHG
					}
		});*/
		
		return Mapper.curry(WhileStmt.class).sequence(whileParser, expParser, doParser, stmtParser);
	}

}
