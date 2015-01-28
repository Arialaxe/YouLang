package parser;

public class Grammar {

	private String stringToParse;
	protected String plusOpSetting;
	protected String subOpSetting;
	protected String mulOpSetting;
	protected String divOpSetting;
	protected String greaterOpSetting;
	protected String equalsSetting;
	protected String semiColonSetting;
	protected String leftBracketSetting;
	protected String rightBracketSetting;
	protected String ifSetting;
	protected String thenSetting;
	protected String elseSetting;
	protected String whileSetting;
	protected String doSetting;
	protected String printSetting;
	
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
	
	public void parse () {
		//TODO: uhh
	}

	public String getStringToParse() {
		return stringToParse;
	}
	
	public Boolean settingCheck (String setting) {
		//TODO 
		return false;
	}
	
}
