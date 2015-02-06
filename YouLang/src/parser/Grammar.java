package parser;

import interpreter.*;

import org.codehaus.jparsec.Parser;

public class Grammar {

	private String stringToParse;
	
	private String plusOpSetting;
	private String subOpSetting;
	private String mulOpSetting;
	private String divOpSetting;
	private String greaterOpSetting;
	private String equalsSetting;
	private String semiColonSetting;
	private String leftBracketSetting;
	private String rightBracketSetting;
	private String ifSetting;
	private String thenSetting;
	private String elseSetting;
	private String whileSetting;
	private String doSetting;
	private String printSetting;
	
	private Parser<IntExp> intParser = new IntNode(this).parser();
	private Parser<VarExp> varParser = new VarNode(this).parser();
	private Parser<PlusOp> plusOpParser = new PlusOpNode(this).parser();
	private Parser<SubOp> subOpParser = new SubOpNode(this).parser();
	private Parser<MulOp> mulOpParser = new MulOpNode(this).parser();
	private Parser<DivOp> divOpParser = new DivOpNode(this).parser();
	private Parser<GreaterOp> greaterOpParser = new GreaterOpNode(this).parser();
	private Parser<String> leftBracketParser = new LeftBracketNode(this).parser();
	private Parser<String> rightBracketParser = new RightBracketNode(this).parser();
	private Parser<String> equalsParser = new EqualsNode(this).parser();
	private Parser<String> semiColonParser = new SemiColonNode(this).parser();
	private Parser<String> ifParser = new IfNode(this).parser();
	private Parser<String> thenParser = new ThenNode(this).parser();
	private Parser<String> elseParser = new ElseNode(this).parser();
	private Parser<String> whileParser = new WhileNode(this).parser();
	private Parser<String> doParser = new DoNode(this).parser();
	private Parser<String> printParser = new PrintNode(this).parser();
	
	private Parser<Exp> expParser;
	private Parser<Stmt> seqStmtParser;
	private Parser<Stmt> stmtParser;
	private Parser<Op> opParser;
	
	private Parser<OpAppExp> opAppParser = new OpAppNode(this, leftBracketParser, expParser, opParser, rightBracketParser).parser();
	private Parser<VarAssignStmt> varAssignParser = new VarAssignNode(this, varParser, equalsParser, expParser).parser();
	private Parser<Sequence> sequenceParser = new SequenceNode(this, seqStmtParser, semiColonParser, stmtParser).parser();
	private Parser<IfStmt> ifThenElseParser = new IfThenElseNode(this, ifParser, expParser, thenParser, stmtParser, elseParser).parser();
	private Parser<WhileStmt> whileDoParser = new WhileDoNode(this, whileParser, expParser, doParser, stmtParser).parser();
	private Parser<PrintStmt> printStmtParser = new PrintStmtNode(this, printParser, expParser).parser();
	
	{
		expParser = new RootExp(this, intParser, varParser, opAppParser).parser();
		seqStmtParser = new SeqStmtNode(this, sequenceParser, stmtParser).parser();
		stmtParser = new RootStmt(this, varAssignParser, seqStmtParser, ifThenElseParser, whileDoParser, printStmtParser).parser();
		opParser = new RootOp(this, plusOpParser, subOpParser, mulOpParser, divOpParser, greaterOpParser).parser();
	}

	public void parse () {
		
	}

	public String getStringToParse() {
		return stringToParse;
	}
	
	public Boolean settingCheck (String setting) {
		//TODO 
		return true;
	}
	
