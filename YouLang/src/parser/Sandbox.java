package parser;

import interpreter.IntExp;
import interpreter.Op;
import interpreter.PlusOp;
import interpreter.Stmt;
import interpreter.VarAssignStmt;
import interpreter.VarExp;

import org.codehaus.jparsec.Parser;

public final class Sandbox { //makeshift test bench of sorts...

	static Grammar grammar = new Grammar();
	
	public static void main(String[] args) {
		//testVar("foo"); //works!
		//testVarAssign("foo = 3"); 
		//testIf("if"); //works!
		//testPlus("plus"); //works!
		//testOp("/"); //works!
		//testInt("56"); //works!
		
		System.out.println("*****");
		Stmt stmt = grammar.parse("+");
		
		
		
	
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
		foo.eval();
		System.out.println("Assignment evaluated");
		VarExp bar = foo.getVar();
		System.out.println("VarExp extracted");
		System.out.println("ID: " + bar.getID() + ", value: " + bar.eval());
	}


}
