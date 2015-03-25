package interpreter;

public class Tester {

	public static void main (String args[]) {
		//VarExp var1 = new VarExp("var1", new IntExp (2));
		//VarExp var2 = new VarExp("var2", new IntExp (3));
		//PlusOp plus = new PlusOp();
		//OpAppExp exp = new OpAppExp(plus, var2, var1);
		//System.out.println (exp.eval()); //should print 5
		VarExp var = new VarExp("foo");
		VarAssignStmt assign = new VarAssignStmt(var, null, new IntExp("3")); 
		PrintStmt print = new PrintStmt(null, var);
		Sequence seq = new Sequence(assign, null, print);
		seq.eval();
	}
}