	public Grammar (String pl, String su, String mu, String di, 
			String gr, String eq, String se, String le, String ri, 
			String i, String th, String el, String wh, String d, String pr) { //clunky...
		
		if (settingCheck(pl)) {
			plusOpSetting = pl;
		}
		else {
			System.err.println(plusOpSetting + " is an invalid setting for +");
			plusOpSetting = "+";
		}
		
		if (settingCheck(su)) {
			subOpSetting = su;
		}
		else {
			System.err.println(subOpSetting + " is an invalid setting for -");
			subOpSetting = "-";
		}
		
		if (settingCheck(mu)) {
			mulOpSetting = mu;
		}
		else {
			System.err.println(mulOpSetting + " is an invalid setting for *");
			mulOpSetting = "*";
		}
		
		if (settingCheck(di)) {
			divOpSetting = di;
		}
		else {
			System.err.println(divOpSetting + " is an invalid setting for /");
			divOpSetting = "/";
		}
		
		if (settingCheck(gr)) {
			greaterOpSetting = gr;
		}
		else {
			System.err.println(greaterOpSetting + " is an invalid setting for >");
			greaterOpSetting = ">";
		}
		
		if (settingCheck(eq)) {
			equalsSetting = eq;
		}
		else {
			System.err.println(equalsSetting + " is an invalid setting for =");
			equalsSetting = "=";
		}
		
		if (settingCheck(se)) {
			semiColonSetting = se;
		}
		else {
			System.err.println(semiColonSetting + " is an invalid setting for ;");
			semiColonSetting = ";";
		}
		
		if (settingCheck(le)) {
			leftBracketSetting = le;
		}
		else {
			System.err.println(leftBracketSetting + " is an invalid setting for (");
			leftBracketSetting = "(";
		}
		
		if (settingCheck(ri)) {
			rightBracketSetting = ri;
		}
		else {
			System.err.println(rightBracketSetting + " is an invalid setting for )");
			rightBracketSetting = ")";
		}
		
		if (settingCheck(i)) {
			ifSetting = i;
		}
		else {
			System.err.println(ifSetting + " is an invalid setting for if");
			ifSetting = "if";
		}
		
		if (settingCheck(th)) {
			thenSetting = th;
		}
		else {
			System.err.println(thenSetting + " is an invalid setting for then");
			thenSetting = "then";
		}
		
		if (settingCheck(el)) {
			elseSetting = el;
		}
		else {
			System.err.println(elseSetting + " is an invalid setting for else");
			elseSetting = "else";
		}
		
		if (settingCheck(wh)) {
			whileSetting = wh;
		}
		else {
			System.err.println(whileSetting + " is an invalid setting for while");
			whileSetting = "while";
		}
		
		if (settingCheck(d)) {
			doSetting = d;
		}
		else {
			System.err.println(doSetting + " is an invalid setting for do");
			doSetting = "do";
		}
		
		if (settingCheck(pr)) {
			printSetting = pr;
		}
		else {
			System.err.println(printSetting + " is an invalid setting for print");
			printSetting = "print";
		}
		
	}

	public Grammar() { //no arguments provided -> default grammar
		plusOpSetting = "+";
		subOpSetting = "-";
		mulOpSetting = "*";
		divOpSetting = "/";
		greaterOpSetting = ">";
		equalsSetting = "=";
		semiColonSetting = ";";
		leftBracketSetting = "(";
		rightBracketSetting = ")";
		ifSetting = "if";
		thenSetting = "then";
		elseSetting = "else";
		whileSetting = "while";
		doSetting = "do";
		printSetting = "print";
	}

	public String getPlusOpSetting() {
		return plusOpSetting;
	}

	public void setPlusOpSetting(String plusOpSetting) {
		if (settingCheck(plusOpSetting))
		this.plusOpSetting = plusOpSetting;
	}

	public String getSubOpSetting() {
		return subOpSetting;
	}

	public void setSubOpSetting(String subOpSetting) {
		if (settingCheck(subOpSetting))
		this.subOpSetting = subOpSetting;
	}

	public String getMulOpSetting() {
		return mulOpSetting;
	}

	public void setMulOpSetting(String mulOpSetting) {
		if (settingCheck(mulOpSetting))
		this.mulOpSetting = mulOpSetting;
	}

	public String getDivOpSetting() {
		return divOpSetting;
	}

	public void setDivOpSetting(String divOpSetting) {
		if (settingCheck(divOpSetting))
		this.divOpSetting = divOpSetting;
	}

	public String getGreaterOpSetting() {
		return greaterOpSetting;
	}

	public void setGreaterOpSetting(String greaterOpSetting) {
		if (settingCheck(greaterOpSetting))
		this.greaterOpSetting = greaterOpSetting;
	}

	public String getEqualsSetting() {
		return equalsSetting;
	}

	public void setEqualsSetting(String equalsSetting) {
		if (settingCheck(equalsSetting))
		this.equalsSetting = equalsSetting;
	}

