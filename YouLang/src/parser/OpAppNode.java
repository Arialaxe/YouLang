package parser;

import javafx.scene.Parent;
import interpreter.*;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.misc.*;
import org.codehaus.jparsec.functors.*;

public class OpAppNode extends Node {

	Parser<String> leftBracketParser;
	Parser<Exp> exp1Parser;
	Parser<Op> opParser;
	Parser<Exp> exp2Parser;
	Parser<String> rightBracketParser;
	
	public OpAppNode(Grammar newParent, String leftBracketSetting, String rightBracketSetting) {
		super(newParent);
		leftBracketParser = new LeftBracketNode(parent, leftBracketSetting).parser();
		exp1Parser = new RootExp(parent).parser();
		opParser = new RootOp(parent).parser();
		exp2Parser = new RootExp(parent).parser();
		rightBracketParser = new RightBracketNode(parent, rightBracketSetting).parser();
	}

	@Override
	public Parser<OpAppExp> parser() {
		return Mapper.curry(OpAppExp.class).sequence(leftBracketParser, exp1Parser, opParser, exp2Parser, rightBracketParser);
	}

}
