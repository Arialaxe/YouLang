package interpreter;

public class VarExp extends Exp {

	private String varID;
	private IntExp value;
	
	public VarExp (String idRetn) {
		this.varID = idRetn;
		this.value = new IntExp("0"); //TODO this is just a default thing so it doesn't complain
	}

	@Override
	public int eval(){
		return value.eval();
	}
	
	public void assign(int value) {
		this.value = new IntExp(Integer.toString(value)); 
	}
	
	public String getID() {
		return varID;
	}
}