	public String getSemiColonSetting() {
		return semiColonSetting;
	}

	public void setSemiColonSetting(String semiColonSetting) {
		if (settingCheck(semiColonSetting))
		this.semiColonSetting = semiColonSetting;
	}

	public String getLeftBracketSetting() {
		return leftBracketSetting;
	}

	public void setLeftBracketSetting(String leftBracketSetting) {
		if (settingCheck(leftBracketSetting))
		this.leftBracketSetting = leftBracketSetting;
	}

	public String getRightBracketSetting() {
		return rightBracketSetting;
	}

	public void setRightBracketSetting(String rightBracketSetting) {
		if (settingCheck(rightBracketSetting))
		this.rightBracketSetting = rightBracketSetting;
	}

	public String getIfSetting() {
		return ifSetting;
	}

	public void setIfSetting(String ifSetting) {
		if (settingCheck(ifSetting))
		this.ifSetting = ifSetting;
	}

	public String getThenSetting() {
		return thenSetting;
	}

	public void setThenSetting(String thenSetting) {
		if (settingCheck(thenSetting))
		this.thenSetting = thenSetting;
	}

	public String getElseSetting() {
		return elseSetting;
	}

	public void setElseSetting(String elseSetting) {
		if (settingCheck(elseSetting))
		this.elseSetting = elseSetting;
	}

	public String getWhileSetting() {
		return whileSetting;
	}

	public void setWhileSetting(String whileSetting) {
		if (settingCheck(whileSetting))
		this.whileSetting = whileSetting;
	}

	public String getDoSetting() {
		return doSetting;
	}

	public void setDoSetting(String doSetting) {
		if (settingCheck(doSetting))
		this.doSetting = doSetting;
	}

	public String getPrintSetting() {
		return printSetting;
	}

	public void setPrintSetting(String printSetting) {
		if (settingCheck(printSetting))
		this.printSetting = printSetting;
	}

	public void setStringToParse(String stringToParse) {
		this.stringToParse = stringToParse;
	}

	public Parser<IntExp> getIntParser() {
		return intParser;
	}

	public Parser<VarExp> getVarParser() {
		return varParser;
	}

	public Parser<PlusOp> getPlusOpParser() {
		return plusOpParser;
	}

	public Parser<SubOp> getSubOpParser() {
		return subOpParser;
	}

	public Parser<MulOp> getMulOpParser() {
		return mulOpParser;
	}

	public Parser<DivOp> getDivOpParser() {
		return divOpParser;
	}

	public Parser<GreaterOp> getGreaterOpParser() {
		return greaterOpParser;
	}

	public Parser<String> getLeftBracketParser() {
		return leftBracketParser;
	}

	public Parser<String> getRightBracketParser() {
		return rightBracketParser;
	}

	public Parser<String> getEqualsParser() {
		return equalsParser;
	}

	public Parser<String> getSemiColonParser() {
		return semiColonParser;
	}

	public Parser<String> getIfParser() {
		return ifParser;
	}

	public Parser<String> getThenParser() {
		return thenParser;
	}

	public Parser<String> getElseParser() {
		return elseParser;
	}

	public Parser<String> getWhileParser() {
		return whileParser;
	}

	public Parser<String> getDoParser() {
		return doParser;
	}

	public Parser<String> getPrintParser() {
		return printParser;
	}

	public Parser<Exp> getExpParser() {
		return expParser;
	}

	public Parser<Stmt> getSeqStmtParser() {
		return seqStmtParser;
	}

	public Parser<Stmt> getStmtParser() {
		return stmtParser;
	}

	public Parser<Op> getOpParser() {
		return opParser;
	}

	public Parser<OpAppExp> getOpAppParser() {
		return opAppParser;
	}

	public Parser<VarAssignStmt> getVarAssignParser() {
		return varAssignParser;
	}

	public Parser<Sequence> getSequenceParser() {
		return sequenceParser;
	}

	public Parser<IfStmt> getIfThenElseParser() {
		return ifThenElseParser;
	}

	public Parser<WhileStmt> getWhileDoParser() {
		return whileDoParser;
	}

	public Parser<PrintStmt> getPrintStmtParser() {
		return printStmtParser;
	}
	
}
