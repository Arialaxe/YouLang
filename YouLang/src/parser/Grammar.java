package parser;

import interpreter.SeqStmt;

import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.error.ParseErrorDetails;
import org.codehaus.jparsec.error.ParserException;

public class Grammar {
	
	private String plusOpSetting = " ";
	private String subOpSetting = " ";
	private String mulOpSetting = " ";
	private String divOpSetting = " ";
	private String greaterOpSetting = " ";
	private String equalsSetting = " ";
	private String semiColonSetting = " ";
	private String leftBracketSetting = " ";
	private String rightBracketSetting = " ";
	private String ifSetting = " ";
	private String thenSetting = " ";
	private String elseSetting = " ";
	private String whileSetting = " ";
	private String doSetting = " ";
	private String printSetting = " ";
	
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
	private RootSeqStmt seqStmtNode;
	private RootStmt stmtNode;
	private RootOp opNode;
	
	private OpAppNode opAppNode = new OpAppNode(this, leftBracketNode, rightBracketNode);
	private VarAssignNode varAssignNode = new VarAssignNode(this, varNode, equalsNode);
	private SequenceNode sequenceNode = new SequenceNode(this, semiColonNode);
	private IfThenElseNode ifThenElseNode = new IfThenElseNode(this, ifNode, thenNode, leftBracketNode, rightBracketNode, elseNode);
	private WhileDoNode whileDoNode = new WhileDoNode(this, whileNode, doNode, leftBracketNode, rightBracketNode);
	private PrintStmtNode printStmtNode = new PrintStmtNode(this, printNode, intNode);
	

	public SeqStmt parse (String stringToParse) {
		expNode = new RootExp(this, intNode, varNode, opAppNode);
		seqStmtNode = new RootSeqStmt(this, sequenceNode);
		stmtNode = new RootStmt(this, varAssignNode, ifThenElseNode, whileDoNode, printStmtNode);
		seqStmtNode.setStmtNode(stmtNode);
		
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
		
		//Parser.Reference<SeqStmt> seqStmtRef = new Parser.Reference<SeqStmt>();
		//whileDoNode.setSeqStmtRef(seqStmtRef);
		
		Parser<SeqStmt> parser = seqStmtNode.parser();
		//seqStmtRef.set(parser);
		try {
			return parser.parse(stringToParse);
		}
		catch (ParserException e) {
			throw e; //makes unit testing easier to do this...
		}
		catch (NullPointerException e) {
			System.err.println("You didn't provide any code...");
			return null;
		}
	}
	
	public Boolean settingCheck (String setting) { 
		//if it contains whitespace/is empty/is null
		if (setting == null) return false;
		if (setting.contains(" ")) return false;
		if (setting.equals("")) return false;
		
		//if the string is prefixed by any settings already
		if (setting.startsWith(plusOpSetting) || setting.startsWith(subOpSetting) || 
			setting.startsWith(mulOpSetting) || setting.startsWith(divOpSetting) || 
			setting.startsWith(greaterOpSetting) || setting.startsWith(equalsSetting) ||
			setting.startsWith(semiColonSetting) || setting.startsWith(leftBracketSetting) ||
			setting.startsWith(rightBracketSetting) || setting.startsWith(ifSetting) ||
			setting.startsWith(thenSetting) || setting.startsWith(elseSetting) ||
			setting.startsWith(whileSetting) || setting.startsWith(doSetting) ||
			setting.startsWith(printSetting)) {
			return false;
		}
	
		//if any other setting starts with it
		if (plusOpSetting.startsWith(setting) || subOpSetting.startsWith(setting) || 
			mulOpSetting.startsWith(setting) || divOpSetting.startsWith(setting) || 
			greaterOpSetting.startsWith(setting) || equalsSetting.startsWith(setting) ||
			semiColonSetting.startsWith(setting) || leftBracketSetting.startsWith(setting) ||
			rightBracketSetting.startsWith(setting) || ifSetting.startsWith(setting) ||
			thenSetting.startsWith(setting) || elseSetting.startsWith(setting) ||
			whileSetting.startsWith(setting) || doSetting.startsWith(setting) ||
			printSetting.startsWith(setting)) {
			return false;
		}
		
		return true;
	}
	
