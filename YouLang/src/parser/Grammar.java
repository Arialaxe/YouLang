package parser;

import interpreter.Stmt;

import org.codehaus.jparsec.Parser;

public class Grammar {
	
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
	
	private IntNode intNode = new IntNode(this);
	private VarNode varNode = new VarNode(this);
	private PlusOpNode plusOpNode = new PlusOpNode(this);
	private SubOpNode subOpNode = new SubOpNode(this);
	private MulOpNode mulOpNode = new MulOpNode(this);
	private DivOpNode divOpNode = new DivOpNode(this);
	private GreaterOpNode greaterOpNode = new GreaterOpNode(this);
	private LeftBracketNode leftBracketNode = new LeftBracketNode(this);
	private RightBracketNode rightBracketNode = new RightBracketNode(this);
	private EqualsNode equalsNode = new EqualsNode(this);
	private SemiColonNode semiColonNode = new SemiColonNode(this);
	private IfNode ifNode = new IfNode(this);
	private ThenNode thenNode = new ThenNode(this);
	private ElseNode elseNode = new ElseNode(this);
	private WhileNode whileNode = new WhileNode(this);
	private DoNode doNode = new DoNode(this);
	private PrintNode printNode = new PrintNode(this);
	
	private RootExp expNode;
	private SeqStmtNode seqStmtNode;
	private RootStmt stmtNode;
	private RootOp opNode;
	
	private OpAppNode opAppNode = new OpAppNode(this, leftBracketNode, rightBracketNode);
	private VarAssignNode varAssignNode = new VarAssignNode(this, varNode, equalsNode);
	private SequenceNode sequenceNode = new SequenceNode(this, semiColonNode);
	private IfThenElseNode ifThenElseNode = new IfThenElseNode(this, ifNode, thenNode, elseNode);
	private WhileDoNode whileDoNode = new WhileDoNode(this, whileNode, doNode);
	private PrintStmtNode printStmtNode = new PrintStmtNode(this, printNode);
	

	public Stmt parse (String stringToParse) {
		expNode = new RootExp(this, intNode, varNode, opAppNode);
		seqStmtNode = new SeqStmtNode(this, sequenceNode);
		stmtNode = new RootStmt(this, varAssignNode, seqStmtNode, ifThenElseNode, whileDoNode, printStmtNode);
		//seqStmtNode.setStmtNode(stmtNode);
		opNode = new RootOp(this, plusOpNode, subOpNode, mulOpNode, divOpNode, greaterOpNode);
		
		//opAppNode.setExpNode(expNode);
		opAppNode.setOpNode(opNode);
		varAssignNode.setExpNode(expNode);
		//sequenceNode.setStmtNode(stmtNode);
		//sequenceNode.setSeqStmtNode(seqStmtNode);
		ifThenElseNode.setExpNode(expNode);
		//ifThenElseNode.setStmtNode(stmtNode);
		whileDoNode.setExpNode(expNode);
		//whileDoNode.setStmtNode(stmtNode);
		printStmtNode.setExpNode(expNode);
		
		Parser<Stmt> stmtParser = stmtNode.parser();
		return stmtParser.parse(stringToParse);
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

	public IntNode getIntNode() {
		return intNode;
	}

	public VarNode getVarNode() {
		return varNode;
	}

	public PlusOpNode getPlusOpNode() {
		return plusOpNode;
	}

	public SubOpNode getSubOpNode() {
		return subOpNode;
	}

	public MulOpNode getMulOpNode() {
		return mulOpNode;
	}

	public DivOpNode getDivOpNode() {
		return divOpNode;
	}

	public GreaterOpNode getGreaterOpNode() {
		return greaterOpNode;
	}

	public LeftBracketNode getLeftBracketNode() {
		return leftBracketNode;
	}

	public RightBracketNode getRightBracketNode() {
		return rightBracketNode;
	}

	public EqualsNode getEqualsNode() {
		return equalsNode;
	}

	public SemiColonNode getSemiColonNode() {
		return semiColonNode;
	}

	public IfNode getIfNode() {
		return ifNode;
	}

	public ThenNode getThenNode() {
		return thenNode;
	}

	public ElseNode getElseNode() {
		return elseNode;
	}

	public WhileNode getWhileNode() {
		return whileNode;
	}

	public DoNode getDoNode() {
		return doNode;
	}

	public PrintNode getPrintNode() {
		return printNode;
	}

	public RootExp getExpNode() {
		return expNode;
	}

	public SeqStmtNode getSeqStmtNode() {
		return seqStmtNode;
	}

	public RootStmt getStmtNode() {
		return stmtNode;
	}

	public RootOp getOpNode() {
		return opNode;
	}

	public OpAppNode getOpAppNode() {
		return opAppNode;
	}

	public VarAssignNode getVarAssignNode() {
		return varAssignNode;
	}

	public SequenceNode getSequenceNode() {
		return sequenceNode;
	}

	public IfThenElseNode getIfThenElseNode() {
		return ifThenElseNode;
	}

	public WhileDoNode getWhileDoNode() {
		return whileDoNode;
	}

	public PrintStmtNode getPrintStmtNode() {
		return printStmtNode;
	}

}
