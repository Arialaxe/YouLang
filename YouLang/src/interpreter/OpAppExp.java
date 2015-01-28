package interpreter;

public class OpAppExp extends Exp {
	
	private Op op;
	private Exp exp1;
	private Exp exp2;
	
	public OpAppExp (String leftBracketRetn, Exp exp1Retn, Op opRetn, Exp exp2Retn, String rightBracketRetn) {
		this.op = opRetn;
		this.exp1 = exp1Retn;
		this.exp2 = exp2Retn;
	}
	
	public OpAppExp (Op op, Exp exp1, Exp exp2) {
		this.op = op;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	@Override
	public int eval(){
		if (op instanceof PlusOp) {
			return exp1.eval() + exp2.eval();
		}
		else if (op instanceof SubOp) {
			return exp1.eval() - exp2.eval();
		}
		else if (op instanceof MulOp) {
			return exp1.eval() * exp2.eval();
		}
		else if (op instanceof DivOp) {
			//TODO: need some error checking here - dividing by 0 etc
			return exp1.eval() / exp2.eval(); //integer division
		}
		else { //N.B. must be GreaterOp if we reach here!!!
			if (exp1.eval() > exp2.eval()) {
				return 1; //C-style booleans - >0 is true
			}
			else return 0;
		}
	}
}
