package parser;

import interpreter.IntExp;
import interpreter.Op;
import interpreter.PlusOp;
import interpreter.SeqStmt;
import interpreter.VarAssignStmt;
import interpreter.VarExp;

import org.codehaus.jparsec.Parser;

public final class Sandbox { //makeshift test bench of sorts...

	static Grammar grammar = new Grammar();
	static Grammar biznatch = new Grammar("addthisbiznatch", "subthisbiznatch", "multiplythisbiznatch", "dividethisbiznatch", 
											"isdisbiggerbiznatch", "isdisthasamebiznatch", "thendothisbiznatch",
											"yo", "mama", "sobiznatch", "yeahbiznatch", "otherwisebiznatch", "whiledisbiznatch", 
											"yallbetterdothisbiznatch", "printthisbiznatch"); 
	static Grammar tester = new Grammar("plus", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
	
	public static void main(String[] args) {
		//testVar("foo"); //works!
		//testVarAssign("foo = 3"); 
		//testIf("if"); //works!
		//testPlus("plus"); //works!
		//testOp("/"); //works!
		//testInt("56"); //works!
		
		/*PlusOpNode plusOpNode = new PlusOpNode(grammar);
		SubOpNode subOpNode = new SubOpNode(grammar);
		MulOpNode mulOpNode = new MulOpNode(grammar);
		DivOpNode divOpNode = new DivOpNode(grammar);
		GreaterOpNode greaterOpNode = new GreaterOpNode(grammar);
		RootOp opNode = new RootOp(grammar, plusOpNode, subOpNode, mulOpNode, divOpNode, greaterOpNode);
		
		IntNode intNode = new IntNode(grammar);
		VarNode varNode = new VarNode(grammar);
		LeftBracketNode leftBracketNode = new LeftBracketNode(grammar);
		RightBracketNode rightBracketNode = new RightBracketNode(grammar);
		OpAppNode opAppNode = new OpAppNode(grammar, leftBracketNode, rightBracketNode);
		opAppNode.setOpNode(opNode);
		
		RootExp expNode = new RootExp(grammar, intNode, varNode, opAppNode);
		Parser<Exp> expParser = expNode.parser();
		System.out.println(expParser.parse("((((3*4)/4)+5)-foo)").eval());
		
		
		
		System.out.println("*****");
		PrintStmtNode printStmtNode = new PrintStmtNode(grammar, new PrintNode(grammar), new IntNode(grammar));
		printStmtNode.setExpNode(expNode);
		Parser<PrintStmt> parser = printStmtNode.parser();
		parser.parse("print (6+6)").eval();*/
		
		System.out.println("*****");
		//SeqStmt stmt = grammar.parse("print 6");
		SeqStmt stmt = grammar.parse("print foo; foo = 3; print foo; foo = 0; if foo then (print 2; print 3) else (print 4; print 5)");
		stmt.eval();
		/*System.out.println(stmt.getClass().getName());
		VarAssignStmt vs = (VarAssignStmt) stmt;
		VarExp var = vs.getVar();
		System.out.println("Var id: " + var.getID() + ", value: " + var.eval());*/
		System.out.println("*****");
		SeqStmt biznatchStmt = biznatch.parse("printthisbiznatch 6000 thendothisbiznatch printthisbiznatch yo 900 addthisbiznatch 400 mama");
		biznatchStmt.eval();
		SeqStmt stmt2 = tester.parse("print (2 plus 2)");
		stmt2.eval();
		
		
	
		/*final Parser<PlusOp> IGNORED =
			      Parsers.or(Scanners.JAVA_LINE_COMMENT, Scanners.JAVA_BLOCK_COMMENT, Scanners.WHITESPACES).skipMany().cast();
		Parser<PlusOp> p = new PlusOpNode(new Grammar()).parser();
		Parser<PlusOp> g = Parsers.sequence(IGNORED, p);
		PlusOp foo = g.parse("+");
		System.out.println("***WHITESPACE FIDDLING***");
		System.out.println("Return type: " + foo.getClass().getName());*/
	}
	

	public static void testInt(String s) {
		System.out.println("***TESTING INT PARSER***");
		Parser<IntExp> p = new IntNode(new Grammar()).parser();
		System.out.println("Parser made");
		IntExp foo = p.parse(s);
		System.out.println("String parsed");
		System.out.println("Return value: " + foo.eval());
	
	}


	public static void testOp(String s) {
		System.out.println("***TESTING OP PARSER***");
		Parser<Op> p = grammar.getOpNode().parser();
		System.out.println("Parser made");
		Op foo = p.parse(s);
		System.out.println("String parsed");
		System.out.println("Return type: " + foo.getClass().getName());
	}
	
	public static void testPlus(String s) {
		System.out.println("***TESTING PLUS PARSER***");
		Grammar g = new Grammar();
		g.setPlusOpSetting("plus");
		Parser<PlusOp> p  = new PlusOpNode(g).parser();
		System.out.println("Parser made");
		PlusOp foo = p.parse(s);
		System.out.println("String parsed");
		System.out.println("Return type: " + foo.getClass().getName());
	}

	public static void testIf(String s) { 
		System.out.println("***TESTING IF PARSER***");
		Parser<String> p  = new IfNode(new Grammar()).parser();
		System.out.println("Parser made");
		String foo = p.parse(s);
		System.out.println("String parsed");
		System.out.println("Return value: " + foo);
	}

	public static void testVar(String s) { 
		System.out.println("***TESTING VAR PARSER***");
		Parser<VarExp> p = new VarNode(new Grammar()).parser();
		System.out.println("Parser made");
		VarExp foo = p.parse("foo");
		System.out.println("String parsed");
		System.out.println("ID: " + foo.getID() + ", value: " + foo.eval());
	}
	
	public static void testVarAssign(String s) { 
		System.out.println("***TESTING VAR ASSIGN PARSER***");
		Parser<VarAssignStmt> p = grammar.getVarAssignNode().parser();
		System.out.println("Parser made");
		VarAssignStmt foo = p.parse(s);
		System.out.println("String parsed");
		foo.eval(new LinkedList());
		System.out.println("Assignment evaluated");
		VarExp bar = foo.getVar();
		System.out.println("VarExp extracted");
		System.out.println("ID: " + bar.getID() + ", value: " + bar.eval());
	}


}
