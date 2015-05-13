package parser;

import interpreter.SeqStmt;

import java.util.LinkedList;

public class Tests {

	public static void main(String[] args) {
		
		if (fullGrammarTest() && stressTestParserVolume("1500") && 
				stressTestASTVolume("100000", "1500") && edgeTest()) {
			print("\nAll tests succeeded!");
		}
		
		else print("\nTests did not all succeed.");
	}
	
	public static boolean fullGrammarTest() {
		
		print("\nBegin fullGrammarTest().\n");
		
		try {
			Grammar g1 = new Grammar("plus", "sub", "mul", "div", "greater", "equals", 
					"next", "begin", "end", "case", "ifTrue", "ifFalse", "loop", "eval", "display");
			print("fullGrammarTest(): Constructed grammar");
			
			SeqStmt seqStmt = g1.parse(
					  "foo equals 10 next "
					+ "goo equals 10 next "
					+ "loop foo eval begin "
						+ "case goo ifTrue begin "
							+ "goo equals begin goo sub 1 end next " 
							+ "display goo next end "
						+ "ifFalse begin "
							+ "foo equals begin foo sub 1 end next "
						+ "end next "
						+ "display foo next "
					+ "end next "
					+ "goo equals begin 2 mul begin 4 div 2 end end next "
					+ "foo equals begin goo plus foo end next "
					+ "display foo next");
			
			print("fullGrammarTest(): Parsed code input");
			String[] expected = {"9", "10", "8", "10", "7", "10", "6", "10", "5", 
					"10", "4", "10", "3", "10", "2", "10", "1", "10", "0", "10", 
					"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", "4"};
			LinkedList<String> output = seqStmt.eval(new LinkedList<String>());
			print("fullGrammarTest(): Evaluated code");
			
			for (int i = 0; i < output.size(); i++) {
				if(!output.get(i).equals(expected[i])) {
					System.err.println("fullGrammarTest(): Output does not match expected output");
					return false;
				}
			}
			
			String display = "fullGrammarTest(): Output is correct: ";
			for (String s : output) display = display.concat(s + ", ");
			print(display);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean stressTestParserVolume(String ifsParam) {
		
		print("\nBegin stressTestParserVolume with argument " + ifsParam + ". \n");
		Grammar g = new Grammar();
		
		try {
			String stringToParse = "";
			int count = Integer.parseInt(ifsParam);
			while (count > 0) {
				stringToParse = stringToParse.concat("if " + count + " then (print " + count + ";) else (print " + count + ";);");
				count--;
			}
			print("stressTestParserVolume(): Code input string constructed");
			
			SeqStmt seqStmt = g.parse(stringToParse);
			print("stressTestParserVolume(): Parsed string");
			LinkedList<String> output = seqStmt.eval(new LinkedList<String>());
			print("stressTestParserVolume(): Evaluated seqStmt");
			
			if (output.peekFirst().equals(ifsParam) && output.peekLast().equals(Integer.toString(1))) {
				print("stressTestParserVolume(): Correct output: first value " 
							+ output.peekFirst() + ", last value " + output.peekLast());
				return true;
			}
			else {
				System.err.println("stressTestParserVolume(): Incorrect output: first value " 
						+ output.peekFirst() + ", last value " + output.peekLast());
				return false;
			}
		}
		catch (Exception e) {
			System.err.println("stressTestParserVolume(): An exception occurred.");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean stressTestASTVolume(String loopsParam, String nestsParam) {
		
		print("\nBegin stressTestParserVolume with argument for first test " + loopsParam + 
				" and argument for second test " + nestsParam + ". \n");
		
		try {
			
			//first test - testing if the interpreter can time out/overflow on loops
			
			Grammar g = new Grammar();
			String stringToParse = "foo = " + loopsParam + "; print foo; while foo do (foo = (foo - 1);); print foo;";
			print("stressTestASTVolume(): While test code input string constructed");
			SeqStmt seqStmt = g.parse(stringToParse);
			print("stressTestASTVolume(): Parsed while string");
			LinkedList<String> output = seqStmt.eval(new LinkedList<String>());
			print("stressTestASTVolume(): Evaluated while seqStmt");
			
			String first = output.get(0);
			String second = output.get(1);
			if (first.equals(loopsParam) && second.equals("0")) {
				print("stressTestASTVolume(): Output for first test is correct: " 
						+ first + ", " + second);
			}
			
			//second test - checking nesting depth limits
			
			stringToParse = "";
			String valueToPrint = "42";
			int lim = Integer.parseInt(nestsParam); //crashes after 930 nests
			for (int i = 0; i < lim; i++) {
				stringToParse = stringToParse.concat("while 0 do (");
			}
			for (int i = 0; i < lim; i++) {
				stringToParse = stringToParse.concat(");");
			}
			stringToParse = stringToParse.concat(" print " + valueToPrint + ";");
			print("stressTestASTVolume(): Nesting code input string constructed");
			seqStmt = g.parse(stringToParse);
			print("stressTestASTVolume(): Parsed nesting string");
			output = seqStmt.eval(new LinkedList<String>());
			print("stressTestASTVolume(): Evaluated nesting seqStmt");
			String printed = output.peek();
			if (printed.equals(valueToPrint)) {
				print("stressTestASTVolume(): Output for second test is correct: " + printed);
				return true;
			}
			System.err.println("stressTestASTVolume(): Output is incorrect: " + output.removeFirst());
			return false;
		} 
		catch (Exception e) {
			System.err.println("stressTestASTVolume(): An exception occurred.");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean edgeTest() {
		
		print("\nBegin edgeTest().\n");
		
		Grammar g = new Grammar();
		int count = 1000;
		String setting = "";
		
		try {
			while (count > 0) {
				setting = setting.concat("dddddddddddddddddddd"); //that's 20 d's
				count--;
			}
			
			g.setPlusOpSetting(setting);
			print("edgeTest(): Setting successfully set.");
			SeqStmt seqStmt = g.parse("print (6 " + setting + " 4);");
			print("edgeTest(): Code input parsed.");
			LinkedList<String> output = seqStmt.eval(new LinkedList<String>());
			print("edgeTest(): SeqStmt evaluated.");
			if (output.peek().equals("10")) {
				print("edgeTest(): Output is correct: " + output.peek());
				return true;
			}
			System.err.println("edgeTest(): Output is incorrect:" + output.peek() + ", should be 10.");
			return false;
		} 
		catch (Exception e) {
			System.err.println("edgeTest(): An exception occurred.");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
	
}
