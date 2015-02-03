package interpreter;

public class VarExp extends Exp {

	private String varID;
	private IntExp value;
	
	public VarExp (String idRetn) {
		this.varID = idRetn;
		this.value = new IntExp(0); //TODO this is just a default thing so it doesn't complain
	}
	
	/*public VarExp (String varID, IntExp value) {
		this.varID = varID; //I need to do safety checks here
		this.value = value;
	}*/
	@Override
	public int eval(){
		return value.eval();
	}
	
	public void assign(int value) {
		this.value = new IntExp(value); 
	}
	
	public String getID() {
		return varID;
	}
}