	public Grammar (String pl, String su, String mu, String di, 
			String gr, String eq, String se, String le, String ri, 
			String i, String th, String el, String wh, String d, String pr) { //clunky...
		
		if (settingCheck(pl)) {
			plusOpSetting = pl;
		}
		else {
			System.err.println(pl + " is an invalid setting for +");
			plusOpSetting = "+";
		}
		
		if (settingCheck(su)) {
			subOpSetting = su;
		}
		else {
			System.err.println(su + " is an invalid setting for -");
			subOpSetting = "-";
		}
		
		if (settingCheck(mu)) {
			mulOpSetting = mu;
		}
		else {
			System.err.println(mu + " is an invalid setting for *");
			mulOpSetting = "*";
		}
		
		if (settingCheck(di)) {
			divOpSetting = di;
		}
		else {
			System.err.println(di + " is an invalid setting for /");
			divOpSetting = "/";
		}
		
		if (settingCheck(gr)) {
			greaterOpSetting = gr;
		}
		else {
			System.err.println(gr + " is an invalid setting for >");
			greaterOpSetting = ">";
		}
		
		if (settingCheck(eq)) {
			equalsSetting = eq;
		}
		else {
			System.err.println(eq + " is an invalid setting for =");
			equalsSetting = "=";
		}
		
		if (settingCheck(se)) {
			semiColonSetting = se;
		}
		else {
			System.err.println(se + " is an invalid setting for ;");
			semiColonSetting = ";";
		}
		
		if (settingCheck(le)) {
			leftBracketSetting = le;
		}
		else {
			System.err.println(le + " is an invalid setting for (");
			leftBracketSetting = "(";
		}
		
		if (settingCheck(ri)) {
			rightBracketSetting = ri;
		}
		else {
			System.err.println(ri + " is an invalid setting for )");
			rightBracketSetting = ")";
		}
		
		if (settingCheck(i)) {
			ifSetting = i;
		}
		else {
			System.err.println(i + " is an invalid setting for if");
			ifSetting = "if";
		}
		
		if (settingCheck(th)) {
			thenSetting = th;
		}
		else {
			System.err.println(th + " is an invalid setting for then");
			thenSetting = "then";
		}
		
		if (settingCheck(el)) {
			elseSetting = el;
		}
		else {
			System.err.println(el + " is an invalid setting for else");
			elseSetting = "else";
		}
		
		if (settingCheck(wh)) {
			whileSetting = wh;
		}
		else {
			System.err.println(wh + " is an invalid setting for while");
			whileSetting = "while";
		}
		
		if (settingCheck(d)) {
			doSetting = d;
		}
		else {
			System.err.println(d + " is an invalid setting for do");
			doSetting = "do";
		}
		
		if (settingCheck(pr)) {
			printSetting = pr;
		}
		else {
			System.err.println(pr + " is an invalid setting for print");
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

	public boolean setPlusOpSetting(String plusOpSetting) {
		if (settingCheck(plusOpSetting)) {
			this.plusOpSetting = plusOpSetting;
			return true;
		}
		return false;
	}

	public String getSubOpSetting() {
		return subOpSetting;
	}

	public boolean setSubOpSetting(String subOpSetting) {
		if (settingCheck(subOpSetting)) {
			this.subOpSetting = subOpSetting;
			return true;
		}
		return false;
	}

	public String getMulOpSetting() {
		return mulOpSetting;
	}

	public boolean setMulOpSetting(String mulOpSetting) {
		if (settingCheck(mulOpSetting)) {
			this.mulOpSetting = mulOpSetting;
			return true;
		}
		return false;
	}

	public String getDivOpSetting() {
		return divOpSetting;
	}

	public boolean setDivOpSetting(String divOpSetting) {
		if (settingCheck(divOpSetting)) {
			this.divOpSetting = divOpSetting;
			return true;
		}
		return false;
	}

	public String getGreaterOpSetting() {
		return greaterOpSetting;
	}

	public boolean setGreaterOpSetting(String greaterOpSetting) {
		if (settingCheck(greaterOpSetting)) {
			this.greaterOpSetting = greaterOpSetting;
			return true;
		}
		return false;
	}

	public String getEqualsSetting() {
		return equalsSetting;
	}

	public boolean setEqualsSetting(String equalsSetting) {
		if (settingCheck(equalsSetting)) {
			this.equalsSetting = equalsSetting;
			return true;
		}
		return false;
	}

	public String getSemiColonSetting() {
		return semiColonSetting;
	}

	public boolean setSemiColonSetting(String semiColonSetting) {
		if (settingCheck(semiColonSetting)) {
			this.semiColonSetting = semiColonSetting;
			return true;
		}
		return false;
	}

	public String getLeftBracketSetting() {
		return leftBracketSetting;
	}

	public boolean setLeftBracketSetting(String leftBracketSetting) {
		if (settingCheck(leftBracketSetting)) {
			this.leftBracketSetting = leftBracketSetting;
			return true;
		}
		return false;
	}

	public String getRightBracketSetting() {
		return rightBracketSetting;
	}

	public boolean setRightBracketSetting(String rightBracketSetting) {
		if (settingCheck(rightBracketSetting)) {
			this.rightBracketSetting = rightBracketSetting;
			return true;
		}
		return false;
	}

	public String getIfSetting() {
		return ifSetting;
	}

	public boolean setIfSetting(String ifSetting) {
		if (settingCheck(ifSetting)) {
			this.ifSetting = ifSetting;
			return true;
		}
		return false;
	}

	public String getThenSetting() {
		return thenSetting;
	}

	public boolean setThenSetting(String thenSetting) {
		if (settingCheck(thenSetting)) {
			this.thenSetting = thenSetting;
			return true;
		}
		return false;
	}

	public String getElseSetting() {
		return elseSetting;
	}

	public boolean setElseSetting(String elseSetting) {
		if (settingCheck(elseSetting)) {
			this.elseSetting = elseSetting;
			return true;
		}
		return false;
	}

	public String getWhileSetting() {
		return whileSetting;
	}

	public boolean setWhileSetting(String whileSetting) {
		if (settingCheck(whileSetting)) {
			this.whileSetting = whileSetting;
			return true;
		}
		return false;
	}

	public String getDoSetting() {
		return doSetting;
	}

	public boolean setDoSetting(String doSetting) {
		if (settingCheck(doSetting)) {
			this.doSetting = doSetting;
			return true;
		}
		return false;
	}

	public String getPrintSetting() {
		return printSetting;
	}

	public boolean setPrintSetting(String printSetting) {
		if (settingCheck(printSetting)) {
			this.printSetting = printSetting;
			return true;
		}
		return false;
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

	public RootSeqStmt getSeqStmtNode() {
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
